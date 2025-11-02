package com.example.appdpa001.presentation.Apifootball

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdpa001.data.remote.apifootball.ApiFootballViewModel

@Composable
fun ApiFootballScreen(viewModel: ApiFootballViewModel = viewModel()) {

    val countries by viewModel.countries.collectAsState()
    val selectedCountry by viewModel.selectedCountry.collectAsState()
    val teams by viewModel.teams.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessages by viewModel.errorMessages.collectAsState()

    var expanded by remember { mutableStateOf(false) }

    Column (modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Text(text = "Equipos de Futbol por Pais")





    }



}