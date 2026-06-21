package com.example.gridlogicprototipo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.example.gridlogicprototipo.ui.theme.Purple40
import com.example.gridlogicprototipo.ui.theme.DarkPurple
import com.example.gridlogicprototipo.ui.theme.DarkBlue

@Composable
fun HomeScreen(onEmpezar: () -> Unit, modifier: Modifier = Modifier) {
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
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "GridLogic",
            fontSize = 36.sp,
            color = Purple40,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Este es un test que evalúa su capacidad de razonamiento. " +
                    "Está basado en las matrices progresivas de Raven.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "INSTRUCCIONES",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(230.dp)
                .padding(horizontal = 22.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkBlue),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "1. En cada ejercicio, se le mostrará una matriz, la cual lleva consigo un patrón.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "2. En cada matriz, hay una figura faltante.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "3. Debe elegir entre las diferentes " +
                            "opciones, la figura que considere que sea " +
                            "la que falta.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Cuenta con un tiempo límite de 12 minutos para realizarlo.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { onEmpezar() }) {
            Text(text = "Empezar", textAlign = TextAlign.Center)
        }
    }
}