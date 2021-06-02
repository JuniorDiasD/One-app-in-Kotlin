package com.example.nosmorabeza

import android.content.Intent
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

    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Register Screen"
        }
        actionBar!!.title = "Register Screen"
        actionBar.setDisplayHomeAsUpEnabled(true)

        auth = FirebaseAuth.getInstance();
        registarBtn.setOnClickListener {

           if(emailR.text.trim().toString().isNotEmpty()
               || password.text.trim().toString().isNotEmpty()){

               createUser(emailR.text.trim().toString(),password.text.trim().toString())

           }else{
               Toast.makeText(this,"Input Require",Toast.LENGTH_LONG).show()


           }

        }

    }

    fun createUser(email:String,password:String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    Log.e("Task Message", "Successful..");
                    var intentP = Intent(this,ExDash::class.java);
                    startActivity(intentP);
                } else {
                    Log.e("Task Message", "Failed.."+ task.exception)

                }
            }

    }

    /*override fun onStart() {
        super.onStart()
        val user = auth.currentUser;

        if(user!=null){

            var intentP = Intent(this,ExDash::class.java);
            startActivity(intentP);

        }
    }*/

}