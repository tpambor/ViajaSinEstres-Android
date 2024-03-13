package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.fg_button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RecoverPasswordMyAccountScreen(navController: NavHostController, snackbarHostState: SnackbarHostState, activityScope: CoroutineScope) {
    var password by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }
    var confirmarpassword by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }

    Column (
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            BasicInput(
                field = password,
                counter = false,
                password = true,
                onValueChanged = { updatedName ->
                    password = updatedName
                },
                formPlaceholder = "Nueva contraseña",
                testTag = "create-name"
            )

            BasicInput(
                field = confirmarpassword,
                counter = false,
                password = true,
                onValueChanged = { updatedName ->
                    confirmarpassword = updatedName
                },
                formPlaceholder = "Confirmar nueva contraseña",
                testTag = "create-name"
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {


                Button(
                    onClick = {
                        navController.navigate("user") {
                            activityScope.launch {
                                snackbarHostState.showSnackbar("Contraseña actualizada")
                            }

                            popUpTo("user") {
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
                        "Cambiar",
                        fontSize = 16.sp,
                        color = fg_button
                    )
                }
            }
        }
    }
}