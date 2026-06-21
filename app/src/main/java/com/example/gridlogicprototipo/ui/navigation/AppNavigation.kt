package com.example.gridlogicprototipo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridlogicprototipo.ui.screen.HomeScreen
import com.example.gridlogicprototipo.ui.screen.ResultsScreen
import com.example.gridlogicprototipo.ui.screen.exercises.TestScreen
import com.example.gridlogicprototipo.ui.viewmodel.GridLogicViewModel

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val gridViewModel: GridLogicViewModel = viewModel()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onEmpezar = {
                    gridViewModel.iniciarTest()
                    navController.navigate(Test)
                },
                modifier = modifier
            )
        }
        composable<Test> {
            TestScreen(
                viewModel = gridViewModel,
                onTestTerminado = {
                    navController.navigate(Results) {
                        popUpTo(Home) { inclusive = false }
                    }
                },
                modifier = modifier
            )
        }
        composable<Results> {
            ResultsScreen(
                onGoHome = {
                    navController.navigate(Home) {
                        popUpTo(Home) { inclusive = true }
                    }
                },
                modifier = modifier
            )
        }
    }
}