package statistic

import androidx.compose.runtime.Composable
import rememberViewModel
import statistic.screen.StatisticContent
import statistic.screen.StatisticViewModel

@Composable
public fun StatisticFeature() {
    val vm = rememberViewModel(StatisticViewModel::class) {
        StatisticViewModel()
    }

    StatisticContent(
        vm = vm,
    )
}