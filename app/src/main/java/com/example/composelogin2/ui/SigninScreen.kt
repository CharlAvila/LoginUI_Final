package com.example.composelogin2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelogin2.R
import com.example.composelogin2.ui.theme.darkBlue

@Preview(showSystemUi = true)
@Composable
fun SigninScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Title()
        val emailState = remember { EmailState() }
        Email(emailState.text, emailState.error){
            emailState.text = it
            emailState.validate()
        }
        val passwordState = remember { PasswordState()}
        Password(passwordState.text, passwordState.error){
            passwordState.text = it
            passwordState.validate()
        }
        SigninButton(enabled = emailState.isValid() && passwordState.isValid())
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.sign_in_welcome_text),
        style = MaterialTheme.typography.h1
    )
}

@Composable fun Email(email:String,error: String?,onEmailChanged: (String) -> Unit) {
    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {onEmailChanged(it) },
            label = { Text(text = stringResource(R.string.email_hint)) },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = error!= null
        )

      error?.let { ErrorField(it)}
    }
}
@Composable
fun ErrorField(error:String){
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(color = MaterialTheme.colors.error)
    )
}

@Composable fun Password(password:String,error:String?,onPasswordChange:(String) -> Unit) {
    val showPassword = remember {mutableStateOf(false) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange  = {onPasswordChange(it)},
        label = {Text(text = stringResource(R.string.password_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
                PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        trailingIcon = {
            if(showPassword.value) {
                IconButton(onClick = { showPassword.value = false}) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(R.string.hide_password)
                    )

                }
            }else{
                IconButton(onClick = {showPassword.value = true}) {
                    Icon(
                        imageVector =  Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(R.string.show_password)
                    )
                }
            }
        },
        isError = error !=null
    )
    error?.let{ErrorField(it)}
}



@Composable fun SigninButton(enabled:Boolean) {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
        ,contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = darkBlue,
            contentColor = Color.White
        ),
        enabled  = (enabled),
    ) {
        Text(
            text = stringResource(R.string.sign_in)
        )
    }
}
