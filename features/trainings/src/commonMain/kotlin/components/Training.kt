package components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import platformBottomInset
import training.Training

@Composable
internal fun TrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    onClick: () -> Unit
) {

    val trainingProvider by rememberUpdatedState(training)

    Column(
        modifier = modifier
    ) {

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        TrainingTitle(
            mainTitle = { "At ${training.startTime}" },
            click = onClick,
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        Column(
            modifier = Modifier.background(color = Design.colors.tertiary)
        ) {
            Spacer(
                modifier = Modifier.size(Design.dp.paddingM)
            )

            ChartsInfo(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                training = trainingProvider
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingM)
            )

            Exercises(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                training = trainingProvider,
            )

            Spacer(
                modifier = Modifier
                    .platformBottomInset()
                    .size(Design.dp.paddingM)
            )
        }
    }
}
