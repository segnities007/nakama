package com.segnities007.nakama.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import io.github.jan.supabase.SupabaseClient

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: SplashViewModel = SplashViewModel(),
    supabaseClient: SupabaseClient,
){
    LaunchedEffect(Unit) {
        viewModel.init(navController = navController, supabaseClient = supabaseClient)
    }
}