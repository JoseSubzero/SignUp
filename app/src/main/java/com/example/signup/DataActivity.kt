package com.example.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signup.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}