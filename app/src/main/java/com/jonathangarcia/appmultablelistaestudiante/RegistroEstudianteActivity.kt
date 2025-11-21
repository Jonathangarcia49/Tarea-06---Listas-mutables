package com.jonathangarcia.appmultablelistaestudiante

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jonathangarcia.appmultablelistaestudiante.data.DatosEstudiantes
import com.jonathangarcia.appmultablelistaestudiante.model.Estudiante

class RegistroEstudianteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegistroEstudianteUI(this)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroEstudianteUI(context: Context) {

    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Registrar Estudiante") }) }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 112.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = nombres,
                onValueChange = { nombres = it },
                label = { Text("Nombres") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it },
                label = { Text("Apellidos") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (nombres.isNotEmpty() &&
                        apellidos.isNotEmpty() &&
                        edad.isNotEmpty()
                    ) {

                        DatosEstudiantes.lista.add(
                            Estudiante(
                                nombres,
                                apellidos,
                                edad.toInt(),
                                R.drawable.estudiante1
                            )
                        )

                        Toast.makeText(context, "Estudiante registrado", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
