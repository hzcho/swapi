package com.example.swapi.ui.screens.main_screen

import com.example.swapi.R

sealed class BottomNavItem(val title:String, val id:Int, val route:String) {
    data object HomeItem:BottomNavItem("Home", R.drawable.icon_home, "home_screen")
    data object FavoritesItem:BottomNavItem("Favorites", R.drawable.icon_favorites, "favorites_screen")
    data object SettingsItem:BottomNavItem("Settings", R.drawable.icon_settings, "settings_screen")
}