package trainingbuilder.muscle_picker.components

import androidx.compose.foundation.background
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
import molecule.PaddingL
import molecule.PaddingXL
import molecule.Shadow
import trainingbuilder.muscle_picker.models.MuscleEnum
import trainingbuilder.muscle_picker.models.MuscleGroup
import trainingbuilder.muscle_picker.models.StatusEnum

@Composable
internal fun MusclePack(
    list: ImmutableList<MuscleGroup>,
    includedMuscleStatuses: ImmutableList<StatusEnum>,
    upperBodyPackEnums: ImmutableList<MuscleEnum>,
    lowerBodyPackEnums: ImmutableList<MuscleEnum>,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
        borderColor = Design.colors.toxic,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

    val fullBodyVisible = remember(list) {
        list.any { it.muscles.any { m -> includedMuscleStatuses.contains(m.status) } }
    }

    val fullBodyState = when {
        list.all {
            it.muscles
                .filter { m -> includedMuscleStatuses.contains(m.status) }
                .all { m -> m.isSelected }
        } -> selectedChipState

        else -> unSelectedChipState
    }

    val lowerBodyVisible = remember(list) {
        list.any {
            it.muscles
                .filter { m -> lowerBodyPackEnums.contains(m.type) }
                .any { m -> includedMuscleStatuses.contains(m.status) }
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
                .any { m -> includedMuscleStatuses.contains(m.status) }
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
        Column(modifier = Modifier.background(Design.colors.black10)) {
            PaddingXL()

            Row(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
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

            PaddingL()

            Shadow()
        }
    }
}