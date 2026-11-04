package com.example.cajaspico_csar_ud1_practica1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.cajaspico_csar_ud1_practica1.databinding.Activity2Binding
import com.example.cajaspico_csar_ud1_practica1.databinding.ActivityAcercaDeBinding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    private lateinit var gestorPrefs: AlumnosPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        gestorPrefs = AlumnosPrefs(this)

        binding.btn3.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btn5.setOnClickListener {
            val intent=Intent(this, AcercaDe::class.java)
            startActivity(intent)
        }

        binding.btn1.setOnClickListener {
            val dni = binding.et1.text.toString().trim()
            val nombre = binding.et2.text.toString().trim()
            val apellidos = binding.et3.text.toString().trim()
            val curso = binding.et4.text.toString().trim()
            val clase = binding.et5.text.toString().trim()

            if (dni.isNotEmpty() && nombre.isNotEmpty() && apellidos.isNotEmpty() && curso.isNotEmpty() && clase.isNotEmpty()) {
                val alumno = Alumno(dni, nombre, apellidos, curso, clase)
                gestorPrefs.guardarAlumno(alumno)
                Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btn2.setOnClickListener {
            val dniBuscado = binding.et6.text.toString().trim()
            if (dniBuscado.isNotEmpty()) {
                val alumnoEncontrado = gestorPrefs.buscarAlumno(dniBuscado)
                if (alumnoEncontrado != null) {
                    binding.txtAct2.text = "Alumno encontrado:\nDNI: ${alumnoEncontrado.dni}\nNombre: ${alumnoEncontrado.nombre} ${alumnoEncontrado.apellidos}\nCurso: ${alumnoEncontrado.curso} - Clase: ${alumnoEncontrado.clase}"

                    Toast.makeText(this, "Encontrado!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No existe ese DNI", Toast.LENGTH_SHORT).show()
                    binding.et6.text.clear()
                }
            } else {
                Toast.makeText(this, "Introduce un DNI", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btn4.setOnClickListener {
            binding.et1.text.clear()
            binding.et2.text.clear()
            binding.et3.text.clear()
            binding.et4.text.clear()
            binding.et5.text.clear()

            Toast.makeText(this, "Campos limpios", Toast.LENGTH_SHORT).show()
        }
    }
}