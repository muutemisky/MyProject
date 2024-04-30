package com.example.miskysapplication.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.miskysapplication.ui.theme.screens.attenda
import com.example.miskysapplication.ui.theme.screens.home.HomeScreen
//import com.example.miskysapplication.ui.theme.screens.login.LoginScreen
import java.lang.reflect.Modifier

@Composable
fun AppNavHost(modifier: Modifier= Modifier(),
               navController:NavHostController= rememberNavController(),
               startDestination :String= ROUTE_HOME) {
    NavHost(
        navController = navController,

        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            (navController)
        }

    }
}

