package trainingbuilder.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody1
import molecule.TextH3
import platformBottomInset
import trainingbuilder.state.MuscleType

@Composable
internal fun MusclePickerPopup(
    muscleTypes: ImmutableList<MuscleType>,
    apply: (ImmutableList<MuscleType>) -> Unit
) {
    val innerList = remember(muscleTypes) {
        mutableStateOf(muscleTypes)
    }

    val selectProvider = remember {
        { muscleId: String ->
            innerList.value = innerList.value.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    if (muscle.id == muscleId) muscle.copy(isSelected = muscle.isSelected.not())
                    else muscle
                }
                muscleType.copy(muscles = muscles)
            }.toImmutableList()
        }
    }

    TextH3(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        provideText = { "Select Muscles" }
    )

    PaddingM()

    Box(modifier = Modifier.background(Design.colors.primary)) {
        LazyColumn(
            contentPadding = PaddingValues(Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            items(innerList.value, key = { it.id }) {

                TextBody1(
                    provideText = { it.name }
                )

                PaddingS()

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    it.muscles.forEach { muscle ->
                        Chip(
                            chipState = if (muscle.isSelected) ChipState.Selected() else ChipState.Default(),
                            onClick = { selectProvider.invoke(muscle.id) },
                            text = muscle.name
                        )
                    }
                }
            }
            item {
                Spacer(
                    modifier = Modifier
                        .platformBottomInset()
                        .size(Design.dp.componentM + Design.dp.paddingM)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Design.colors.secondary)
                .align(Alignment.BottomCenter)
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Cancel",
                enableBackgroundColor = Design.colors.secondary,
                onClick = { }
            )
            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Apply",
                onClick = { apply.invoke(innerList.value) }
            )
        }
    }
}