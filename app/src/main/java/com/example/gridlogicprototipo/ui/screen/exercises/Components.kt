package com.example.gridlogicprototipo.ui.screen.exercises

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gridlogicprototipo.ui.model.Figura
import com.example.gridlogicprototipo.ui.model.Opcion

@Composable
fun DibujarFiguraCentralizada(
    tipoFigura: Figura,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    Canvas(modifier = modifier) {
        val tamano = size.minDimension
        val centro = Offset(this.size.width / 2f, this.size.height / 2f)

        when (tipoFigura) {
            Figura.CUADRADO -> {
                drawRect(
                    color = color,
                    topLeft = Offset(centro.x - (tamano / 2f), centro.y - (tamano / 2f)),
                    size = Size(tamano, tamano),
                )
            }
            Figura.CIRCULO -> {
                drawCircle(color = color, radius = tamano / 2f, center = centro)
            }
            Figura.TRIANGULO -> {
                val ruta = Path().apply {
                    moveTo(centro.x, centro.y - (tamano / 2f))
                    lineTo(centro.x - (tamano / 2f), centro.y + (tamano / 2f))
                    lineTo(centro.x + (tamano / 2f), centro.y + (tamano / 2f))
                    close()
                }
                drawPath(ruta, color)
            }
            Figura.ESTRELLA -> {
                val ruta = Path().apply {
                    val radioExterior = tamano / 2f
                    val radioInterior = tamano / 5f
                    for (i in 0 until 10) {
                        val angulo = (((Math.PI * i) / 5.0) - (Math.PI / 2.0)).toFloat()
                        val r = if ((i % 2) == 0) radioExterior else radioInterior
                        val x = centro.x + (r * kotlin.math.cos(angulo))
                        val y = centro.y + (r * kotlin.math.sin(angulo))
                        if (i == 0) moveTo(x, y) else lineTo(x, y)
                    }
                    close()
                }
                drawPath(ruta, color)
            }
            Figura.DIAMANTE -> {
                val ruta = Path().apply {
                    moveTo(centro.x, centro.y - (tamano / 2f))
                    lineTo(centro.x + (tamano / 2f), centro.y)
                    lineTo(centro.x, centro.y + (tamano / 2f))
                    lineTo(centro.x - (tamano / 2f), centro.y)
                    close()
                }
                drawPath(ruta, color)
            }
            Figura.HEXAGONO -> {
                val ruta = Path().apply {
                    for (i in 0 until 6) {
                        val angulo = (Math.PI * i / 3.0).toFloat()
                        val x = centro.x + ((tamano / 2f) * kotlin.math.cos(angulo))
                        val y = centro.y + ((tamano / 2f) * kotlin.math.sin(angulo))
                        if (i == 0) moveTo(x, y) else lineTo(x, y)
                    }
                    close()
                }
                drawPath(ruta, color)
            }
            Figura.CRUZ -> {
                val anchoBarra = tamano / 3f
                drawRect(
                    color = color,
                    topLeft = Offset(centro.x - (anchoBarra / 2f), centro.y - (tamano / 2f)),
                    size = Size(anchoBarra, tamano),
                )
                drawRect(
                    color = color,
                    topLeft = Offset(centro.x - (tamano / 2f), centro.y - (anchoBarra / 2f)),
                    size = Size(tamano, anchoBarra),
                )
            }
            Figura.LUNA -> {
                drawCircle(color = color, radius = tamano / 2f, center = centro)
                drawCircle(color = Color.White,
                    radius = tamano / 2.5f, center = Offset(centro.x + (tamano / 4f),
                        centro.y - (tamano / 10f)))
            }
            Figura.RAYO -> {
                val ruta = Path().apply {
                    moveTo(centro.x + (tamano / 4f), centro.y - (tamano / 2f))
                    lineTo(centro.x - (tamano / 2f), centro.y + (tamano / 10f))
                    lineTo(centro.x, centro.y + (tamano / 10f))
                    lineTo(centro.x - (tamano / 4f), centro.y + (tamano / 2f))
                    lineTo(centro.x + (tamano / 2f), centro.y - (tamano / 10f))
                    lineTo(centro.x, centro.y - (tamano / 10f))
                    close()
                }
                drawPath(ruta, color)
            }
        }
    }
}

@Composable
fun TarjetaOpcion(
    opcion: Opcion,
    estaSeleccionado: Boolean,
    alSeleccionar: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = opcion.etiqueta, color = Color.White, fontWeight = FontWeight.Bold)
        Card(
            modifier = Modifier
                .aspectRatio(1.1f)
                .fillMaxWidth()
                .clickable { alSeleccionar() }
                .border(
                    width = if (estaSeleccionado) 3.dp else 0.dp,
                    color = if (estaSeleccionado) Color.Cyan else Color.Transparent,
                    shape = RoundedCornerShape(8.dp),
                ),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                DibujarFiguraCentralizada(
                    tipoFigura = opcion.tipoFigura,
                    modifier = Modifier.size(35.dp),
                    color = Color(0xFF4A148C),
                )
            }
        }
    }
}