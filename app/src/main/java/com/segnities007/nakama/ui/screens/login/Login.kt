package com.segnities007.nakama.ui.screens.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.headers.HeaderLogin
import com.segnities007.nakama.data.model.navigations.NavigationLogin
import com.segnities007.nakama.ui.components.header.Header
import com.segnities007.nakama.ui.components.navigationBar.NavigationBar
import com.segnities007.nakama.ui.components.navigationDrawer.NavigationDrawer
import androidx.compose.runtime.getValue
import com.segnities007.nakama.data.model.navigations.Navigation
import com.segnities007.nakama.ui.screens.login.signIn.SignIn
import com.segnities007.nakama.ui.screens.login.signUp.SignUp
import io.github.jan.supabase.SupabaseClient

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginViewModel,
    supabaseClient: SupabaseClient,
    navigation: Navigation = NavigationLogin(),
){
    NavigationDrawer(
        viewModel = viewModel,
        navigation = navigation,
    ){
        LoginScreen(navController = navController, viewModel =  viewModel, supabaseClient = supabaseClient, navigation = navigation)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: LoginViewModel,
    supabaseClient: SupabaseClient,
    navigation: Navigation,
){
    Scaffold(
        topBar = { Header(viewModel = viewModel, headerInfo = HeaderLogin()) },
        bottomBar = {NavigationBar(navigation = navigation, viewModel = viewModel)},
    ){ innerPadding ->
        LoginUI(modifier = Modifier.padding(innerPadding), viewModel = viewModel, navController = navController, supabaseClient = supabaseClient)
    }
}

@Composable
private fun LoginUI(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    supabaseClient: SupabaseClient,
    navController: NavHostController,
){
    val index by viewModel.index.collectAsState()

    when(index){
        0 -> SignIn(modifier = modifier, viewModel = viewModel, onClick = {viewModel.signIn(navController = navController, supabaseClient = supabaseClient)})
        1 -> SignUp(modifier = modifier, viewModel = viewModel, onClick = {viewModel.signUp(navController = navController, supabaseClient = supabaseClient)})
    }
}