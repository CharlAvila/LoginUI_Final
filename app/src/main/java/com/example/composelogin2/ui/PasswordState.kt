package com.example.composelogin2.ui

class PasswordState: TextFieldState(
    validator =   ::isPasswordValid,
    errorMessage = { passwordErrorMessage()}

)

fun isPasswordValid(password:String) = password.length >= 4

fun passwordErrorMessage() = "Password is invalid."