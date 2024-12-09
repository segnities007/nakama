package com.segnities007.nakama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.segnities007.nakama.ui.theme.NakamaTheme
import com.segnities007.nakama.ui.screens.home.Home
import com.segnities007.nakama.ui.screens.Login
import com.segnities007.nakama.ui.screens.Splash
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NakamaTheme {
                    Router()
            }
        }
    }
}

@Composable
private fun Router(){

    val navController = rememberNavController()
    val splash = "/"
    val login = "/login"
    val home = "/home"

    NavHost(
        navController = navController,
        startDestination = home, //TODO change home to splash
    ){
        composable(splash){Splash(navController) }
        composable(login){ Login() }
        composable(home){ Home(navController) }
    }

}
