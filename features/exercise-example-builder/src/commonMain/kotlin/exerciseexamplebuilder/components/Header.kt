package exerciseexamplebuilder.components

import Icons
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.inputs.InputExerciseExampleName
import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.MuscleType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import molecule.ButtonIconSecondary
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH2
import molecule.TextH4
import percentagepicker.RangeSlider
import percentagepicker.ThumbRangeState
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    exerciseExample: ExerciseExample?,
    muscleTypes: ImmutableList<MuscleType>,
    minimalRange: Int,
    sliderRange: ClosedRange<Int>,
    setExerciseExampleName: (String) -> Unit,
    onPercentageChange: (ImmutableList<MuscleType>) -> Unit,
    deleteExercise: () -> Unit
) {

    val thumbs = remember(muscleTypes) {
        muscleTypes
            .flatMap { it.muscles }
            .filter { it.isSelected }
            .map {
                ThumbRangeState(
                    id = it.id,
                    positionInRange = it.percentage,
                    color = it.color
                )
            }.toPersistentList()
    }

    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .animateContentSize()
            .platformTopInset()
    ) {

        PaddingS()

        Box(
            modifier = Modifier
                .height(Design.dp.componentL)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Build Exercises" },
                softWrap = false
            )
        }

        if (exerciseExample != null && exerciseExample.id == null) {

            InputExerciseExampleName(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM),
                value = { exerciseExample.name },
                onValueChange = setExerciseExampleName
            )
        } else if (exerciseExample != null) {
            Row(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextH4(
                    provideText = { exerciseExample.name },
                    color = Design.colors.toxic
                )

                ButtonIconSecondary(
                    modifier = Modifier.size(24.dp).padding(bottom = 4.dp),
                    imageVector = Icons.delete,
                    color = Design.colors.orange,
                    onClick = deleteExercise
                )
            }
        }

        PaddingS()

        if (exerciseExample != null && thumbs.isNotEmpty()) {
            RangeSlider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingM)
                    .height(46.dp),
                range = sliderRange,
                minimalRange = minimalRange,
                thumbs = thumbs,
                requiredFilledRange = false,
                lineColor = Design.colors.caption,
                onValueChange = { updatedThumbs ->
                    val newList = muscleTypes.map {
                        val muscles = it.muscles.map { m ->
                            val newPercentage = updatedThumbs.find { it.id == m.id }?.positionInRange ?: m.percentage
                            m.copy(percentage = newPercentage)
                        }.toPersistentList()
                        it.copy(muscles = muscles)
                    }.toPersistentList()
                    onPercentageChange(newList)
                }
            )
        }

        PaddingS()

        Shadow()
    }
}