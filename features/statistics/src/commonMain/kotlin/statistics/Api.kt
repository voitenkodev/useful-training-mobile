package statistics

import androidx.compose.runtime.Composable
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import statistics.screen.StatisticsContent
import statistics.screen.StatisticsViewModel

@Parcelize
public sealed class StatisticsRouter : Parcelable {
    public data object Main : StatisticsRouter()
}

@Composable
public fun StatisticsGraph() {

    val router: Router<StatisticsRouter> = rememberRouter(StatisticsRouter::class) {
        listOf(StatisticsRouter.Main)
    }

    RoutedContent(router = router) { child ->
        when (child) {
            StatisticsRouter.Main -> {

                val vm = rememberOnRoute(StatisticsViewModel::class) {
                    StatisticsViewModel()
                }

                StatisticsContent(
                    vm = vm
                )
            }
        }
    }
}