package trainingbuilder.builder.popups.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import components.states.animateScrollAndCentralizeItem
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.TextLabel
import trainingbuilder.builder.state.Muscle

@Composable
internal fun Muscles(
    selectedMuscle: Muscle?,
    list: ImmutableList<Muscle>,
    setMuscleTarget: (id: String) -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.green.copy(alpha = 0.2f),
        borderColor = Design.colors.green,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

    val lazyListState = rememberLazyListState()

    val selectedIndex = remember(list) { list.indexOfFirst { it.id == selectedMuscle?.id } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    TextLabel(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        provideText = { "Target Muscle" }
    )

    PaddingM()

    LazyRow(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM)
    ) {
        items(list, key = { it.id }) {
            Chip(
                chipState = if (it.id == selectedMuscle?.id) selectedChipState else unSelectedChipState,
                text = it.name,
                onClick = { setMuscleTarget.invoke(it.id) }
            )
        }
    }
}