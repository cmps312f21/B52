package cmps312.lab3.backgroundprocessing

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class MyWorker(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {
    val TAG = "MyWorker"
    override suspend fun doWork(): Result = coroutineScope {
        aLongRunningTask()
//        showNotification("Successfully Completed")
        Result.success()
    }
    suspend fun aLongRunningTask(){
        //will check the server
        //download the content
        //update the room database

        Log.d(TAG, "aLongRunningTask: started executing ")
        delay(1000 * 15)
        Log.d(TAG, "aLongRunningTask: ended executing ")
    }
}