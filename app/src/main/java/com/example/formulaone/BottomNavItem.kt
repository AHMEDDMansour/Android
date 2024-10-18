package com.example.formulaone




sealed class BottomNavItem(val route: String, val label: String) {
    object News : BottomNavItem("news", "News")
    object Events : BottomNavItem("events", "Events")
    object Profile : BottomNavItem("profile", "Profile")
    object About : BottomNavItem("about", "About")
    object Menu : BottomNavItem ("menu" , "Menu")
    object Standing : BottomNavItem ("Standing" , "Standing")

}

