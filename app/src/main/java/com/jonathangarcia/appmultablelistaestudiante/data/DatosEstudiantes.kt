package com.jonathangarcia.appmultablelistaestudiante.data

import com.jonathangarcia.appmultablelistaestudiante.R
import com.jonathangarcia.appmultablelistaestudiante.model.Estudiante

object DatosEstudiantes {
    val lista = mutableListOf(
        Estudiante("Juan", "Pérez", 20, R.drawable.estudiante1),
        Estudiante("María", "López", 22, R.drawable.estudiante2),
        Estudiante("Carlos", "Ramírez", 21, R.drawable.estudiante3),
        Estudiante("Ana", "Vargas", 19, R.drawable.estudiante4),
        Estudiante("Luis", "Torres", 23, R.drawable.estudiante5),
        Estudiante("Andrea", "Mendoza", 20, R.drawable.estudiante6),
        Estudiante("Pedro", "Santos", 24, R.drawable.estudiante7)
    )
}
