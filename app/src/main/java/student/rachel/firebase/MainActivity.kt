package student.rachel.firebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    lateinit var db: DocumentReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance().document("IceCreams/ja")
        var flavour = "banana"


        val items = HashMap<String, Any>()
        items["Ingrediant-1"] = "butter"
        items["Ingrediant-2"] = "water"
        db.collection(flavour).document("Ingrediants").set(items)
            .addOnSuccessListener {
                void: Void? -> Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
                exception: java.lang.Exception -> Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
        }
    }
}

