package com.example.nosmorabeza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast

class FeedImagens : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_imagens)



        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Nôs Morabeza"
        }
        actionBar!!.title = "Nôs Morabeza"
        actionBar.setDisplayHomeAsUpEnabled(false)

        var listview =findViewById<ListView>(R.id.listview)
        var list= mutableListOf<Model>()

        list.add(Model("Cidade Velha","02/Junho/2021",R.drawable.cidade_velha))
        list.add(Model("Vulcão do Fogo","02/Junho/2021",R.drawable.fogo))
        list.add(Model("Mindelo","02/Junho/2021",R.drawable.mindelo))
        list.add(Model("Tarrafal","02/Junho/2021",R.drawable.tarrafal))
        list.add(Model("Ilha do Sal","02/Junho/2021",R.drawable.sal))

        listview.adapter = MyAdapter(this,R.layout.row,list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.logout->{
                val intentR = Intent(this, MainActivity::class.java)
                startActivity(intentR)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}