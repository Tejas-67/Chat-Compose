package com.example.chat_with_compose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chat_with_compose.screens.ChatScreen
import com.example.chat_with_compose.screens.HomeScreen
import com.example.chat_with_compose.screens.StartScreen


@Composable
fun MainNavigation(context: Context){
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = Start
    ){
        composable(Start){
            StartScreen(
                navHostController,
                context
            )
        }
        composable(Home){
            HomeScreen(
                navHostController
            )
        }
        composable(Chat){
            ChatScreen(
                navHostController
            )
        }
    }
}

const val Start = "start_screen"
const val Home = "home_screen"
const val Chat = "chat_screen"