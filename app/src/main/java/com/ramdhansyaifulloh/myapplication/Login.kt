package com.ramdhansyaifulloh.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramdhansyaifulloh.myapplication.databinding.ActivityLoginBinding
import com.ramdhansyaifulloh.myapplication.databinding.ActivityMainBinding

private lateinit var binding: ActivityLoginBinding
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

        val datalogin = ModelLogin(binding.textUserName.text.toString(), binding.textPassword.text.toString())
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("data",datalogin)
        startActivity(intent)
        }
    }
}