package com.example.composelogin2.ui

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelogin2.R

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
        Email()
        Password()
        SigninButton()
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.sign_in_welcome_text)
    )
}

@Composable
fun Email() {
    val emailState = remember { (mutableStateOf(TextFieldValue())) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailState.value,
        onValueChange = {emailState.value = it},
        label = {Text(text = stringResource(R.string.email_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Password() {
    val passwordState = remember { (mutableStateOf(TextFieldValue()))}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = {Text(text = stringResource(R.string.password_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun SigninButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.sign_in)
        )
    }
}
