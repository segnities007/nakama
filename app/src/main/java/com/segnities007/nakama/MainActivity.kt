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
import com.segnities007.nakama.ui.screens.home.HomeViewModel
import com.segnities007.nakama.ui.screens.login.Login
import com.segnities007.nakama.ui.screens.login.LoginViewModel
import com.segnities007.nakama.ui.screens.splash.Splash
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val supabaseClient = createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.SUPABASE_KEY
        ){
            install(Auth)
            install(Postgrest)
        }

        enableEdgeToEdge()
        setContent {
            NakamaTheme {
                    Router(supabaseClient = supabaseClient)
            }
        }
    }
}

@Composable
private fun Router(
    supabaseClient: SupabaseClient
){

    val navController = rememberNavController()
    val splash = "/"
    val login = "/login"
    val home = "/home"

    NavHost(
        navController = navController,
        startDestination = splash,
    ){
        composable(splash){Splash(navController = navController, supabaseClient = supabaseClient) }
        composable(login){ Login(navController = navController, supabaseClient = supabaseClient, viewModel = LoginViewModel(supabaseClient)) }
        composable(home){ Home(navController, viewModel = HomeViewModel(supabaseClient = supabaseClient)) }
    }

}
