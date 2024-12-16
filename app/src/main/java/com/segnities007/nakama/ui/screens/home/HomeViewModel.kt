package com.segnities007.nakama.ui.screens.home

import android.util.Log
import androidx.compose.material3.DrawerValue
import androidx.lifecycle.ViewModel
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import io.github.jan.supabase.SupabaseClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    val supabaseClient: SupabaseClient,
): ViewModel(), DrawerViewModel {

    private val _index = MutableStateFlow(0)
    override val index: StateFlow<Int> = _index

    private var _drawerState = MutableStateFlow<DrawerValue>(DrawerValue.Closed)
    override val drawerState: StateFlow<DrawerValue> = _drawerState

    override fun openDrawer(){
        Log.d("test", "openDrawer")
        _drawerState.value = DrawerValue.Open
    }

    override fun closeDrawer(){
        Log.d("test", "closeDrawer")
        _drawerState.value = DrawerValue.Closed
    }

    override fun updateIndex(index: Int){
        Log.d("test", "updateIndex")
        _index.value =  index
    }
}