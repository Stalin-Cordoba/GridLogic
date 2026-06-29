package com.example.gridlogicprototipo.ui.screen.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridlogicprototipo.ui.model.Opcion
import com.example.gridlogicprototipo.ui.theme.DarkPurple
import com.example.gridlogicprototipo.ui.viewmodel.GridLogicViewModel

@Composable
fun TestScreen(
    viewModel: GridLogicViewModel,
    onTestTerminado: () -> Unit,
    modifier: Modifier = Modifier
) {
    val ejercicioActual = viewModel.obtenerEjercicioActual()
    val preguntaNumero = viewModel.indiceActual + 1
    val totalPreguntas = viewModel.ejerciciosTest.size

    if (ejercicioActual == null || totalPreguntas == 0) {
        LaunchedEffect(Unit) {
            onTestTerminado()
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Procesando resultados...", color = Color.White)
        }
        return
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = verticalGradient(colors = listOf(DarkPurple, Color(0xFF1A0B3B)))),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ejercicio $preguntaNumero / $totalPreguntas",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "⏱ ${viewModel.tiempoRestanteUI}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .aspectRatio(1.2f),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = ejercicioActual.imagenMatrizResId),
                contentDescription = "Matriz principal",
                modifier = Modifier.fillMaxSize().padding(8.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Seleccione su respuesta:", color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(if (ejercicioActual.opciones.size == 8) 4 else 3),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(ejercicioActual.opciones.size) { indice ->
                val opcion = ejercicioActual.opciones[indice]
                TarjetaImagenOpcion(opcion = opcion) {
                    viewModel.registrarRespuestaYavanzar(
                        ejercicioId = ejercicioActual.id,
                        opcionId = opcion.id,
                        onTestTerminado = onTestTerminado
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaImagenOpcion(
    opcion: Opcion,
    alSeleccionar: () -> Unit
) {
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .clickable { alSeleccionar() }
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = opcion.imagenResId),
                contentDescription = "Opción ${opcion.etiqueta}",
                modifier = Modifier.weight(1f).padding(4.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = opcion.etiqueta,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}