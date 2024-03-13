package co.edu.uniandes.misw4302.viajasinestres.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.ViajaSinEstresTheme
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.text_Titles
import co.edu.uniandes.misw4302.viajasinestres.ui.views.NavBar
import co.edu.uniandes.misw4302.viajasinestres.ui.views.NavContent
import co.edu.uniandes.misw4302.viajasinestres.ui.views.TopNavBar

const val NOTIFICATION_CHANNEL_ID = "viajasinestres_alarm"

class MainActivity : ComponentActivity() {
    private fun setupNotifications() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationChannel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            "Alarms",
            NotificationManager.IMPORTANCE_HIGH
        )

        // Configure the notification channel.
        notificationChannel.description = "Alarms para llegar a tiempo"
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.Red.toArgb()
        notificationChannel.enableVibration(true)
        notificationManager.createNotificationChannel(notificationChannel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNotifications()

        val alarmId = intent.getIntExtra("co.edu.uniandes.misw4302.viajasinestres.alarmId", -1)

        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val activityScope = rememberCoroutineScope()

            ViajaSinEstresTheme(currentBackStackEntry) {
                Scaffold(
                    topBar = {
                        TopNavBar(navController, currentBackStackEntry)
                    },
                    content = { padding ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            NavContent(navController, snackbarHostState, activityScope)
                        }
                    },
                    bottomBar = {
                        NavBar(navController, currentBackStackEntry)
                    },
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState
                        ) {
                            Snackbar(
                                it,
                                containerColor = text_Titles,
                                contentColor = MaterialTheme.colorScheme.background
                            )
                        }
                    },
                )
            }

            LaunchedEffect (alarmId) {
                if (alarmId == 1) {
                    Log.e("TEST", "Notification1")
                    navController.navigate("alarms")
                    navController.navigate("alarms/1")
                } else if (alarmId == 2) {
                    Log.e("TEST", "Notification2")
                    navController.navigate("alarms")
                    navController.navigate("alarms/2")
                }
            }
        }
    }
}
