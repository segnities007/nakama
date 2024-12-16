package com.segnities007.nakama.ui.screens.splash

import android.util.Log
import androidx.compose.material3.DrawerValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SplashViewModel (
): ViewModel(), DrawerViewModel {

    fun init(
        supabaseClient: SupabaseClient,
        navController: NavHostController,
    ){
        val isLoggedIn = supabaseClient.auth.currentSessionOrNull()?.user != null
        if(isLoggedIn){
            navController.navigate("/home")
        }else{
            navController.navigate("/login")
        }
    }


    private val _index = MutableStateFlow(0)
    override val index: StateFlow<Int> = _index

    private var _drawerState = MutableStateFlow<DrawerValue>(DrawerValue.Closed)
    override val drawerState: StateFlow<DrawerValue> = _drawerState

    override fun openDrawer(){
        _drawerState.value = DrawerValue.Open
    }

    override fun closeDrawer(){
        _drawerState.value = DrawerValue.Closed
    }

    override fun updateIndex(index: Int){
        _index.value =  index
    }
}