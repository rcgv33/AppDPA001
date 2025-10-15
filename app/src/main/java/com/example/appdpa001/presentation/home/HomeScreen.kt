package com.example.appdpa001.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.appdpa001.data.model.CountryModel

val mockCountries = listOf(
    CountryModel("Colombia", 11, "https://flagcdn.com/w320/co.jpg"),
    CountryModel("Ecuador", 13, "https://flagcdn.com/w320/ec.jpg"),
    CountryModel("Peru", 60, "https://flagcdn.com/w320/pe.jpg"),
    CountryModel("Venezuela", 40, "https://flagcdn.com/w320/ve.jpg"),
    CountryModel("Bolivia", 38, "https://flagcdn.com/w320/bo.jpg"),
    CountryModel("Chile", 70, "https://flagcdn.com/w320/cl.jpg"),
    CountryModel("Argentina", 1, "https://flagcdn.com/w320/ar.jpg"),
    )

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text("Ranking FIFA 2025", style = MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(mockCountries) { country ->
                Card(
                    modifier = Modifier.fillMaxSize().padding(vertical = 16.dp)

                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(country.imageURL),
                            contentDescription = country.name,
                            //contentScale = ContentScale.Crop,
                            modifier = Modifier.size(64.dp).padding(end = 16.dp)
                            )
                        Column{
                            Text(country.name, style = MaterialTheme.typography.titleMedium)
                            Text(country.ranking.toString(), style = MaterialTheme.typography.bodyMedium)

                        }
                    }
                }
            }

        }
    }
}