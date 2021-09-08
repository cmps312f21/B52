package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Daddy Shark")
        }
    }
}
//Modifiers

@Composable
fun MessageCard(name: String) {
    Row(modifier = Modifier
        .padding(10.dp)
        .background(Color.Magenta)
        .border(2.dp, Color.Red, RectangleShape)
        ) {
        Image(
            painter = painterResource(id = R.drawable.someone),
            contentDescription = "A shark Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = "$name")
            Divider()
            Text(text = "DevelopersTermsPrivacyPolicy & SafetyHow YouTube worksTest new features. © 2021 Google LLC ...")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MessageCard(name = "Daddy Shark")
    }
}