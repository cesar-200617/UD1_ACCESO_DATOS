package com.example.cajaspico_csar_ud1_practica1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.cajaspico_csar_ud1_practica1.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    private lateinit var gestorPrefs: AlumnosPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        gestorPrefs = AlumnosPrefs(this)

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
                val alumno = Alumno(dni, nombre, apellidos, curso, clase)
                gestorPrefs.guardarAlumno(alumno)
                Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btn2.setOnClickListener {
            val dniBuscado = binding.et1.text.toString().trim()
            if (dniBuscado.isNotEmpty()) {
                val alumnoEncontrado = gestorPrefs.buscarAlumno(dniBuscado)
                if (alumnoEncontrado != null) {
                    binding.et2.setText(alumnoEncontrado.nombre)
                    binding.et3.setText(alumnoEncontrado.apellidos)
                    binding.et4.setText(alumnoEncontrado.curso)
                    binding.et5.setText(alumnoEncontrado.clase)
                    Toast.makeText(this, "Encontrado!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No existe ese DNI", Toast.LENGTH_SHORT).show()
                    binding.et2.text.clear()
                    binding.et3.text.clear()
                    binding.et4.text.clear()
                    binding.et5.text.clear()
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