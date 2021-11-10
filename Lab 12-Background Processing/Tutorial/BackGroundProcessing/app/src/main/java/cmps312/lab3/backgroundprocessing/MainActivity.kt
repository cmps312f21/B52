package cmps312.lab3.backgroundprocessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.*
import cmps312.lab3.backgroundprocessing.ui.theme.BackGroundProcessingTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackGroundProcessingTheme {
                // A surface container using the 'background' color from the theme
                //job state
                var jobState by remember { mutableStateOf("") }

                Surface(color = MaterialTheme.colors.background

                ) {
                    //Todo add cod
                    val context = LocalContext.current
                    val constraints = Constraints.Builder()
                        .setRequiresBatteryNotLow(true)
                        .setRequiredNetworkType(NetworkType.CONNECTED).build()

                    val periodicWorkRequest =
                        PeriodicWorkRequestBuilder<MyWorker>(1, TimeUnit.DAYS)
                            .setConstraints(constraints)
                            .build()

                    val oneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
                        .setConstraints(constraints)
                        .build()

                    WorkManager.getInstance(this)
                        .getWorkInfoByIdLiveData(periodicWorkRequest.id)
                        .observe(this) {
                            jobState = it.state.name
                        }

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = androidx.compose.ui.Modifier.padding(40.dp))

                        Button(onClick = {
                            WorkManager.getInstance(context).enqueue(oneTimeWorkRequest);
                        }) {
                            Text(text = "Do one time work")
                        }
                        Button(onClick = {
                            WorkManager.getInstance(context).enqueue(periodicWorkRequest);
                        }) {
                            Text(text = "Schedule Periodic work")
                        }
                        Text(text = "The Current Job Status is $jobState")
                    }

                }
            }
        }
    }
}

