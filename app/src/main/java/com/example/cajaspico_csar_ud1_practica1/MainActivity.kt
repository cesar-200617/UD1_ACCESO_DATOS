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

        val idUltimo = preferencias.getString("id_alumno", "")
        val nombreUltimo = preferencias.getString("nombre", "")
        val apellidosUltimo = preferencias.getString("apellidos", "")
        val cursoUltimo = preferencias.getString("curso", "")
        val claseUltima = preferencias.getString("clase", "")

        if(!idUltimo.isNullOrEmpty()){
            binding.txtMain2.text="Último alumno registrado:\\nID: \$idUltimo\\nNombre: \$nombreUltimo \$apellidosUltimos\\nCurso: \$cursoUltimo - Clase: \$claseUltima."
        }else{
            binding.txtMain2.text="No hay datos de alumnos guardados todavía."
        }

    }




}