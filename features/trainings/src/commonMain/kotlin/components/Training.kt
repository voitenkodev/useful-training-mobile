package components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import controls.ButtonBrand
import training.Training

@Composable
internal fun TrainingItem(
    training: Training,
    onClick: () -> Unit
) {

    val trainingProvider by rememberUpdatedState(training)

    Column(
        modifier = Modifier.padding(vertical = Design.dp.paddingM),
    ) {

        TrainingTitle(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            mainTitle = { "At ${training.startTime}" },
            subTitle = { training.startLongDate },
        )

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
            modifier = Modifier.size(Design.dp.paddingM)
        )

        ButtonBrand(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM).fillMaxWidth(),
            text = "Review",
            onClick = onClick,
            backgroundColor = Design.colors.accent_primary
        )
    }
}
