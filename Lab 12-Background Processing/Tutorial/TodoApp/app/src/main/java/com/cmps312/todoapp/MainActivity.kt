package com.cmps312.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cmps312.todoapp.component.GoogleSignInButton
import com.cmps312.todoapp.ui.theme.Lab11Theme
import com.cmps312.todoapp.viewmodel.TodoViewModel
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    //Todo ger the signin view model
    private val todoViewModel: TodoViewModel by viewModels()
    private val loggedIn = mutableStateOf<Boolean>(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //Todo add firebase auth listner

        setContent {
            Lab11Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                        //Todo add the condition here
                        MainScreen()

                }
            }
        }
    }
}

//Todo add AuthView
//Todo add SignInScreen
