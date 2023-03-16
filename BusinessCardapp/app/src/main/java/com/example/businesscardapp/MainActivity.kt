package com.example.businesscardapp

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionOne()
        SectionTwo()
    }
}

@Composable
fun SectionOne() {
    val image = painterResource(id = R.drawable.adebayo)
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 40.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = "Adebayo Adesina Joseph",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Software Developer",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
        )

    }
}

@Composable
fun SectionTwo() {

    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ContactRow(R.drawable.oip, "+00 (00) 000 000")
        ContactRow(R.drawable.r__1_, "@adesin18")
        ContactRow(R.drawable.gmailold, "adebayoadesina789")
    }
}
@Composable
fun ContactRow(imageDetail : Int, details: String ) {
    val image = painterResource(id = imageDetail)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 5.dp),
    ) {

        Row(
            modifier = Modifier.width(45.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .padding(end = 10.dp)
            )
        }

        Row(
            modifier = Modifier.width(150.dp),
        ) {
            Text(
                text = details,
                fontSize = 16.sp,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardAppTheme {
        BusinessCardScreen()
    }
}