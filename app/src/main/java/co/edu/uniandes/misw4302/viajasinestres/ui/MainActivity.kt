package co.edu.uniandes.misw4302.viajasinestres.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import co.edu.uniandes.misw4302.viajasinestres.ui.theme.ViajaSinEstresTheme
import co.edu.uniandes.misw4302.viajasinestres.ui.views.NavBar
import co.edu.uniandes.misw4302.viajasinestres.ui.views.NavContent
import co.edu.uniandes.misw4302.viajasinestres.ui.views.TopNavBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                        )
                    },
                )
            }
        }
    }
}
