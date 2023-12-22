package statistics.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingS
import molecule.TextBody1
import molecule.TextH3
import molecule.TextLabel
import statistics.state.ExerciseExample
import statistics.state.Interval
import statistics.state.IntervalType
import statistics.state.Muscle

@Composable
internal fun ColumnScope.FilterPopup(
    muscles: ImmutableList<Muscle>,
    exerciseExamples: ImmutableList<ExerciseExample>,
    intervals: ImmutableList<Interval>,

    muscleClick: (id: String) -> Unit,
    exerciseExampleClick: (id: String) -> Unit,
    intervalClick: (intervalType: IntervalType) -> Unit
) {

    TextH3(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        provideText = { "Filters" }
    )

    if (muscles.isNotEmpty()) {

        PaddingL()

        TextBody1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Muscles" }
        )

        PaddingS()

        LazyRow(
            contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            content = {
                items(muscles, key = { it.id }) {
                    Chip(
                        chipState = if (it.isSelected) ChipState.Colored(
                            backgroundColor = Design.colors.orange,
                            borderColor = Design.colors.orange,
                            contentColor = Design.colors.content
                        ) else ChipState.Default(),
                        onClick = { muscleClick.invoke(it.id) },
                        text = it.name
                    )
                }
            }
        )
    }


    if (exerciseExamples.isNotEmpty()) {

        PaddingL()

        TextLabel(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Exercises" }
        )

        PaddingS()

        LazyRow(
            contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            content = {
                items(exerciseExamples, key = { it.id }) {
                    Chip(
                        chipState = if (it.isSelected) ChipState.Colored(
                            backgroundColor = Design.colors.orange,
                            borderColor = Design.colors.orange,
                            contentColor = Design.colors.content
                        ) else ChipState.Default(),
                        onClick = { exerciseExampleClick.invoke(it.id) },
                        text = it.name
                    )
                }
            }
        )
    }

    if (intervals.isNotEmpty()) {

        PaddingL()

        TextLabel(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Interval" }
        )

        PaddingS()

        LazyRow(
            contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            content = {
                items(intervals) {
                    Chip(
                        chipState = if (it.isSelected) ChipState.Colored(
                            backgroundColor = Design.colors.orange,
                            borderColor = Design.colors.orange,
                            contentColor = Design.colors.content
                        ) else ChipState.Default(),
                        onClick = { intervalClick.invoke(it.type) },
                        text = it.type.title
                    )
                }
            }
        )
    }
}