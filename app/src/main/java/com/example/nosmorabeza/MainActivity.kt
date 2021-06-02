package com.example.nosmorabeza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar !!.title = "Login screen"

        registar.setOnClickListener {

            val intentR = Intent(this, Registo::class.java)
            startActivity(intentR)
        }

        login.setOnClickListener {

            val intent = Intent(this, FeedImagens::class.java)
            startActivity(intent)
        }
    }

}