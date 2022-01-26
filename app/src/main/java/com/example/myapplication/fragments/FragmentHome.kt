package com.example.myapplication.fragments

import CustomAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailsActivity
import com.example.myapplication.R

class FragmentHome : Fragment(R.layout.fragment_home){

    private lateinit var buttonDetails:Button

    private val img = arrayOf(R.drawable.madart8,R.drawable.madart10,R.drawable.madart12,R.drawable.madart2,
        R.drawable.madart4,R.drawable.madart5,R.drawable.madart7,R.drawable.madart9,R.drawable.madart11,R.drawable.madart13,
        R.drawable.madart3,R.drawable.madart1,R.drawable.madart6)

    private val texts = arrayOf("შოკოლადის ტორტი ბანანით","ხილის ტორტი","ტყუპი ტორტი", "შავი პრინცი","შოკოლადის ტორტი",
        "შოკოლადის ტორტი ალუბლით","ტარტალეტკა ჟოლოს კონფიტიურით","შავი ციყვი",
        "თეთრი ციყვი","ანიუტა","იდეალი","მისქეიქი","შავი მედოკი")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomAdapter(img, texts)

        buttonDetails = view.findViewById(R.id.buttonDetails)

        buttonDetails.setOnClickListener() {
            startActivity(Intent(requireContext(), DetailsActivity::class.java))

        }
    }

}