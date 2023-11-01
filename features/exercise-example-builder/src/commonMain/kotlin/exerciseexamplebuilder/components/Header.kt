package exerciseexamplebuilder.components

import Design
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
import atomic.icons.Delete
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputExerciseExampleName
import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.MuscleExerciseBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecular.ButtonIconSecondary
import molecular.PaddingM
import molecular.RangeSlider
import molecular.Shadow
import molecular.TextH2
import molecular.ThumbRangeStateState
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    exerciseExample: ExerciseExample?,
    minimalRange: Int,
    sliderRange: ClosedRange<Int>,
    setExerciseExampleName: (String) -> Unit,
    onMuscleBundleChange: (ImmutableList<MuscleExerciseBundle>) -> Unit,
    deleteExercise: () -> Unit,
) {

    val thumbs = remember(exerciseExample?.muscleExerciseBundles) {
        exerciseExample?.muscleExerciseBundles?.map {
            ThumbRangeStateState(
                id = it.muscle.id,
                positionInRange = it.percentage,
                color = it.color
            )
        } ?: persistentListOf()
    }

    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .animateContentSize()
            .platformTopInset(),
    ) {

        PaddingM()

        Box(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            TextH2(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                provideText = { "Exercise Example" },
                softWrap = false
            )
        }

        PaddingM()

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
                Chip(
                    chipState = ChipState.Highlighted(enabled = false),
                    text = exerciseExample.name
                )

                ButtonIconSecondary(
                    modifier = Modifier.size(24.dp),
                    imageVector = Delete,
                    color = Design.colors.accentPrimary,
                    onClick = deleteExercise
                )
            }
        }

        PaddingM()

        if (exerciseExample != null && thumbs.isNotEmpty()) {
            RangeSlider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingM)
                    .height(46.dp),
                range = sliderRange,
                minimalRange = minimalRange,
                thumbs = thumbs,
                lineColor = Design.colors.caption,
                onValueChange = { updatedThumbs ->
                    val newList = exerciseExample.muscleExerciseBundles.map {
                        val newValue = updatedThumbs
                            .find { th -> it.muscle.id == th.id }
                            ?.positionInRange ?: it.percentage
                        it.copy(percentage = newValue)
                    }.toPersistentList()

                    onMuscleBundleChange(newList)
                }
            )
        }

        PaddingM()

        Shadow()
    }
}