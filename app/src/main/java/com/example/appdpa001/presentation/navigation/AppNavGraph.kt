package com.example.appdpa001.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdpa001.presentation.auth.LoginScreen
import com.example.appdpa001.presentation.auth.RegisterScreen
import com.example.appdpa001.presentation.home.HomeScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home")
    {
        composable(route = "register"){RegisterScreen(navController)}
        composable(route = "login"){LoginScreen(navController)}
        composable(route = "home"){HomeScreen()}
    }

}