package com.app.mytaskcompose.navigation

import com.app.mytaskcompose.R

object ConstantBottom {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = R.drawable.bottom_ic_home,
            route = Screens.HomeScreen.name
        ),
        BottomNavItem(
            label = "Chat",
            icon = R.drawable.bottom_ic_messages,
            route = Screens.MessageScreen.name
        ),
        BottomNavItem(
            label = "",
            icon = R.drawable.bottom_ic_add,
            route = Screens.CreateTaskScreen.name
        ),
        BottomNavItem(
            label = "Calendar",
            icon = R.drawable.bottom_ic_calendar,
            route = Screens.ScheduleScreen.name
        ),
        BottomNavItem(
            label = "Notification",
            icon = R.drawable.bottom_ic_notification,
            route = Screens.NotificationScreen.name
        )
    )
}

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: String
)