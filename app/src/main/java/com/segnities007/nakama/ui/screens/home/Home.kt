package com.segnities007.nakama.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.headers.HeaderHome
import com.segnities007.nakama.data.model.navigations.NavigationHome
import com.segnities007.nakama.ui.components.navigationBar.NavigationBar
import com.segnities007.nakama.ui.components.header.Header
import com.segnities007.nakama.ui.components.navigationDrawer.NavigationDrawer

//drawerを処理
@Composable
fun Home(
    navController: NavHostController,
    homeViewModel: HomeViewModel = HomeViewModel(),
){
    NavigationDrawer(
        homeViewModel = homeViewModel,
        content = {HomeScreen(navController = navController, homeViewModel = homeViewModel)},
        navigation = NavigationHome(),
    )
}

//Scaffoldを処理
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavHostController,
){
    Scaffold(
        topBar = { Header(homeViewModel = homeViewModel, headerInfo = HeaderHome()) },
        bottomBar = {NavigationBar(navigation = NavigationHome(), homeViewModel = homeViewModel)},
    ){ innerPadding ->
        HomeUI(modifier = Modifier.padding(innerPadding), homeViewModel)
    }
}

@Composable
private fun HomeUI(
    modifier: Modifier,
    homeViewModel: HomeViewModel,
){
    val index by homeViewModel.index.collectAsState()
    Text(index.toString(), fontSize = 500.sp)
}