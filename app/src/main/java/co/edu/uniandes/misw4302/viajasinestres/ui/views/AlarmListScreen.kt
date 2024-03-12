package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R

@Composable
fun ChipPuntual() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color(0xff36633F), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 5.dp, horizontal = 12.dp)
    ) {
        Icon(
            painterResource(R.drawable.baseline_check_24),
            contentDescription = "",
            tint = Color(0xffF4F8F2),
            modifier = Modifier.padding(end = 4.dp).size(20.dp)
        )

        Text(
            text = "Puntual",
            color = Color(0xffF4F8F2),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ChipRetraso(time: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color(0xffee1010), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 5.dp, horizontal = 12.dp)
    ) {
        Icon(
            painterResource(R.drawable.baseline_warning_amber_24),
            contentDescription = "",
            tint = Color(0xffF4F8F2),
            modifier = Modifier.padding(end = 4.dp).size(20.dp)
        )

        Text(
            text = "Retraso $time",
            color = Color(0xffF4F8F2),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun AlarmListScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Top
    ){
        BasicCard(
            title = "Casa a oficina",
            salida = "7:30am",
            llegada = "8:50am",
            chip = { ChipPuntual() },
            onClick = { navController.navigate("AlternativeRoutes") }
        )

        BasicCard(
            title = "Casa a deporte",
            salida = "10:20am",
            llegada = "11:05am",
            chip = { ChipRetraso("+25 min") },
            onClick = { navController.navigate("AlternativeRoutes") }
        )
    }
}
