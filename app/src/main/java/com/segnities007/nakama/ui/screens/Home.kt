package com.segnities007.nakama.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.headers.HeaderHome
import com.segnities007.nakama.ui.components.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            Header(
                headerHome = HeaderHome(),
                navController = navController,
            )
        }
    ){ innerPadding ->
        HomeUI(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun HomeUI(
    modifier: Modifier = Modifier
){

}