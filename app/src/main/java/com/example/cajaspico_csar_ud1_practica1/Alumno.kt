package com.example.cajaspico_csar_ud1_practica1

import android.content.Context

data class Alumno(
    val dni: String,
    val nombre: String,
    val apellidos: String,
    val curso: String,
    val clase: String

)

class AlumnosPrefs(context: Context) {
    private val prefs = context.getSharedPreferences("agenda_alumnos", Context.MODE_PRIVATE)

    fun guardarAlumno(alumno: Alumno) {
        val editor = prefs.edit()
        editor.putString(alumno.dni + "_nombre", alumno.nombre)
        editor.putString(alumno.dni + "_apellidos", alumno.apellidos)
        editor.putString(alumno.dni + "_curso", alumno.curso)
        editor.putString(alumno.dni + "_clase", alumno.clase)
        editor.putString("dniUltimo", alumno.dni)

        val listaDnis = prefs.getStringSet("array_dnis", null)?.toMutableSet()?:mutableSetOf()
        listaDnis.add(alumno.dni)
        editor.putStringSet("array_dnis", listaDnis)

        editor.apply()
    }

    fun buscarAlumno(dni: String): Alumno? {
        val listaDnis = prefs.getStringSet("array_dnis", emptySet())
        if (listaDnis != null && listaDnis.contains(dni)) {
            val nombre = prefs.getString(dni + "_nombre", null)?:""
            val apellidos = prefs.getString(dni + "_apellidos", null)?:""
            val curso = prefs.getString(dni + "_curso", null)?:""
            val clase = prefs.getString(dni + "_clase", null)?:""
            return Alumno(dni, nombre, apellidos, curso, clase)
        }
        return null
    }

    fun obtenerUltimoAlumno(): Alumno? {
        val dniUltimo = prefs.getString("dniUltimo", "")
        if (!dniUltimo.isNullOrEmpty()) {
            return buscarAlumno(dniUltimo)
        }
        return null
    }
}

