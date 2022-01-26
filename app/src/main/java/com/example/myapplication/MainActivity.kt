package com.example.myapplication

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val img = arrayOf(R.drawable.madart1,R.drawable.madart2,R.drawable.madart3,R.drawable.madart4,
        R.drawable.madart5,R.drawable.madart6,R.drawable.madart7,R.drawable.madart8,R.drawable.madart9,
        R.drawable.madart10,R.drawable.madart11,R.drawable.madart12,R.drawable.madart13)

    private val texts = arrayOf("შოკოლადის ტორტი ბანანით","ხილის ტორტი","ტყუპი ტორტი", "შავი პრინცი","შოკოლადის ტორტი",
        "შოკოლადის ტორტი ალუბლით","ტარტალეტკა ჟოლოს კონფიტიურით","შავი ციყვი",
        "თეთრი ციყვი","ანიუტა","იდეალი","მისქეიქი","შავი მედოკი")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView : BottomNavigationView = findViewById (R.id.bottomNavigationView)
        val controller = findNavController(R.id.nav_host_fragment)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img,texts)


        val fragmentSet = setOf<Int>(
            R.id.fragmentHome,
            R.id.fragmentAuthors
            )

       setupActionBarWithNavController(controller , AppBarConfiguration(fragmentSet) )
        bottomNavView.setupWithNavController(controller)
    }
}