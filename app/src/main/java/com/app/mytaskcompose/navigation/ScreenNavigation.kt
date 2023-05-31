package com.app.mytaskcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.mytaskcompose.SplashScreens
import com.app.mytaskcompose.screens.*

@Composable
fun ScreenNavigation(navController: NavHostController, bottomBarState: MutableState<Boolean>) {

    NavHost(navController = navController, startDestination = Screens.SplashScreen.name) {
        composable(Screens.SplashScreen.name) {
            bottomBarState.value = false
            SplashScreens(navController = navController)
        }
        composable(Screens.SignUpScreen.name) {
            bottomBarState.value = false
            SignupScreen(navController = navController)
        }
        composable(Screens.LoginScreen.name) {
            bottomBarState.value = false
            LoginScreen(navController = navController)
        }
        composable(Screens.HomeScreen.name) {
            bottomBarState.value = true
            HomeScreen(navController = navController)
        }

        composable(Screens.TaskDetailScreen.name) {
            bottomBarState.value = false
            TaskDetailScreen(navController = navController)
        }

        composable(Screens.MessageScreen.name) {
            bottomBarState.value = true
            MessagesScreen(navController = navController)
        }

        composable(Screens.ChatScreen.name) {
            bottomBarState.value = false
            ChatScreen(navController = navController)
        }

        composable(Screens.NewMessageScreen.name) {
            bottomBarState.value = false
            ContactScreen(navController = navController)
        }

        composable(Screens.GroupScreen.name) {
            bottomBarState.value = false
            GroupScreen(navController = navController)
        }

        composable(Screens.ScheduleScreen.name) {
            bottomBarState.value = true
            ScheduleScreen(navController = navController)
        }

        composable(Screens.CreateTaskScreen.name) {
            bottomBarState.value = true
            CreateTaskScreen(navController = navController)
        }

        composable(Screens.NotificationScreen.name) {
            bottomBarState.value = true
            NotificationScreen(navController = navController)
        }

        composable(Screens.ProfileScreen.name) {
            bottomBarState.value = true
            ProfileScreen(navController = navController)
        }
    }
}
