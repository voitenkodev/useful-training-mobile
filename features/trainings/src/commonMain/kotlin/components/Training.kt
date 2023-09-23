package components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import training.Training

@Composable
internal fun TrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    color: Color,
    onClick: () -> Unit
) {

    val trainingProvider by rememberUpdatedState(training)

    Column(
        modifier = modifier
    ) {

        TrainingTitle(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color.copy(alpha = 0.2f))
                .padding(Design.dp.paddingM),
            mainTitle = { "At ${training.startTime}" },
            subTitle = { training.startLongDate },
            click = onClick,
            color = color
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

//        ButtonBrand(
//            modifier = Modifier.padding(horizontal = Design.dp.paddingM).fillMaxWidth(),
//            text = "Review",
//            onClick = onClick,
//            backgroundColor = Design.colors.accent_primary
//        )
    }
}
