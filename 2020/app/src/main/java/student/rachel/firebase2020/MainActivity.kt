package student.rachel.firebase2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = FirebaseFirestore.getInstance().document("IceCreams/test")
        var flavour = "banana"


        val items = HashMap<String, Any>()
        items["Ingrediant-1"] = "butterfly"
        items["Ingrediant-2"] = "water"
        db.collection(flavour).document("Ingrediants").set(items)
            .addOnSuccessListener {
                Log.i("apple","success")
                Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {exception->
                Log.i("apple","fail")
                Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
            }
    }
}
