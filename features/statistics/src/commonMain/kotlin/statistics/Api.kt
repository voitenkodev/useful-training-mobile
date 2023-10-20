package statistics

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import statistics.screen.StatisticContent
import statistics.screen.StatisticViewModel

@Composable
public fun StatisticFeature() {

    val vm = rememberOnRoute(StatisticViewModel::class) {
        StatisticViewModel()
    }

    StatisticContent(
        vm = vm
    )
}