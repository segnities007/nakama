package com.segnities007.nakama.ui.screens.login.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.segnities007.nakama.ui.screens.login.LoginViewModel
import io.github.jan.supabase.auth.auth

@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onClick: () -> Unit,
){
    InputForm(modifier = modifier, viewModel = viewModel, onClick = onClick)
}

@Composable
private fun InputForm(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onClick: () -> Unit,
){
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val spacer = 16.dp
    val shape = 2.dp
    val fontSize = 50.sp

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text("<Sign In>", fontSize = fontSize)
        Spacer(modifier = Modifier.padding(spacer))
        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("email") }
        )
        Spacer(modifier = Modifier.padding(spacer))
        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.updatePassword(it) },
            label = { Text("password") },
            visualTransformation = PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.padding(spacer))
        ElevatedButton(
            shape = RoundedCornerShape(shape),
            onClick = onClick,
        ) {
            Text("enter")
        }
    }
}