package com.example.taskmanager

import android.os.Bundle
import android.util.Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextWithImage(stringResource(com.example.taskmanager.R.string.title), stringResource(com.example.taskmanager.R.string.sub_title))
                }
            }
        }
    }
}

@Composable
fun TextWithImage(title: String, subtitle: String, ) {
    val image = painterResource(id =com.example.taskmanager.R.drawable.r)
    Column(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = image, contentDescription = null)
        TextDescription(title, subtitle)
    }

}

@Composable
fun TextDescription(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        Text(
            text = subtitle,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TextWithImagePreview() {
    TaskManagerTheme {
        TextWithImage(stringResource(com.example.taskmanager.R.string.title), stringResource(com.example.taskmanager.R.string.sub_title))
    }
}