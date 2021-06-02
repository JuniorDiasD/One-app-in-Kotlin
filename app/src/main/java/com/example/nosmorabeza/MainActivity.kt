package com.example.nosmorabeza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_registo.*


class MainActivity : AppCompatActivity() {

   private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionBar = supportActionBar
        actionBar!!.title = "Login screen"

       auth = FirebaseAuth.getInstance();

        registar.setOnClickListener {

            val intentR = Intent(this, Registo::class.java)
            startActivity(intentR)
        }


        loginbtn.setOnClickListener {
            if (emailR.text.trim().toString().isNotEmpty()
                || password.text.trim().toString().isNotEmpty()
            ) {

                signUser(emailR.text.trim().toString(), password.text.trim().toString())

            } else {
                Toast.makeText(this, "Input Require", Toast.LENGTH_LONG).show()


            }
        }
    }

    fun signUser(email:String,password: String){

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful){
                    val intentP=Intent (this,ExDash::class.java);
                    startActivity(intentP);

            }else{
                   Toast.makeText(this, "Error ||"+task.exception, Toast.LENGTH_LONG).show()
                }
            }
    }
}