package co.edu.uniandes.misw4302.viajasinestres.ui.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.edu.uniandes.misw4302.viajasinestres.R
import kotlinx.coroutines.CoroutineScope

sealed class NavBarItem(val route: String, @StringRes val stringId: Int, @DrawableRes val iconId: Int) {
    data object Albums : NavBarItem("alarms", R.string.nav_alarms, R.drawable.baseline_train_24)
    data object Artists : NavBarItem("user", R.string.nav_user, R.drawable.baseline_account_circle_24)
}

private val navBarItems = listOf(
    NavBarItem.Albums,
    NavBarItem.Artists,
)

@Composable
fun NavContent(navController: NavHostController, snackbarHostState: SnackbarHostState, activityScope: CoroutineScope) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") { LoginScreen(navController) }
        composable(route = "login/recover") { RecoverPasswordScreen(navController) }
        composable(route = "alarms") { AlarmListScreen(navController) }
        composable(route = "user") { UserScreen(navController) }
    }
}

@Composable
fun NavBar(navController: NavHostController, currentBackStackEntry: NavBackStackEntry?) {
    val route = currentBackStackEntry?.destination?.route

    // Do not display NavigationBar for login screen
    if (route == "login")
        return

    NavigationBar(
        modifier = Modifier.testTag("navbar")
    ) {
        navBarItems.forEach { item ->
            NavigationBarItem(
                selected = route?.startsWith(item.route) ?: false,
                label = { Text(stringResource(item.stringId), maxLines = 1, overflow = TextOverflow.Ellipsis) },
                icon = { Icon(painterResource(item.iconId), contentDescription = null) },
                onClick = {
                    if (item.route == route) return@NavigationBarItem

                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {}
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(navController: NavHostController, currentBackStackEntry: NavBackStackEntry?) {
    val route = currentBackStackEntry?.destination?.route

    val title = when (route) {
        "alarms" -> "Tus próximos viajes"
        else -> ""
    }

    val visible = !(
        route == "login" ||
        route == "register"
    )

    AnimatedVisibility(visible) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                IconButton(
                    onClick = { navController.navigateUp()}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            modifier = Modifier.semantics { this.contentDescription = title }
        )
    }
}
