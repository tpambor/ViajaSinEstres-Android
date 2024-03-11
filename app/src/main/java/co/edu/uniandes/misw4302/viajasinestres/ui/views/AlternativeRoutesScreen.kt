package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_input
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_nav
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles

@Composable
fun AlternativeRoutesScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(160.dp)
                .border(1.dp, bg_input,shape = RoundedCornerShape(50.dp))

        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Ruta 1",
                    color = text_Titles,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$3300",
                        color = text_Titles,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(0.dp, 10.dp, 0.dp, 10.dp)
                            .height(22.dp)
                            .width(60.dp)
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp)),
                        fontSize = 16.sp

                    )
                }

                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "Salida: 7:30am", color = text_Titles)
                        Text(text = "Llegada: 8:20am", color = text_Titles)
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bus_icon),
                        contentDescription = "Bus Icon",
                        modifier = Modifier.size(2500.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(160.dp)
                .border(1.dp, bg_input,shape = RoundedCornerShape(50.dp)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Ruta 1",
                    color = text_Titles,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$3300",
                        color = text_Titles,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(0.dp, 10.dp, 0.dp, 10.dp)
                            .height(22.dp)
                            .width(60.dp)
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp)),
                        fontSize = 16.sp

                    )
                }

                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "Salida: 7:30am", color = text_Titles)
                        Text(text = "Llegada: 8:20am", color = text_Titles)
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bus_icon),
                        contentDescription = "Bus Icon",
                        modifier = Modifier.size(2500.dp)
                    )
                }
            }
        }
    }
}
