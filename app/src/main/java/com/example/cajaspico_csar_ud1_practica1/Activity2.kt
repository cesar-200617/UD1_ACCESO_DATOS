package com.example.cajaspico_csar_ud1_practica1

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Toast
import com.example.cajaspico_csar_ud1_practica1.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencias = getSharedPreferences("agenda_alumnos", Context.MODE_PRIVATE)

        binding.btn3.setOnClickListener {
            finish()
        }

        binding.btn1.setOnClickListener {

            val dni = binding.et1.text.toString().trim()
            val nombre = binding.et2.text.toString().trim()
            val apellidos = binding.et3.text.toString().trim()
            val curso = binding.et4.text.toString().trim()
            val clase = binding.et5.text.toString().trim()

            if (dni.isNotEmpty() && nombre.isNotEmpty() && apellidos.isNotEmpty() && curso.isNotEmpty() && clase.isNotEmpty()) {

                val editor = preferencias.edit()

                editor.putString(dni + "_nombre", nombre)
                editor.putString(dni + "_apellidos", apellidos)
                editor.putString(dni + "_curso", curso)
                editor.putString(dni + "_clase", clase)
                editor.putString("dniUltimo", dni)
                editor.apply()

                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Introduce el DNI y el nombre", Toast.LENGTH_SHORT).show()
            }





        }



    }
}