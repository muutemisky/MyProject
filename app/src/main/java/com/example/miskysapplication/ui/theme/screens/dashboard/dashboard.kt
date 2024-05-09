package com.example.miskysapplication.ui.theme.screens.dashboard
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.miskysapplication.R
import com.example.miskysapplication.navigation.ROUTE_LOGIN
///


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Welcome to my app") }
            )
        },



        content = {

            Box(modifier = Modifier.fillMaxSize()){

                Image(painter = painterResource(id = R.drawable.image), contentDescription = "Background Image",
                    contentScale=ContentScale.FillBounds, modifier=Modifier.matchParentSize())
            }

            DashboardContent()
        }
    )
}

@Composable
fun DashboardContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Button(
                onClick = { /* Navigate to Attendance Screen */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Take Attendance")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Text(text = "STUDENT ATTENDANCE SYSTEM",
                color = Color.Cyan,
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp)
            Spacer(modifier = Modifier.height(100.dp))

        }
        item {
            Button(
                onClick = {
                    val navController = NavController
                    navController.navigate(ROUTE_LOGIN)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "continue")
            }
        }
    }
        }

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    DashboardScreen(rememberNavController())
}
