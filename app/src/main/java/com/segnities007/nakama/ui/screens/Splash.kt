package com.segnities007.nakama.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.navigations.NavigationHome
import com.segnities007.nakama.ui.components.NavigationDrawer
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Splash(navController: NavHostController){
    NavigationDrawer(
        content = {Home(navController)},
        navigation = NavigationHome()
    )
}