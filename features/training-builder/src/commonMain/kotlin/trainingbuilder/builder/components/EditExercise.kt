package trainingbuilder.builder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.inputs.InputExerciseName
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody1
import molecule.TextBody2
import molecule.TextH4
import molecule.secondaryDefaultBackground
import trainingbuilder.builder.state.Iteration

@Composable
internal fun EditExercise(
    modifier: Modifier = Modifier,
    iterations: ImmutableList<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    addIteration: () -> Unit,
    updateIteration: (index: Int, iteration: Iteration) -> Unit
) {

    Column(modifier = modifier) {

        PaddingM()

        InputExerciseName(
            provideName = name,
            update = updateName
        )

        PaddingM()

        TextH4(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Iterations" }
        )

        PaddingS()

        Column(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextBody1(
                    modifier = Modifier
                        .background(
                            color = Design.colors.white5,
                            shape = Design.shape.default
                        ).clip(shape = Design.shape.default)
                        .alpha(alpha = 0.5f)
                        .padding(Design.dp.paddingM)
                        .weight(0.2f),
                    provideText = { "Num" },
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )

                TextBody1(
                    modifier = Modifier
                        .background(
                            color = Design.colors.white5,
                            shape = Design.shape.default
                        ).clip(shape = Design.shape.default)
                        .alpha(alpha = 0.5f)
                        .padding(Design.dp.paddingM)
                        .weight(0.5f),
                    textAlign = TextAlign.Center,
                    provideText = { "Weight" },
                    maxLines = 1
                )

                TextBody1(
                    modifier = Modifier
                        .background(
                            color = Design.colors.white5,
                            shape = Design.shape.default
                        ).clip(shape = Design.shape.default)
                        .alpha(alpha = 0.5f)
                        .padding(Design.dp.paddingM)
                        .weight(0.30f),
                    textAlign = TextAlign.Center,
                    provideText = { "Reps" },
                    maxLines = 1
                )
            }

            iterations.forEachIndexed { index, item ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextBody2(
                        modifier = Modifier.weight(0.2f),
                        provideText = { "${index + 1}" },
                        maxLines = 1
                    )

                    TextBody1(
                        modifier = Modifier
                            .secondaryDefaultBackground()
                            .padding(Design.dp.paddingM)
                            .weight(0.5f),
                        textAlign = TextAlign.Center,
                        provideText = { item.weight },
                        maxLines = 1
                    )

                    TextBody1(
                        modifier = Modifier
                            .secondaryDefaultBackground()
                            .padding(Design.dp.paddingM)
                            .weight(0.3f),
                        textAlign = TextAlign.Center,
                        provideText = { item.repetitions },
                        maxLines = 1
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextBody2(
                    modifier = Modifier.weight(0.2f),
                    provideText = { "${iterations.size + 1}" },
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )

                TextBody1(
                    modifier = Modifier
                        .background(
                            color = Design.colors.orange,
                            shape = Design.shape.default
                        ).clip(shape = Design.shape.default)
                        .padding(Design.dp.paddingM)
                        .weight(0.8f),
                    textAlign = TextAlign.Center,
                    provideText = { "Add new" },
                    maxLines = 1
                )
            }
        }

        PaddingM()
    }
}

/*
@Composable
internal fun EditExercise(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {
    Column(modifier = modifier) {

        PaddingM()

        InputExerciseName(
            provideNumber = number,
            provideName = name,
            update = updateName,
        )

        WeightRepeatSection(
            iterations = iterations,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat
        )
    }
}*/
