package com.example.jetpackcompose.jetpacknavigation

sealed class Screen(val route: String){
    object MainScreen: Screen(route = "main_screen")
    object DetailScreen: Screen(route = "detail_screen")
}
