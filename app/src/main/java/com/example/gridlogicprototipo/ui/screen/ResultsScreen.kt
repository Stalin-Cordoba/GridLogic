package com.example.gridlogicprototipo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.gridlogicprototipo.ui.viewmodel.GridLogicViewModel

@Composable
fun ResultsScreen(
    onGoHome: () -> Unit,
    viewModel: GridLogicViewModel,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        viewModel.registrarPuntajeEnBD()
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = verticalGradient(colors = listOf(DarkPurple, Purple40)))
            .verticalScroll(scrollState) //
            .padding(top = 80.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Test completado con éxito",
            fontSize = 32.sp,
            lineHeight = 40.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Tu Puntuación:",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "${viewModel.puntuacionFinal} / 1000 PTS",
            fontSize = 44.sp,
            color = Color.Cyan,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Text(
            text = viewModel.rangoDiagnostico,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFFFD700),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        if (viewModel.historialPuntajes.isNotEmpty()) {
            Text(
                text = "Historial de Intentos",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            viewModel.historialPuntajes.forEach { intento ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0x33FFFFFF)) // Blanco semitransparente
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Intento #${intento.id}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "${intento.puntuacion} pts",
                            color = Color.Cyan,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { onGoHome() }) {
            Text(text = "Volver a empezar", textAlign = TextAlign.Center, fontSize = 18.sp)
        }
    }
}