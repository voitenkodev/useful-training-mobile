package ui.navigation

import android.os.Bundle
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import presentation.state.TrainingState

sealed class Router(val route: String, val args: Bundle, open var direction: Direction = Direction.FORWARD) {

    object Auth : Router(route = "auth_screen", args = bundleOf())

    object Trainings : Router(route = "trainings_screen", args = bundleOf())

    data class Training(
        val trainingState: TrainingState? = null
    ) : Router(ID, bundleOf(ARG to trainingState)) {
        companion object {
            const val ID = "training_screen"
            const val ARG = "trainingState"
        }
    }

    data class Review(
        val trainingState: TrainingState
    ) : Router(ID, bundleOf(ARG to trainingState)) {
        companion object {
            const val ID = "review_screen"
            const val ARG = "trainingState"
        }
    }
}

enum class Direction { FORWARD, BACK }

fun NavController.routeTo(route: Router) {
    if (route.direction == Direction.BACK) {
        popBackStack(route = route.route, inclusive = false)
        return
    }

    val routeLink = NavDeepLinkRequest
        .Builder
        .fromUri(NavDestination.createRoute(route.route).toUri())
        .build()

    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(id, route.args)
    } else {
        navigate(route.route)
    }
}