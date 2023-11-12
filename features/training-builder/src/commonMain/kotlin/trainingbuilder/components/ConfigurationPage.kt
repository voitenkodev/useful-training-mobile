package trainingbuilder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingM
import molecule.TextBody2
import molecule.TextH2
import platformBottomInset
import trainingbuilder.state.MuscleType

@Composable
internal fun ConfigurationPage(
    selectedMuscles: ImmutableList<MuscleType>,
    unselectMuscle: (muscleId: String) -> Unit,
    addMuscle: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaddingL()

        TextH2(provideText = { "Workout Goal" })

        TextBody2(provideText = { "Which muscle do you want to train?" })

        PaddingM()

        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            Chip(
                chipState = ChipState.Colored(Design.colors.orange),
                text = "Add Muscle",
                onClick = addMuscle
            )

            val muscles = remember(selectedMuscles) {
                buildList { selectedMuscles.map { addAll(it.muscles.filter { it.isSelected }) } }
            }

            muscles.forEach { muscle ->
                Chip(
                    chipState = ChipState.Selected(),
                    onClick = { unselectMuscle.invoke(muscle.id) },
                    text = muscle.name
                )
            }
        }
    }
}