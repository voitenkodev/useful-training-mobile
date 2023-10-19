package graph

import RoutedContent
import Router
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import rememberRouter

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistic : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph() {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class, listOf(BottomMenuRouter.Trainings))

    val menu = listOf(
        Icons.Default.Search to "Search",
        Icons.Default.CheckCircle to "Statistic",
    )

    RoutedContent(
        router = router,
        animation = stackAnimation()
    ) { child ->

        BottomMenuFeature(
            items = menu,
            onClick = {

            },
            screen = {
                when (child) {
                    BottomMenuRouter.Statistic -> {}
                    BottomMenuRouter.Trainings -> TrainingsGraph()
                }

            }
        )
    }
}