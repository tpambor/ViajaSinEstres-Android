package co.edu.uniandes.misw4302.viajasinestres.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.NavBackStackEntry

private val LightColorScheme = lightColorScheme(
    primary = bg_green,
    secondary = bg_button,
    tertiary = bg_white,

    background = Color(0xfff4f8f2)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ViajaSinEstresTheme(
    currentBackStackEntry: NavBackStackEntry?,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    val route = currentBackStackEntry?.destination?.route

    val fullscreen = (
        route == "login" ||
        route == "recoverPassword" ||
        route == "register"
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            if (fullscreen) {
                window.statusBarColor = colorScheme.background.toArgb()
                window.navigationBarColor = Color(0xff222222).toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
            }
            else {
                window.statusBarColor = Color(0xff222222).toArgb()
                window.navigationBarColor = Color(0xff222222).toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
