package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_tarjeta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicCard(
    title: String,
    salida: String,
    llegada: String,
    chip: @Composable () -> Unit,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xffDEEDE1),

        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                color = text_tarjeta,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            chip()

            Spacer(modifier = Modifier.height(12.dp))

            Row {
                Column {
                    Text(
                        text = "Salida:",
                        color = text_tarjeta,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Llegada:",
                        color = text_tarjeta,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = salida,
                        color = text_tarjeta,
                        fontSize = 16.sp
                    )
                    Text(
                        text = llegada,
                        color = text_tarjeta,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1.0f))
                Image(
                    painter = painterResource(id = R.drawable.outline_directions_bus_40),
                    contentDescription = "Bus Icon",
                    colorFilter = ColorFilter.tint(text_tarjeta),
                    modifier = Modifier.size(44.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}
