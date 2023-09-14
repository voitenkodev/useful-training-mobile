package trainings.components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.overlay.shadowBottomFrame
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .recomposeHighlighter(),
                ) {

                    Exercises(
                        training = trainingProvider,
                    )

                    Spacer(
                        modifier = Modifier.size(Design.dp.paddingL)
                    )

                    SummaryInfo(
                        training = trainingProvider
                    )
                }

                Spacer(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(300.dp)
                        .shadowBottomFrame(
                            listOf(
                                Color.Transparent,
                                Design.colors.primary.copy(alpha = 0.5f),
                                Design.colors.primary,
                                Design.colors.primary
                            )
                        )
                )
            }
        }

        ButtonSecondaryIcon(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .platformInsets()
                .padding(Design.dp.paddingM),
            imageVector = Icons.Default.KeyboardArrowRight,
            onClick = {
                val id = trainingProvider.id ?: return@ButtonSecondaryIcon
                editTraining(id)
            }
        )

        BrandGradientCenterEnd()

        BrandGradientCenterStart()
    }
}