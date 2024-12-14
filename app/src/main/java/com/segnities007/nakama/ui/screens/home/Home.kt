package com.segnities007.nakama.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.model.headers.HeaderHome
import com.segnities007.nakama.data.model.navigations.NavigationHome
import com.segnities007.nakama.ui.components.navigationBar.NavigationBar
import com.segnities007.nakama.ui.components.header.Header
import com.segnities007.nakama.ui.components.navigationDrawer.NavigationDrawer

//drawerを処理
@Composable
fun Home(
    navController: NavHostController,
    viewModel: DrawerViewModel = HomeViewModel(),
){
    NavigationDrawer(
        viewModel = viewModel,
        navigation = NavigationHome(),
    ){
        HomeScreen(navController = navController, viewModel = viewModel)
    }
}

//Scaffoldを処理
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    viewModel: DrawerViewModel,
    navController: NavHostController,
){
    Scaffold(
        topBar = { Header(viewModel = viewModel, headerInfo = HeaderHome()) },
        bottomBar = {NavigationBar(navigation = NavigationHome(), viewModel = viewModel)},
    ){ innerPadding ->
        HomeUI(modifier = Modifier.padding(innerPadding))
    }
}

//HomeのメインUI
@Composable
private fun HomeUI(
    modifier: Modifier,

){

    Column(
        modifier = modifier
    ){
        Text("test")
    }

}