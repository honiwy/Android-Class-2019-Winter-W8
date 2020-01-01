package student.rachel.firebase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Access a Cloud Firestore instance from your Activity

        val db2 = FirebaseFirestore.getInstance()
        val student = Student()
        student.stuId = 10346099
        student.name = "Vincent"
        student.birthday = "1996/01/01"

        // Add a new document with a generated ID
        db2.collection("Students").add(student)

    }
}

data class User (val name: String, val email: String)
class Student(
    var stuId: Int = 0,
    var name: String = "",
    var birthday: String = "") {
}