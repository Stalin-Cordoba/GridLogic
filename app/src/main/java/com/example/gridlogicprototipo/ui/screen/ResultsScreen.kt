package com.example.gridlogicprototipo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridlogicprototipo.ui.theme.DarkPurple
import com.example.gridlogicprototipo.ui.theme.Purple40

@Composable
fun ResultsScreen(onGoHome: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = verticalGradient(
                    colors = listOf(
                        DarkPurple,
                        Purple40,
                    ),
                ),
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Test completado con éxito",
            fontSize = 36.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Resumen de Evaluación:",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Purple40,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ha finalizado exitosamente los ejercicios de matrices progresivas. " +
                    "Para la version final, aquí verá su puntuación y un breve análisis de su capacidad visual-espacial"+
                    " según los resultados obtenidos.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { onGoHome() }) {
            Text(text = "Volver a empezar", textAlign = TextAlign.Center, fontSize = 18.sp)
        }
    }
}