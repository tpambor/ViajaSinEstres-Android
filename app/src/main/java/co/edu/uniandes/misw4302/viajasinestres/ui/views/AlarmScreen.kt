package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.fg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles

@Composable
fun StatusHeaderPuntual(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(R.drawable.baseline_check_24),
                contentDescription = "",
                tint = text_Titles,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp)
            )

            Text(
                fontWeight = FontWeight.SemiBold,
                text = "Todo a tiempo",
                color = text_Titles,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = { navController.navigate("alarms/2") },
            border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(text_Titles))
        ) {
            Text(
                "Posponer viaje",
                color = text_Titles,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun StatusHeaderRetraso(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(R.drawable.baseline_error_24),
                contentDescription = "",
                tint = Color(0xffEE1010),
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp)
            )

            Text(
                fontWeight = FontWeight.SemiBold,
                text = "Accidente en calle 7",
                color = text_Titles,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Se estima que el problema persiste hasta las 11:00am.",
            color = text_Titles,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = bg_button
            )
        ) {
            Text(
                "Rutas alternativas",
                fontSize = 16.sp,
                color = fg_button
            )
        }
    }
}

@Composable
fun TimeTable(planeada: String, estimada: String) {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 16.dp)
    ) {
        Text(
            fontWeight = FontWeight.SemiBold,
            text = "Llegada al destino",
            color = text_Titles,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row (modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Planeada:",
                color = text_Titles,
            )

            Spacer(modifier = Modifier.weight(1.0f))

            Text(
                text = planeada,
                color = text_Titles,
                textAlign = TextAlign.End
            )
        }

        Row (modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Estimada:",
                color = text_Titles,
            )

            Spacer(modifier = Modifier.weight(1.0f))

            Text(
                text = estimada,
                color = text_Titles,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun Station(highlight: Boolean, @DrawableRes image: Int, nombre: String, salida: String) {
    Row(
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)
    ) {
        Canvas(
            modifier = Modifier
                .width(24.dp)
                .fillMaxHeight()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val blockHeight = 8.dp.toPx()
            val lineWidth = 2.dp.toPx()

            if (highlight) {
                drawCircle(
                    Color(0xff24422A),
                    radius = canvasWidth/2.0f,
                    center = this.center
                )
            } else {
                drawRect(
                    Color(0xff7BB787),
                    topLeft = Offset(0.0f, canvasHeight / 2.0f - blockHeight / 2.0f),
                    size = Size(canvasWidth, blockHeight)
                )
            }

            drawRect(
                Color(0xff24422A),
                topLeft = Offset(canvasWidth/2.0f - lineWidth/2.0f, 0.0f),
                size = Size(lineWidth, canvasHeight)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .width(40.dp),
                painter = painterResource(image),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier.padding(start = 16.dp, bottom = 4.dp, top = 4.dp)
        ) {
            Text(
                fontWeight = FontWeight.SemiBold,
                text = nombre,
                color = text_Titles,
                fontSize = 18.sp
            )

            Row {
                Text(
                    text = "Salida:",
                    color = text_Titles,
                )

                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = salida,
                    color = text_Titles,
                )
            }

            Text(
                text = "A tiempo",
                color = text_Titles,
            )
        }
    }
}

@Composable
fun Mapa() {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 16.dp)
    ) {
        Text(
            fontWeight = FontWeight.SemiBold,
            text = "Mapa",
            color = text_Titles,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.mapa),
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )
    }
}

@Composable
fun StationList() {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 16.dp)
    ) {
        Text(
            fontWeight = FontWeight.SemiBold,
            text = "Estaciones",
            color = text_Titles,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Station(
            highlight = false,
            image = R.drawable.station1,
            nombre = "Las Acacias",
            salida = "7:10am"
        )
        Station(
            highlight = true,
            image = R.drawable.station2,
            nombre = "Mirador de la secreta",
            salida = "7:20am"
        )
        Station(
            highlight = false,
            image = R.drawable.station3,
            nombre = "Terminal de transporte",
            salida = "7:30am"
        )
        Station(
            highlight = false,
            image = R.drawable.station4,
            nombre = "Puente de la Cejita",
            salida = "7:40am"
        )
        Station(
            highlight = false,
            image = R.drawable.station5,
            nombre = "Telecom",
            salida = "7:50am"
        )
    }
}

@Composable
fun AlarmScreenPuntual(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        StatusHeaderPuntual(navController)

        Divider(color = Color(0xff9CC9A5))

        TimeTable("8:20am", "8:15am")

        Divider(color = Color(0xff9CC9A5))

        StationList()

        Divider(color = Color(0xff9CC9A5))

        Mapa()
    }
}

@Composable
fun AlarmScreenRetraso(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        StatusHeaderRetraso(navController)

        Divider(color = Color(0xff9CC9A5))

        TimeTable("10:40am", "11:05am")

        Divider(color = Color(0xff9CC9A5))

        StationList()

        Divider(color = Color(0xff9CC9A5))

        Mapa()
    }
}
