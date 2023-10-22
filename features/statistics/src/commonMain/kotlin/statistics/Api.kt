package statistics

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import statistics.screen.StatisticsContent
import statistics.screen.StatisticsViewModel

@Composable
public fun StatisticFeature() {

    val vm = rememberOnRoute(StatisticsViewModel::class) {
        StatisticsViewModel()
    }

    StatisticsContent(
        vm = vm
    )
}