package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_input
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles

@Composable
fun UserScreen(navController: NavHostController) {
    var nombre by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }
    var correo by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Image(
            modifier = Modifier
                .size(130.dp)
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.myaccount),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(bg_input)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Nombre",
                modifier = Modifier.fillMaxWidth().weight(1.0f),
                color = text_Titles
            )

            Text(
                text = "Martha Aristizabal",
                color = text_Titles,
                modifier = Modifier.fillMaxWidth().weight(1.0f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(bg_input)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Correo")

                },
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth().weight(1.0f),
                color = text_Titles

            )

            Text(
                text = "martha@correos.co",
                color = text_Titles,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth().weight(1.0f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {


            Button(
                onClick = { navController.navigate("user/changePassword") },
                modifier = Modifier
                    .padding(0.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = bg_button,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    "Cambiar contraseña",
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1.0f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate("login") },
                border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(text_Titles))
            ) {
                Text(
                    "Cerrar sesión",
                    color = text_Titles,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}