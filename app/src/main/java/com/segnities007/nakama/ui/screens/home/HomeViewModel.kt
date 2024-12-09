package com.segnities007.nakama.ui.screens.home

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    //    @ApplicationContext val context: Application,
): ViewModel() {
    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index

    private var _drawerState = MutableStateFlow<DrawerValue>(DrawerValue.Closed)
    val drawerState: StateFlow<DrawerValue> = _drawerState

    fun openDrawer(){
        _drawerState.value = DrawerValue.Open
    }

    fun closeDrawer(){
        _drawerState.value = DrawerValue.Closed
    }

    fun updateIndex(index: Int){
        _index.value =  index
    }
}