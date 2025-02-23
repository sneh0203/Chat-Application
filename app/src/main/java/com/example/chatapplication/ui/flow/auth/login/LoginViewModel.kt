package com.example.chatapplication.ui.flow.auth.login

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _passwordVisible = MutableStateFlow(false)
    val passwordVisible: StateFlow<Boolean> = _passwordVisible

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onVisibilityChange(status: Boolean) {
        _passwordVisible.value = status
    }

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun checkCurrentUser(
        email: String,
        password: String,
        context: Context,
        onResult: (Boolean) -> Unit
    ) {
        when {
            email.isEmpty() || !isEmailValid(email) -> {
//                Toast.makeText(
//                    context,
//                    context.getString(R.string.toast_email_error), Toast.LENGTH_SHORT
//                ).show()
                onResult(false)
            }

            password.isEmpty() -> {
//                Toast.makeText(
//                    context,
//                    context.getString(R.string.toast_empty_password), Toast.LENGTH_SHORT
//                ).show()
                onResult(false)
            }

            else -> {
                viewModelScope.launch {
                    _isLoading.value = true
                    val result = withContext(Dispatchers.IO) {
                        delay(timeMillis = 1000L)
//                        authRepository.logIn(email, password)
                    }
                    _isLoading.value = false
//                    onResult(result)
                    onResult(true)
                }
            }
        }
    }
}