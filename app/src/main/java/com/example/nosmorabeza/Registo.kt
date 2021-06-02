package com.example.nosmorabeza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registo.*

class Registo : AppCompatActivity() {

    lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        auth = FirebaseAuth.getInstance()
    }
private fun registro(){
    registarBtn.setOnClickListener {

       // auth.createUserWithEmailAndPassword()

    }
}

}