package trainings

import Design
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.ChartsInfo
import components.Exercises
import components.SummaryInfo
import components.TrainingTitle
import components.overlay.shadowBottomFrame
import platformTopInset
import recomposeHighlighter
import training.Training

@Composable
internal fun TrainingPage(
    training: Training,
    editTraining: () -> Unit,
    pageColor: Color
) {

    val trainingProvider by rememberUpdatedState(training)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = editTraining
            ),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformTopInset()
                .padding(horizontal = Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingL)
        ) {

            Spacer(
                modifier = Modifier.size(Design.dp.paddingM)
            )

            TrainingTitle(
                titleColor = pageColor,
                weekDay = { training.weekDay },
                date = { training.startLongDate },
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

                Spacer(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(220.dp)
                        .shadowBottomFrame(
                            listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Design.colors.primary.copy(alpha = 0.5f),
                                Design.colors.primary.copy(alpha = 0.8f),
                                Design.colors.primary,
                                Design.colors.primary
                            )
                        )
                )
            }
        }

//        ButtonIconBrand(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .platformBottomInset()
//                .padding(Design.dp.paddingM),
//            backgroundColor = pageColor,
//            contentColor = Design.colors.primary,
//            onClick = {},
//            imageVector = Icons.Default.KeyboardArrowRight
//        )

//        ButtonBrand(
//            modifier = Modifier
//                .fillMaxWidth(0.7f)
//                .align(Alignment.BottomStart)
//                .platformInsets()
//                .padding(Design.dp.paddingM)
//                .platformBottomInset(),
//            text = "DETAILS",
//            backgroundColor = pageColor,
//            onClick = {
//                val id = trainingProvider.id ?: return@ButtonBrand
//                editTraining(id)
//            }
//        )
    }
}