package com.example.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.signup.databinding.ActivityDataBinding
import com.google.android.material.snackbar.Snackbar

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    companion object{
        private val ID_CONFIRMACION = Menu.FIRST
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSpinner(binding.spPhone, R.array.Phone_Type)
        getSpinner(binding.spEmail, R.array.Email_Type)

        binding.fabtnPhoto.setOnClickListener {
            Toast.makeText(this, "Photo taken", Toast.LENGTH_SHORT).show()
        }

        val actionBar = supportActionBar

        actionBar!!.title = "  "

        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.FIRST, ID_CONFIRMACION, Menu.FIRST, "Confirmación")
        menuInflater.inflate(R.menu.activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun getSpinner(mySpinner: Spinner, data: Int){
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, data,
            android.R.layout.simple_spinner_item)
        mySpinner.adapter = adaptador
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //opSelect = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //opSelect = "Verde"
            }
        }
    }

}