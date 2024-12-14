package com.segnities007.nakama.ui.screens.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.model.navigations.NavigationHome
import com.segnities007.nakama.ui.components.navigationDrawer.NavigationDrawer
import com.segnities007.nakama.ui.screens.home.HomeViewModel

@Composable
fun Login(){

}

@Composable
fun Login(
    navController: NavHostController,
    viewModel: DrawerViewModel = LoginViewModel(),
//    homeViewModel: HomeViewModel = HomeViewModel(),
){
    NavigationDrawer(
        viewModel = viewModel,
        navigation = NavigationHome(),
    ){
//        HomeScreen(navController = navController, homeViewModel = homeViewModel)
    }
}