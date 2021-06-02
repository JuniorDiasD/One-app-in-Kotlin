package com.example.nosmorabeza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.text.TextUtils
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_registo.*

class Registo : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Register Screen"
        }
        actionBar!!.title = "Register Screen"
        actionBar.setDisplayHomeAsUpEnabled(true)


        registarBtn.setOnClickListener {
            val email =emailR.text.toString()
            val password = password.text.toString()

            Log.d("Registo", "Email is:"+ email)
            Log.d("Registo", "Password is: $password")

            //Firebase Config

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    //else if successful

                    Log.d("Main", "Successfully created user with uid:${it.result?.user?.uid}")
                }
        }

    }

}