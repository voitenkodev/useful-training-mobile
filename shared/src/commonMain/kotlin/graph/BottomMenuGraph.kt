package graph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import statistic.StatisticFeature

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistic : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph() {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class) {
        listOf(BottomMenuRouter.Trainings)
    }

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
            ) { child ->

                when (child) {
                    BottomMenuRouter.Trainings -> TrainingsGraph()
                    BottomMenuRouter.Statistic -> StatisticFeature()
                }
            }
        }
    )
}