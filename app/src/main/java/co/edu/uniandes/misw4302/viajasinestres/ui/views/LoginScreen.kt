package co.edu.uniandes.misw4302.viajasinestres.ui.views

import android.Manifest
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavHostController
import co.edu.uniandes.misw4302.viajasinestres.R
import co.edu.uniandes.misw4302.viajasinestres.ui.MainActivity
import co.edu.uniandes.misw4302.viajasinestres.ui.NOTIFICATION_CHANNEL_ID
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.bg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.fg_button
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles

@Composable
fun LoginScreen(navController: NavHostController) {
    var correo by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }
    var password by remember { mutableStateOf(FormField(value = "", error = false, errorMsg = "")) }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        val notificationManager = getSystemService(context, NotificationManager::class.java) as NotificationManager

        val activityActionIntent1 = Intent(context, MainActivity::class.java)
        activityActionIntent1.putExtra("co.edu.uniandes.misw4302.viajasinestres.alarmId", 1)
        activityActionIntent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        val activityActionPendingIntent1: PendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityActionIntent1,
            PendingIntent.FLAG_UPDATE_CURRENT + PendingIntent.FLAG_MUTABLE
        )

        val activityActionIntent2 = Intent(context, MainActivity::class.java)
        activityActionIntent2.putExtra("co.edu.uniandes.misw4302.viajasinestres.alarmId", 2)
        activityActionIntent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        val activityActionPendingIntent2: PendingIntent = PendingIntent.getActivity(
            context,
            2,
            activityActionIntent2,
            PendingIntent.FLAG_UPDATE_CURRENT + PendingIntent.FLAG_MUTABLE
        )

        val notificationBuilder1 = Notification.Builder(context, NOTIFICATION_CHANNEL_ID)
        notificationBuilder1.setAutoCancel(true)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.baseline_departure_board_24)
            .setContentTitle("Comienza Casa a oficina")
            .setContentText("Toma bus 3 en la parada Calle 22 a las 7:15.")
            .setContentIntent(activityActionPendingIntent1)

        notificationManager.notify(1, notificationBuilder1.build())

        val notificationBuilder2 = Notification.Builder(context, NOTIFICATION_CHANNEL_ID)
        notificationBuilder2.setAutoCancel(true)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.baseline_departure_board_24)
            .setContentTitle("Retraso en Casa a deporte")
            .setContentText("Hay 25 minutos de retraso. Consulta las rutas alternativas.")
            .setContentIntent(activityActionPendingIntent2)

        notificationManager.notify(2, notificationBuilder2.build())

        navController.navigate("alarms")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(16.dp))

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
            text = stringResource(R.string.login_instruction),
            color = text_Titles,
            fontSize = 20.sp
        )

        BasicInput(
            field = correo,
            counter = false,
            onValueChanged = { updatedName ->
                correo = updatedName
            },
            formPlaceholder = "Correo",
            testTag = "create-name"
        )

        Spacer(modifier = Modifier.height(12.dp))

        BasicInput(
            field = password,
            password = true,
            counter = false,
            onValueChanged = { updatedName ->
                password = updatedName
            },
            formPlaceholder = "Contraseña",
            testTag = "create-name"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Olvidé mi contraseña",
                color = text_Titles,
                modifier = Modifier.clickable {
                    navController.navigate("recoverPassword")
                }.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {


            Button(
                onClick = {
                    launcher.launch(
                        Manifest.permission.POST_NOTIFICATIONS
                    )
                },
                modifier = Modifier
                    .padding(0.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = bg_button,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    stringResource(R.string.login_visitor),
                    fontSize = 16.sp,
                    color = fg_button
                )
            }


        }

        Spacer(modifier = Modifier.weight(1.0f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = buildAnnotatedString {
                    append("¿Aun no estas registrado? ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Registrate")
                    }
                },
                color = text_Titles,
                modifier = Modifier
                    .clickable {
                    }
                    .padding(vertical = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }


}


data class FormField(
    var value: String,
    var error: Boolean = false,
    var errorMsg: String = ""
)

@Composable
fun BasicInput(
    field: FormField,
    counter: Boolean = false,
    password: Boolean = false,
    counterMaxLength: Int? = null,
    onValueChanged: (FormField) -> Unit,
    formPlaceholder: String,
    minLines: Int = 1,
    testTag: String,
) {
    OutlinedTextField(
        value = field.value,
        onValueChange = { newValue ->
            onValueChanged(field.copy(value = newValue))
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xff24422A),
            focusedBorderColor = Color(0xff24422A),
            unfocusedTextColor = Color(0xff24422A),
            focusedTextColor = Color(0xff24422A),
            focusedLabelColor = Color(0xff24422A),
            unfocusedLabelColor = Color(0xff24422A),
            cursorColor = Color(0xff24422A),
            selectionColors = TextSelectionColors(
                handleColor = Color(0xff24422A),
                backgroundColor = Color(0xff9CC9A5)
            )
        ),
        visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (password) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        minLines = minLines,
        label = { Text(formPlaceholder) },
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag),
        isError = field.error,
        supportingText = {
            if (field.errorMsg.isNotEmpty())
                Text(text = field.errorMsg, modifier = Modifier.padding(bottom = 8.dp))
            else if(counter) {
                Text(
                    text = "${ field.value.length} / $counterMaxLength",
                    modifier = Modifier
                        .fillMaxWidth()
                        .semantics {
                            contentDescription =
                                "${field.value.length} de $counterMaxLength caracteres utilizados"
                        },
                    textAlign = TextAlign.End,
                )
            }
        }
    )
}

