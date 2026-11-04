package com.example.cajaspico_csar_ud1_practica1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cajaspico_csar_ud1_practica1.databinding.ActivityAcercaDeBinding
import android.content.Intent

class AcercaDe : AppCompatActivity() {


    private lateinit var binding: ActivityAcercaDeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityAcercaDeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVolver.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val intent= Intent(this, Activity2::class.java)
            startActivity(intent)
        }



    }
}