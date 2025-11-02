package com.example.appdpa001.data.remote.apifootball

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiFootballViewModel: ViewModel() {

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val _selectedCountry = MutableStateFlow<Country?>(null)
    val selectedCountry: StateFlow<Country?> = _selectedCountry

    private val _teams = MutableStateFlow<List<TeamWrapper>>(emptyList())
    val teams: StateFlow<List<TeamWrapper>> = _teams

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessages = MutableStateFlow<String?>(null)
    val errorMessages: StateFlow<String?> = _errorMessages

    init {
        loadCountries()
    }
    fun loadCountries() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getCountries()
                _countries.value = response.response.sortedBy { it.name }
                _errorMessages.value = null

        } catch (e: Exception) {
            _errorMessages.value = "Error al obtener los paises: ${e.message}"
        }finally {
            _isLoading.value = false
        }
        }
    }
    fun onCountrySelected(country: Country) {
        _selectedCountry.value = country
        loadTeamsByCountry(country.name)
    }
    private fun loadTeamsByCountry(country: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getTeamsByCountry(country)
                _teams.value = response.response
                _errorMessages.value = null
            } catch (e: Exception) {
                _errorMessages.value = "Error al obtener los equipos: ${e.message}"
                _teams.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}