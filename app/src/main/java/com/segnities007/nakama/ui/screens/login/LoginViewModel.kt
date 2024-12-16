package com.segnities007.nakama.ui.screens.login

import android.util.Log
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.derivedStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel (
    val supabaseClient: SupabaseClient,
): ViewModel(), DrawerViewModel {

    private val _index = MutableStateFlow(0)
    override val index: StateFlow<Int> = _index
    private var _drawerState = MutableStateFlow<DrawerValue>(DrawerValue.Closed)
    override val drawerState: StateFlow<DrawerValue> = _drawerState

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
    private val _isFailed = MutableStateFlow(false)
    val isFailed: StateFlow<Boolean> = _isFailed

    val passwordHasErrors = derivedStateOf {
        password.value.length > 6
    }

    fun signIn(
        supabaseClient: SupabaseClient,
        navController: NavHostController,
    ){
        Log.d("test", "signIn")
        val auth = AuthRepository(supabaseClient)
        var isSuccess: Boolean = false
        viewModelScope.launch{
            isSuccess = auth.signIn(email = _email.value, password = _password.value)
            if(isSuccess){
                Log.d("text", "success")
                navController.navigate("/home")
            }else{
                Log.d("text", "failed")
                _isFailed.value = true
            }
        }
    }

    fun signUp(
        supabaseClient: SupabaseClient,
        navController: NavHostController,
    ){
        val auth = AuthRepository(supabaseClient)
        var isSuccess: Boolean = false
        viewModelScope.launch{
            isSuccess = auth.signUp(email = _email.value, password = _password.value)
            if(isSuccess){
                navController.navigate("/home")
            }else{
                _isFailed.value = true
            }
        }
    }

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