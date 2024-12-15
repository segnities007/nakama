package com.segnities007.nakama.ui.screens.login

import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel(), DrawerViewModel {

    private val _index = MutableStateFlow(0)
    override val index: StateFlow<Int> = _index
    private var _drawerState = MutableStateFlow<DrawerValue>(DrawerValue.Closed)
    override val drawerState: StateFlow<DrawerValue> = _drawerState

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun updateEmail(value: String){
        _email.value = value
    }

    fun updatePassword(value: String){
        _password.value = value
    }

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