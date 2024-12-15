package com.segnities007.nakama.ui.screens.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.model.headers.HeaderLogin
import com.segnities007.nakama.data.model.navigations.NavigationHome
import com.segnities007.nakama.data.model.navigations.NavigationLogin
import com.segnities007.nakama.ui.components.header.Header
import com.segnities007.nakama.ui.components.navigationBar.NavigationBar
import com.segnities007.nakama.ui.components.navigationDrawer.NavigationDrawer
import androidx.compose.runtime.getValue
import com.segnities007.nakama.ui.screens.login.signIn.SignIn
import com.segnities007.nakama.ui.screens.login.signUp.SignUp

@Composable
fun Login(
    navController: NavHostController,
    viewModel: DrawerViewModel = LoginViewModel(),
){
    NavigationDrawer(
        viewModel = viewModel,
        navigation = NavigationLogin(),
    ){
        LoginScreen(navController = navController, viewModel =  viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DrawerViewModel,
){
    Scaffold(
        topBar = { Header(viewModel = viewModel, headerInfo = HeaderLogin()) },
        bottomBar = {NavigationBar(navigation = NavigationLogin(), viewModel = viewModel)},
    ){ innerPadding ->
        LoginUI(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
    }
}

@Composable
private fun LoginUI(
    modifier: Modifier = Modifier,
    viewModel: DrawerViewModel,
){
    val index by viewModel.index.collectAsState()

    when(index){
        0 -> SignIn(modifier = modifier, viewModel = viewModel)
        1 -> SignUp(modifier = modifier, viewModel = viewModel)
    }
}