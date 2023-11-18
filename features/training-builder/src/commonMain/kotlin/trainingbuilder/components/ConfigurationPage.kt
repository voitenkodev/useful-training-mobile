package trainingbuilder.components

import androidx.compose.animation.animateContentSize
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
import components.sliders.DurationPicker
import kotlinx.collections.immutable.ImmutableList
import minutes
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2
import platformBottomInset
import trainingbuilder.state.MuscleType

@Composable
internal fun ConfigurationPage(
    // Muscles
    selectedMuscles: ImmutableList<MuscleType>,
    unselectMuscle: (muscleId: String) -> Unit,
    addMuscle: () -> Unit,

    // Duration
    duration: Int,
    changeDuration: (Int) -> Unit,

    ) {
    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaddingM()

        TextH2(provideText = { "Workout Goal" })

        PaddingM()

        TextBody2(provideText = { "Which muscle do you want to train?" })

        PaddingS()

        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM).animateContentSize(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            Chip(
                chipState = ChipState.Colored(
                    backgroundColor = Design.colors.orange,
                    borderColor = Design.colors.orange,
                    contentColor = Design.colors.content
                ),
                text = "Add Muscle",
                onClick = addMuscle
            )

            val muscles = remember(selectedMuscles) {
                buildList { selectedMuscles.map { addAll(it.muscles.filter { it.isSelected }) } }
            }

            if (muscles.isEmpty()) {
                Chip(
                    chipState = ChipState.HalfTransparent(enabled = false),
                    text = "Empty"
                )
            }

            muscles.forEach { muscle ->
                Chip(
                    chipState = ChipState.Selected(),
                    onClick = { unselectMuscle.invoke(muscle.id) },
                    text = muscle.name
                )
            }
        }

        PaddingXL()

        TextBody2(provideText = { "Preferred workout duration?" })

        PaddingS()

        DurationPicker(
            label = duration.minutes(),
            onValueChange = { changeDuration.invoke(it.toInt()) },
            range = 15f..240f,
            steps = 225
        )
    }
}