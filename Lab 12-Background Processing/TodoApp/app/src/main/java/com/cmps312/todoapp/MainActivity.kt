package com.cmps312.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.cmps312.todoapp.ui.theme.Lab11Theme
import com.cmps312.todoapp.view.components.GoogleSignInButton
import com.cmps312.todoapp.viewmodel.SignInViewModel
import com.cmps312.todoapp.viewmodel.TodoViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private val signInViewModel: SignInViewModel by viewModels()
    private val todoViewModel: TodoViewModel by viewModels()
    private val loggedIn = mutableStateOf<Boolean>(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo add firebase auth listner

        setContent {
            Lab11Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Firebase.auth.addAuthStateListener {
                        loggedIn.value = it.currentUser?.uid != null
                    }
                    if (loggedIn.value) MainScreen() else SignInScreen()
                }
            }
        }
    }
}

//1. create the button
//2. When the logs in we need to strore his/her data
//3. [some configuration to call and do the authentication]
//4. we want to keep the data inside a viewmodel

//MVVM

//Todo add AuthView
//Todo add SignInScreen
@Composable
fun AuthView(errorText: String, onClick: () -> Unit) {
    var isLoading by remember { mutableStateOf(false)}

    Scaffold(
        topBar = {TopAppBar(title = { Text(text = "Sign In Page") }) }
    ) {
        Column{
            GoogleSignInButton(text = "Sign In With Google",
                icon = painterResource(id = R.drawable.btn_google_light),
                loadingText = "Sign in ....",
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                    onClick()
                }
            )
            
            errorText?.let { 
                isLoading = false
                Text(text = it)
            }
        }
    }

}