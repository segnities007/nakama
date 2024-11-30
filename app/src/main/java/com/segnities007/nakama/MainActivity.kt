package com.segnities007.nakama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.segnities007.nakama.ui.screens.Home
import com.segnities007.nakama.ui.screens.Login
import com.segnities007.nakama.ui.screens.Splash
import com.segnities007.nakama.ui.theme.NakamaTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NakamaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Router(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun Router(
    modifier: Modifier
){
    val navController = rememberNavController()

    val splash = "/"
    val login = "/login"
    val home = "/home"

    NavHost(
        navController = navController,
        startDestination = splash,

    ){
        composable(splash){
            Splash()
        }
        composable(login){
            Login()
        }
        composable(home){
            Home()
        }
    }
}
