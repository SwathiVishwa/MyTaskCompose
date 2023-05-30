package com.app.mytaskcompose.navigation

enum class Screens {
    SplashScreen,
    LoginScreen,
    SignUpScreen,
    HomeScreen,
    TaskDetailScreen,
    MessageScreen,
    ChatScreen,
    NewMessageScreen,
    GroupScreen,
    ScheduleScreen,
    CreateTaskScreen,
    NotificationScreen,
    ProfileScreen;

    companion object {
        fun fromRoute(route: String?): Screens = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            SignUpScreen.name -> SignUpScreen
            HomeScreen.name -> HomeScreen
            TaskDetailScreen.name -> TaskDetailScreen
            MessageScreen.name -> MessageScreen
            ChatScreen.name -> ChatScreen
            NewMessageScreen.name -> NewMessageScreen
            GroupScreen.name -> GroupScreen
            ScheduleScreen.name -> ScheduleScreen
            CreateTaskScreen.name -> CreateTaskScreen
            NotificationScreen.name -> NotificationScreen
            ProfileScreen.name -> ProfileScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}