package com.example.assignment1

import android.os.Bundle
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
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextWithImage(stringResource(R.string.title), stringResource(R.string.description_one), stringResource(R.string.description_two))
                }
            }
        }
    }
}

@Composable
fun TextWithImage(title: String, paragraphOne: String, paragraphTwo: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(painter = image, contentDescription = null)
        TextDescription(title, paragraphOne, paragraphTwo)
    }

}
@Composable
fun TextDescription(title: String, paragraphOne: String, paragraphTwo: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = paragraphOne,
            textAlign = Justify,
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth()
        )
        Text(
            text = paragraphTwo,
            textAlign = Justify,
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TextWithImagePreview() {
    Assignment1Theme {
        TextWithImage(stringResource(R.string.title), stringResource(R.string.description_one), stringResource(R.string.description_two))
    }
}