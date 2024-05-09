import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UpdateStudentScreen(
    currentStudent: Student,
    onUpdateStudent: (Student) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var Class by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    val currentStudent=FirebaseDatabase.getInstance().getReference()
        .child("Students/$id")
    currentStudent.addValueEventListener(object :ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            var Student=snapshot.getValue(Student::class.java)
            name=Student!!.name
            Class=Student!!.studentClass
            time=Student!!.time
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context,error.message,Toast.LENGTH_SHORT).show()
        }
    })


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = newName,
            onValueChange = { newName = it },
            label = { Text("Student Name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle next action if needed */ })
        )

        OutlinedTextField(
            value = newClass,
            onValueChange = { newClass = it },
            label = { Text("Student Class") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle next action if needed */ })
        )

        OutlinedTextField(
            value = newTime,
            onValueChange = { newTime = it },
            label = { Text("Student Time") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                val updatedStudent = Student(newName, newClass, newTime)
                onUpdateStudent(updatedStudent)
                keyboardController?.hide() // Hide keyboard when done updating
            })
        )

        Button(
            onClick = {
                val updatedStudent = Student(newName, newClass, newTime)
                onUpdateStudent(updatedStudent)
                keyboardController?.hide() // Hide keyboard when update button is clicked
            },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(text = "Update")
        }
    }
}

@Composable
fun Button(onClick: () -> Unit?, modifier: Modifier, content: () -> Unit) {

}

@Composable
fun OutlinedTextField(value: String, onValueChange: () -> Unit, label: @Composable () -> Unit, singleLine: Boolean, keyboardOptions: KeyboardOptions, keyboardActions: KeyboardActions) {

}

@Preview(showBackground = true)
@Composable
fun PreviewUpdateStudentScreen() {
    val student = Student("John Doe", "Class A", "9:00 AM")
    UpdateStudentScreen(
        currentStudent = student,
        onUpdateStudent = { updatedStudent ->
            // Placeholder function for handling update action
            // Replace with actual implementation in your app
            // Example: viewModel.updateStudent(updatedStudent)
        }
    )
}

data class Student(
    val name: String,
    val studentClass: String,
    val time: String
)
