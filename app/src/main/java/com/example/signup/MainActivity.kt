package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import com.example.signup.SharedPreferences.Companion.prefs
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

        initUI()
        checkUserValues()

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

    private fun initUI(){
        binding.btnRegisterFacebook.setOnClickListener {
            accessSharedPreferences()

        }
    }

    private fun checkUserValues(){
        if (prefs.getFullname().isNotEmpty()){
            goAccess()
        }
    }

    fun accessSharedPreferences(){
        if (binding.etFullName.text.toString().isNotEmpty()&&
            binding.etName.text.toString().isNotEmpty()&&
            binding.etEmail.text.toString().isNotEmpty()&&
            binding.etPassword.text.toString().isNotEmpty()&&
            binding.etRePassword.text.toString().isNotEmpty())
        {
            prefs.saveUsername(binding.etFullName.text.toString())
            prefs.saveFullname(binding.etName.text.toString())
            prefs.saveEmail(binding.etEmail.text.toString())
            prefs.savePassword(binding.etPassword.text.toString())
            prefs.saveRetypepassword(binding.etRePassword.text.toString())
            goAccess()
        } else {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rbFemale ->
                    if (checked) {
                        prefs.saveGenre("Female")
                    }
                R.id.rbMale ->
                    if (checked) {
                        prefs.saveGenre("Male")
                    }
            }
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, AccessActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.NONE, ID_NUEVO_GRUPO, Menu.NONE, "Nuevo grupo")
        menuInflater.inflate(R.menu.activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}