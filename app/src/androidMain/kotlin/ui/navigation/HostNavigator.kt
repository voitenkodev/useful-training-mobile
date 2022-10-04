package ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.koinViewModel
import redux.TrainingState
import redux.rememberDispatcher
import ui.auth.AuthScreen
import ui.review.ReviewScreen
import ui.training.TrainingScreen
import ui.trainings.TrainingsScreen

@Composable
fun HostNavigator(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Router.Auth.route
    ) {

        screen(
            route = Router.Auth.route,
            content = {
                AuthScreen(
                    viewModel = koinViewModel(),
                    navigate = { navController.routeTo(route = it) }
                )
            }
        )

        screen(
            route = Router.Training.route,
            content = {
                TrainingScreen(
                    viewModel = koinViewModel(),
                    navigate = { navController.routeTo(route = it) }
                )
            }
        )

        screen(
            route = Router.Review.route,
            content = {
                ReviewScreen(
                    viewModel = koinViewModel(),
                    navigate = { navController.routeTo(route = it) }
                )
            }
        )

        screen(
            route = Router.Trainings.route,
            content = {
                TrainingsScreen(
                    viewModel = koinViewModel(),
                    navigate = { navController.routeTo(route = it) }
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