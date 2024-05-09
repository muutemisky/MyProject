import android.annotation.SuppressLint
import  androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(
    students: List<Student>,
    onStudentSelected: (Student) -> Unit,
    onDeleteStudent: (Student) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Student List") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                if (students.isEmpty()) {
                    Text(
                        text = "No students available",
                        style = MaterialTheme.typography.headlineLarge
                    )
                } else {
                    LazyColumn {
                        items(students) { student ->
                            StudentListItem(
                                student = student,
                                onStudentSelected = onStudentSelected,
                                onDeleteStudent = onDeleteStudent
                            )
                        }
                    }
                }
            }
        }
    )
}





@Composable
fun StudentListItem(
    student: Student,
    onStudentSelected: (Student) -> Unit,
    onDeleteStudent: (Student) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${student.name}", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Class: ${student.studentClass}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Time: ${student.time}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onStudentSelected(student) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Update")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onDeleteStudent(student) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }
}