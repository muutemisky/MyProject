package com.example.miskysapplication.ui.theme.screens.attendance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.miskysapplication.data.ProductViewModel
import com.example.miskysapplication.model.Student
import com.example.miskysapplication.navigation.ROUTE_HOME

//import com.example.firebaseauth.data.productviewmodel
//import com.example.firebaseauth.navigation.ROUTE_VIEW_PRODUCT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add Student",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var StudentName by remember { mutableStateOf(TextFieldValue("")) }
        var StudentClass by remember { mutableStateOf(TextFieldValue("")) }
        var Studenttime by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = StudentName,
            onValueChange = { StudentName = it },
            label = { Text(text = "Student  Name ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = StudentClass,
            onValueChange = { StudentClass = it },
            label = { Text(text = "Student Class ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = Studenttime,
            onValueChange = { Studenttime= it },
            label = { Text(text = "Student time arrived") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val productRepository = ProductViewModel(navController,context)
            productRepository.saveStudent(StudentName.text.trim(),StudentClass.text.trim(),
                Studenttime.text)
            navController.navigate(ROUTE_HOME)


        }) {
            Text(text = "Save")
        }

    }
}

@Preview
@Composable
fun AddProductsScreenPreview() {
    AddStudentScreen(rememberNavController())

}

