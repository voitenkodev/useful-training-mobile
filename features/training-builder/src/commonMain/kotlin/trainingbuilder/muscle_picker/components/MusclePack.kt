package trainingbuilder.muscle_picker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleLoadEnum

@Composable
internal fun MusclePack(
    list: ImmutableList<MuscleGroup>,
    includedMuscleStatuses: ImmutableList<MuscleLoadEnum>,
    upperBodyPackEnums: ImmutableList<MuscleEnum>,
    lowerBodyPackEnums: ImmutableList<MuscleEnum>,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.green,
        borderColor = Color.Transparent,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.tertiary,
        borderColor = Color.Transparent,
        contentColor = Design.colors.content
    )

    val fullBodyVisible = remember(list) {
        list.any { it.muscles.any { m -> includedMuscleStatuses.contains(m.load) } }
    }

    val fullBodyState = when {
        list.all {
            it.muscles
                .filter { m -> includedMuscleStatuses.contains(m.load) }
                .all { m -> m.isSelected }
        } -> selectedChipState

        else -> unSelectedChipState
    }

    val lowerBodyVisible = remember(list) {
        list.any {
            it.muscles
                .filter { m -> lowerBodyPackEnums.contains(m.type) }
                .any { m -> includedMuscleStatuses.contains(m.load) }
        }
    }

    val lowerBodyState = when {
        list
            .flatMap { it.muscles }
            .filter { m -> m.isSelected }
            .map { m -> m.type }
            .sorted() == lowerBodyPackEnums.sorted() -> selectedChipState

        else -> unSelectedChipState
    }

    val upperBodyVisible = remember(list) {
        list.any {
            it.muscles
                .filter { m -> upperBodyPackEnums.contains(m.type) }
                .any { m -> includedMuscleStatuses.contains(m.load) }
        }
    }

    val upperBodyState = when {
        list.flatMap { it.muscles }
            .filter { m -> m.isSelected }
            .map { m -> m.type }
            .sorted() == upperBodyPackEnums.sorted() -> selectedChipState

        else -> unSelectedChipState
    }

    if (fullBodyVisible) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                Chip(
                    chipState = fullBodyState,
                    onClick = selectFullBody,
                    text = "Full Body"
                )

                if (upperBodyVisible) {
                    Chip(
                        chipState = upperBodyState,
                        onClick = selectUpperBody,
                        text = "Upper Body"
                    )
                }

                if (lowerBodyVisible) {
                    Chip(
                        chipState = lowerBodyState,
                        onClick = selectLowerBody,
                        text = "Lower Body"
                    )
                }
            }
        }
    }
}