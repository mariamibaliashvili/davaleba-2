package com.example.myapplication.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragment1.FragmentFirst
import com.example.myapplication.fragment1.FragmentSecond
import com.example.myapplication.fragment1.FragmentThird

class ViewPagerFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity)  {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return FragmentFirst()
        }
        return if (position == 1) {
            FragmentSecond()
        }else{
            FragmentThird()

        }
    }
}