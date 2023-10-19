package graph

import RoutedContent
import Router
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import rememberRouter
import statistic.StatisticFeature

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistic : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph() {

    val router: Router<BottomMenuRouter> = rememberRouter(
        BottomMenuRouter::class,
        listOf(BottomMenuRouter.Trainings)
    )

    val menu = listOf(
        Icons.Default.Search to "Search",
        Icons.Default.CheckCircle to "Statistic",
    )

    BottomMenuFeature(
        items = menu,
        onClick = {
            val newRoute = when (it) {
                0 -> BottomMenuRouter.Trainings
                else -> BottomMenuRouter.Statistic
            }
            router.bringToFront(newRoute)
        },
        screen = {
            RoutedContent(
                router = router,
                animation = stackAnimation()
            ) { child ->

                when (child) {
                    BottomMenuRouter.Trainings -> TrainingsGraph()
                    BottomMenuRouter.Statistic -> StatisticFeature()
                }
            }
        }
    )
}