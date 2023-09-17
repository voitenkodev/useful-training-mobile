package trainings

import Design
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import components.ChartsInfo
import components.Exercises
import components.SummaryInfo
import components.TrainingTitle
import components.backgrounds.BottomShadowBackground
import platformTopInset
import recomposeHighlighter
import training.Training

@Composable
internal fun TrainingPage(
    training: Training,
    openTraining: () -> Unit,
    pageColor: Color
) {

    val trainingProvider by rememberUpdatedState(training)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    openTraining.invoke()
                }
            ),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformTopInset()
                .padding(horizontal = Design.dp.paddingM),
        ) {

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            TrainingTitle(
                titleColor = pageColor,
                weekDay = { training.weekDay },
                date = { training.startLongDate },
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            ChartsInfo(
                training = trainingProvider
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .recomposeHighlighter()
                        .padding(bottom = Design.dp.paddingM),
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

                BottomShadowBackground()
            }
        }
    }
}