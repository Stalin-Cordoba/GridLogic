package com.example.gridlogicprototipo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = verticalGradient(colors = listOf(DarkPurple, Purple40))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Test completado con éxito",
            fontSize = 32.sp,
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

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Perfil psicométrico:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )

        Text(
            text = viewModel.rangoDiagnostico,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFFFD700),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { onGoHome() }) {
            Text(text = "Volver a empezar", textAlign = TextAlign.Center, fontSize = 18.sp)
        }
    }
}