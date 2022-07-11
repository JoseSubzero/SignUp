package com.example.signup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.signup.SharedPreferences.Companion.prefs
import com.example.signup.databinding.ActivityAccessBinding

class AccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

    }

    fun initUI(){
        binding.btnFormBack.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }

        val fullName = prefs.getFullname()
        val userName = prefs.getUsername()
        val email = prefs.getEmail()
        val password = prefs.getPassword()
        val repassword = prefs.getRetypePassword()
        val genre = prefs.getGenre()
        binding.tvAccess.text = "\n$fullName\n$userName\n$email\n$password\n$repassword\n$genre"

        }

}