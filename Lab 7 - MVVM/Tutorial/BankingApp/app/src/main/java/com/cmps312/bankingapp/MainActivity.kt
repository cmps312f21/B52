package com.cmps312.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.bankingapp.ui.theme.BankingAppTheme
import com.cmps312.bankingapp.viewmodel.BankingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val bankingViewModel = viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    Column {
        bankingViewModel.accounts.forEach {  account->
            Text(text = "Hello $account!")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingAppTheme {
        Greeting("Android")
    }
}