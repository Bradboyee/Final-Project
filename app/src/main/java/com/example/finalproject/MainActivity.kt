package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.data_kanji.Data
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.fragment.HomeFragment
import com.example.finalproject.fragment.SpacedFragment
import com.example.finalproject.fragment.StatFragment
import com.example.finalproject.recyclerview.CategoryRecyclerAdapter

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomnavigationview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_spacedrepitition -> replaceFragment(SpacedFragment())
                R.id.nav_static -> replaceFragment(StatFragment())
                else ->{}
            }
            true
        }

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }

}