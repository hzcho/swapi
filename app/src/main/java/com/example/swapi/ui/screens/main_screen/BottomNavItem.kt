package com.example.swapi.ui.screens.main_screen

import com.example.swapi.R
import com.example.swapi.ui.util.Routes

sealed class BottomNavItem(val title:String, val id:Int, val route:String) {
    data object HomeItem:BottomNavItem("Home", R.drawable.icon_home, Routes.HOME_SCREEN)
    data object FavoritesItem:BottomNavItem("Favorites", R.drawable.icon_favorites, Routes.FAVORITES_SCREEN)
    data object SettingsItem:BottomNavItem("Settings", R.drawable.icon_settings, Routes.SETTINGS_SCREEN)
}