package com.example.miskysapplication.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.miskysapplication.model.Student
import com.example.miskysapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveStudent(Studentname: String, StudentClass: String, Studentid: String) {
        var id = System.currentTimeMillis().toString()
        var studentdata = Student(Studentname, StudentClass, Studentid, id)
        var StudentRef = FirebaseDatabase.getInstance().getReference()
            .child("Student/$id")
        progress.show()
        StudentRef.setValue(studentdata).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
@Composable
    fun viewStudents(
//        student: MutableState<Student>,
//        studentsnap: SnapshotStateList<Student>
    ): SnapshotStateList<Student> {
        val emptyProductState = remember { mutableStateOf(Student("","","","")) }
        val emptyProductsListState = remember { mutableStateListOf<Student>() }


        var ref = FirebaseDatabase.getInstance().getReference().child(
            "Students" +
                    ""
        )

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
//                Student.clear()
                emptyProductsListState.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Student::class.java)
//                    emptyProductsListState.size = value!!
                    emptyProductsListState.add(Student())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return emptyProductsListState
    }

    fun deleteStudent(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Student/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Student deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateStudent(name: String, Class: String,time:String, id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Student/$id")
        progress.show()
        var updateData = Student(name, Class,time, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateProduct(trim: CharSequence, trim1: String, trim2: String, id: String) {
        TODO("Not yet implemented")
    }


}

