package ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import training.TrainingState
import ui.auth.AuthScreen
import ui.auth.AuthViewModel
import ui.training.TrainingScreen
import ui.training.TrainingViewModel

@Composable
fun Navigator(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Routes.Training.route
    ) {

        screen(
            route = Routes.Training.route,
            content = {
                val state = TrainingState.empty(0.0)
                val params = mapOf("trainingState" to state)
                val viewModel = koinViewModel<TrainingViewModel> { parametersOf(SavedStateHandle(params)) }
                TrainingScreen(viewModel = viewModel)
            }
        )

        screen(
            route = Routes.Auth.route,
            content = {
                val viewModel = koinViewModel<AuthViewModel>()

                AuthScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        )

    }
}

private fun NavGraphBuilder.screen(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
    exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
    popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
    popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
    content = content
)

sealed class Routes(val route: String) {
    object Auth : Routes("auth_screen")
    object Training : Routes("training_screen")
}