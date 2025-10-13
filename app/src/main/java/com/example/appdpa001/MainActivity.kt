package com.example.appdpa001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdpa001.presentation.auth.LoginScreen
import com.example.appdpa001.presentation.auth.RegisterScreen
import com.example.appdpa001.presentation.navigation.AppNavGraph
import com.example.appdpa001.ui.theme.AppDPA001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDPA001Theme {
                AppNavGraph()
            }
        }
    }
}

