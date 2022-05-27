package com.example.composelogin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composelogin2.ui.SigninScreen
import com.example.composelogin2.ui.theme.ComposeLogin2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLogin2Theme {
                SigninScreen()

            }
        }
    }
}
