package com.example.cajaspico_csar_ud1_practica1

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.cajaspico_csar_ud1_practica1.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {




    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()
        binding.btnMain1.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        binding.btnMain2.setOnClickListener {
            val intent = Intent(this, AcercaDe::class.java)
            startActivity(intent)
        }



    }
    private fun recuperarDatos() {
        val preferencias = getSharedPreferences("agenda_alumnos", Context.MODE_PRIVATE)

        val dniUltimo = preferencias.getString("dniUltimo", "")
        val nombreUltimo = preferencias.getString(dniUltimo + "_nombre", "")
        val apellidosUltimo = preferencias.getString(dniUltimo + "_apellidos", "")
        val cursoUltimo = preferencias.getString(dniUltimo + "_curso", "")
        val claseUltima = preferencias.getString(dniUltimo + "_clase", "")

        if(!dniUltimo.isNullOrEmpty()){
            binding.txtMain2.text="Último alumno registrado:\nID: $dniUltimo \nNombre: $nombreUltimo $apellidosUltimo \nCurso: $cursoUltimo - Clase: $claseUltima."
        }else{
            binding.txtMain2.text="No hay datos de alumnos guardados todavía."
        }

    }




}