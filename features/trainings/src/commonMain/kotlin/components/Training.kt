package components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import training.Training

@Composable
internal fun TrainingItem(training: Training) {

    val trainingProvider by rememberUpdatedState(training)

    Column(
        modifier = Modifier
            .padding(Design.dp.paddingM),
    ) {

        TrainingTitle(
            mainTitle = { training.weekDay },
            subTitle = { training.startLongDate },
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        ChartsInfo(
            training = trainingProvider
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        Exercises(
            training = trainingProvider,
        )
    }
}
