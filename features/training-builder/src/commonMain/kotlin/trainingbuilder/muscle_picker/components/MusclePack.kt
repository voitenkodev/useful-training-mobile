package trainingbuilder.muscle_picker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingXL
import molecule.Shadow
import trainingbuilder.muscle_picker.models.MuscleType
import trainingbuilder.muscle_picker.models.MuscleTypeEnum
import trainingbuilder.muscle_picker.models.StatusEnum

@Composable
internal fun MusclePack(
    list: ImmutableList<MuscleType>,
    includedMuscleStatuses: ImmutableList<StatusEnum>,
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

    val fullBodyState = when {
        list.all {
            it.muscles
                .filter { m -> includedMuscleStatuses.contains(m.status) }
                .all { m -> m.isSelected }
        } -> selectedChipState

        else -> unSelectedChipState
    }

    val lowerBodyState = when {
        list
            .filter { it.type == MuscleTypeEnum.LEGS }
            .all {
                it.muscles
                    .filter { m -> includedMuscleStatuses.contains(m.status) }
                    .all { m -> m.isSelected }
            } -> selectedChipState

        else -> unSelectedChipState
    }

    val topBodyState = when {
        list
            .filterNot { it.type == MuscleTypeEnum.LEGS }
            .all {
                it.muscles
                    .filter { m -> includedMuscleStatuses.contains(m.status) }
                    .all { m -> m.isSelected }
            } -> selectedChipState

        else -> unSelectedChipState
    }

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

            Chip(
                chipState = topBodyState,
                onClick = selectUpperBody,
                text = "Upper Body"
            )

            Chip(
                chipState = lowerBodyState,
                onClick = selectLowerBody,
                text = "Lower Body"
            )
        }

        PaddingL()

        Shadow()
    }
}