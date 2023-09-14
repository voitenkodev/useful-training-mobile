package trainings.components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import controls.ButtonSecondaryIcon
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
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingL)
        ) {

            TrainingTitle(
                weekDay = { training.weekDay },
                date = { training.endOfWeek },
            )

            ChartsInfo(
                training = trainingProvider
            )

//            SummaryInfo(
//                training = trainingProvider
//            )

            TrainingComponent(
                modifier = Modifier
                    .recomposeHighlighter(),
                training = training,
            )

            ButtonSecondaryIcon(
                imageVector = Icons.Default.KeyboardArrowRight,
                onClick = {
                    val id = trainingProvider.id ?: return@ButtonSecondaryIcon
                    editTraining(id)
                }
            )
        }

        BrandGradientCenterEnd()

        BrandGradientCenterStart()
    }
}