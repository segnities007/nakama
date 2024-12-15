package com.segnities007.nakama.data.model.auth

import io.github.jan.supabase.auth.user.UserSession

interface Auth {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean
//    suspend fun getCurrentUserSession()
}