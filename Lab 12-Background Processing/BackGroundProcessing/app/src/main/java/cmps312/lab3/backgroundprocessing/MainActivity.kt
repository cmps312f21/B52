package cmps312.lab3.backgroundprocessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.work.*
import cmps312.lab3.backgroundprocessing.ui.theme.BackGroundProcessingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackGroundProcessingTheme {
                // A surface container using the 'background' color from the theme
                //Todo add code here

                Surface(color = MaterialTheme.colors.background

                ) {
                    //Todo add cod

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = androidx.compose.ui.Modifier.padding(40.dp))

                        Button(onClick = {

                        }) {
                            Text(text = "Do one time work")
                        }
                        Button(onClick = {

                        }) {
                            Text(text = "Schedule Periodic work")
                        }

                        //  Text(text = jobState)

                    }

                }
            }
        }
    }
}

