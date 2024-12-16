package com.segnities007.nakama.data.repository.auth

import android.util.Log
import com.segnities007.nakama.data.model.auth.Auth
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.exceptions.RestException

class AuthRepository(
    private val supabaseClient: SupabaseClient
) : Auth {

    override suspend fun signIn(email: String, password: String): Boolean{
        try {
            supabaseClient.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
        }catch (e: RestException){
            Log.d("AuthRepository class", "RestException, ${e.toString()}")
            return false
        }catch (e: Exception){
            Log.d("AuthRepository class", "Exception, ${e.toString()}")
            return false
        }
        return true
    }

    override suspend fun signUp(email: String, password: String): Boolean{
        try {
            supabaseClient.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        }catch (e: RestException){
            Log.d("AuthRepository class", "RestException, ${e.toString()}")
            return false
        }catch (e: Exception){
            Log.d("AuthRepository class", "Exception, ${e.toString()}")
            return false
        }
        return true
    }

}