package ui.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination

sealed class Router(val route: String, open var direction: Direction = Direction.FORWARD) {

    object Auth : Router(route = "auth_screen")

    object Trainings : Router(route = "trainings_screen")

    object Training : Router(route = "training_screen")

    object Review : Router(route = "review_screen")
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
        navigate(id)
    } else {
        navigate(route.route)
    }
}