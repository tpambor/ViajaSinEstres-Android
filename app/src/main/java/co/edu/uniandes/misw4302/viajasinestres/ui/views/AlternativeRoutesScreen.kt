package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles

@Composable
fun ChipPrice(price: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 5.dp, horizontal = 12.dp)
    ) {
        Text(
            text = "$ $price",
            color = text_Titles,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun AlternativeRoutesScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Top
    ){
        BasicCard(
            title = "Ruta 1",
            salida = "7:30am",
            llegada = "8:50am",
            chip = { ChipPrice(3300) },
            onClick = { }
        )

        BasicCard(
            title = "Ruta 2",
            salida = "7:35am",
            llegada = "8:50am",
            chip = { ChipPrice(4200) },
            onClick = { }
        )

        BasicCard(
            title = "Ruta 3",
            salida = "7:25am",
            llegada = "8:40am",
            chip = { ChipPrice(3700) },
            onClick = { }
        )

        BasicCard(
            title = "Ruta 4",
            salida = "7:55am",
            llegada = "9:00am",
            chip = { ChipPrice(3500) },
            onClick = { }
        )

        BasicCard(
            title = "Ruta 5",
            salida = "8:00am",
            llegada = "9:00am",
            chip = { ChipPrice(4500) },
            onClick = { }
        )

        BasicCard(
            title = "Ruta 6",
            salida = "8:10am",
            llegada = "8:50am",
            chip = { ChipPrice(5000) },
            onClick = { }
        )
    }
}