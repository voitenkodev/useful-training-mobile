package trainings.components

import Design
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.TrainingComponent
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import controls.ButtonPrimaryIcon
import platformInsets
import recomposeHighlighter
import training.Training

@Composable
internal fun TrainingPage(
    training: Training,
    editTraining: (trainingId: String) -> Unit,
) {

    val trainingProvider by rememberUpdatedState(training)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(Design.dp.paddingM),
        ) {

            TrainingTitle(
                weekDay = { training.weekDay },
                date = { training.endOfWeek },
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            ChartsInfo(
                training = trainingProvider
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingM)
            )

            TrainingComponent(
                modifier = Modifier
                    .recomposeHighlighter(),
                training = training,
            )

            Spacer(modifier = Modifier.size(Design.dp.paddingM))

            ButtonPrimaryIcon(
                imageVector = Icons.Default.KeyboardArrowRight,
                onClick = {
                    val id = trainingProvider.id ?: return@ButtonPrimaryIcon
                    editTraining(id)
                }
            )

            Spacer(modifier = Modifier.size(Design.dp.paddingM))
        }

        BrandGradientCenterEnd()

        BrandGradientCenterStart()
    }
}