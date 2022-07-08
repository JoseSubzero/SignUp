package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.signup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        private val ID_NUEVO_GRUPO = Menu.FIRST
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar

        actionBar!!.title = "  Sign Up"

        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        binding.btnRegister.setOnClickListener {
            val myIntent = Intent(this, DataActivity::class.java)
            startActivity(myIntent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.NONE, ID_NUEVO_GRUPO, Menu.NONE, "Nuevo grupo")
        menuInflater.inflate(R.menu.activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }





}