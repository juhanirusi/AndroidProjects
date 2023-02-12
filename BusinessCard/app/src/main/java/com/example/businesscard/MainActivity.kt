package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardLayout()
                }
            }
        }
    }
}

@Composable
fun BusinessCardLayout() {
    Column(
        modifier = Modifier.background(Color(7, 42, 66)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Name()
        ContactDetails()
    }
}

@Composable
fun Name() {
    val androidLogo = painterResource(id = R.drawable.android_logo)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 220.dp)
    ) {
        Image(
            painter = androidLogo,
            contentDescription = "Android Logo",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .wrapContentWidth()
                .padding(start = 140.dp, end = 140.dp)
        )
        Text(
            text = "Juhani Rusi",
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            color = Color(0xffffffff)
        )
        Text(
            text = "Android Developer",
            textAlign = TextAlign.Center,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun ContactDetails() {
    val phone = painterResource(id = R.drawable.ic_baseline_phone)
    val share = painterResource(id = R.drawable.ic_baseline_share)
    val email = painterResource(id = R.drawable.ic_baseline_email)
    Column(modifier = Modifier.padding(bottom = 50.dp)) {
        Divider(thickness = 1.dp, color = Color.LightGray)
        Row(modifier = Modifier.padding(start = 50.dp, top = 10.dp, bottom = 10.dp)) {
            Icon(
                painter = phone,
                contentDescription = "phone_icon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = "050 414 5436",
                color = Color(0xffffffff),
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 18.sp
            )
        }
        Divider(thickness = 1.dp, color = Color.LightGray)
        Row(modifier = Modifier.padding(start = 50.dp, top = 10.dp, bottom = 10.dp)) {
            Icon(
                painter = share,
                contentDescription = "share_icon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = "juhanirusi",
                color = Color(0xffffffff),
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 18.sp
            )
        }
        Divider(thickness = 1.dp, color = Color.LightGray)
        Row(modifier = Modifier.padding(start = 50.dp, top = 10.dp, bottom = 10.dp)) {
            Icon(
                painter = email,
                contentDescription = "email_icon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = "juhanirusi@yahoo.com",
                color = Color(0xffffffff),
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardLayout()
    }
}
