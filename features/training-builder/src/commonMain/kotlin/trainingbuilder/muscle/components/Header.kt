package trainingbuilder.muscle.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingXS
import molecule.Toolbar
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleLoadEnum
import resources.Icons

@Composable
internal fun Header(
    close: () -> Unit,
    list: ImmutableList<MuscleGroup>,
    includedMuscleStatuses: ImmutableList<MuscleLoadEnum>,
    upperBodyPackEnums: ImmutableList<MuscleEnum>,
    lowerBodyPackEnums: ImmutableList<MuscleEnum>,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit
) {
    Column(modifier = Modifier.statusBarsPadding()) {

        Toolbar(title = "Target", icon = Icons.close to close)

        PaddingXS()

        MusclePack(
            list = list,
            includedMuscleStatuses = includedMuscleStatuses,
            lowerBodyPackEnums = lowerBodyPackEnums,
            upperBodyPackEnums = upperBodyPackEnums,
            selectFullBody = selectFullBody,
            selectUpperBody = selectUpperBody,
            selectLowerBody = selectLowerBody
        )

        PaddingL()
    }
}