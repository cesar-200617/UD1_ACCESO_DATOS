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
        binding.btnMain3.setOnClickListener {
            finishAffinity()
        }



    }
    override fun onResume() {
        super.onResume()
        recuperarDatos()
    }

    private fun recuperarDatos() {
        val gestorPrefs = AlumnosPrefs(this)
        val ultimoAlumno = gestorPrefs.obtenerUltimoAlumno()

        if (ultimoAlumno != null) {
            binding.txtMain2.text = "Último alumno registrado:\nDNI: ${ultimoAlumno.dni}\nNombre: ${ultimoAlumno.nombre} ${ultimoAlumno.apellidos}\nCurso: ${ultimoAlumno.curso} - Clase: ${ultimoAlumno.clase}"
        } else {
            binding.txtMain2.text = "No hay datos de alumnos guardados todavía."
        }
    }




}