package com.example.lemonade

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                    )
                {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeImageAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeImageAndText(modifier: Modifier) {
    var currentIndex by remember {
        mutableStateOf(1)
    }
    val currentImage = when(currentIndex) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val currentText = when(currentIndex) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = currentText,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Button(
            onClick = {
                      if (currentIndex < 4) {
                          currentIndex++;
                      }else currentIndex = 1

            },
            border = BorderStroke(width = 2.dp, color = Blue),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
        ) {
            Image(
                painter = painterResource(id = currentImage),
                contentDescription = currentIndex.toString()
            )
        }
    }
}