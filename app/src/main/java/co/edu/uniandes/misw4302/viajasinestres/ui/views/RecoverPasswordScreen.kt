package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.fg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RecoverPasswordScreen(navController: NavHostController, snackbarHostState: SnackbarHostState, activityScope: CoroutineScope) {
    var correo by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .offset(y=-48.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .size(235.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.logo),
            contentDescription = null
        )
        Text(
            modifier = Modifier.offset(y=-36.dp),
            fontWeight = FontWeight.SemiBold,
            text = stringResource(R.string.title_recuperar_password),
            color = text_Titles,
            fontSize = 20.sp
        )

        Text(
            modifier = Modifier.offset(y=-20.dp),
            text = stringResource(R.string.text_recuperar_password),
            color = text_Titles,
            fontSize = 16.sp
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            BasicInput(
                field = correo,
                counter = false,
                onValueChanged = { updatedName ->
                    correo = updatedName
                },
                formPlaceholder = "Correo",
                testTag = "create-name"
            )


            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    onClick = {
                        activityScope.launch {
                            snackbarHostState.showSnackbar("Se han enviado las indicaciones a tu correo")
                        }

                        navController.navigate("login") {
                            popUpTo("login") {
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 16.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = bg_button,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Text(
                        stringResource(R.string.text_recuperar),
                        fontSize = 16.sp,
                        color = fg_button
                    )
                }
            }
        }
    }


}