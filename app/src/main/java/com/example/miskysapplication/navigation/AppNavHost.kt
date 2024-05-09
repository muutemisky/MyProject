package com.example.miskysapplication.navigation

//import LoginScreen
import UpdateStudentScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.miskysapplication.ui.theme.screens.Stu.ViewProductsScreen
import com.example.miskysapplication.ui.theme.screens.attendance.AddStudentScreen
//import com.example.miskysapplication.ui.theme.screens.attendance.
import com.example.miskysapplication.ui.theme.screens.dashboard.DashboardScreen
//import com.example.miskysapplication.ui.theme.screens.attendance
import com.example.miskysapplication.ui.theme.screens.home.HomeScreen
import com.example.miskysapplication.ui.theme.screens.login.LoginScreen
import com.example.miskysapplication.ui.theme.screens.register.RegisterScreen
//import com.example.miskysapplication.ui.theme.screens.login.LoginScreen
import java.lang.reflect.Modifier

@Composable
fun AppNavHost(modifier: Modifier= Modifier(),
               navController:NavHostController= rememberNavController(),
               startDestination :String= ROUTE_REGISTER) {
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
            RegisterScreen(navController)
        }
        composable(ROUTE_ADD_Student) {
            AddStudentScreen(navController)
        }
        composable(ROUTE_UPDATE_STUDENT) {
            UpdateStudentScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_VIEW_STUDENT) {
            (navController)

        }
    }
}

fun UpdateStudentScreen(navController: NavController) {
    TODO("Not yet implemented")
}

