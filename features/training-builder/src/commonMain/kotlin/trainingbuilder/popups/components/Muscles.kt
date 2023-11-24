package trainingbuilder.popups.components

import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import components.states.animateScrollAndCentralizeItem
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.TextH5
import trainingbuilder.state.Muscle

@Composable
internal fun Muscles(
    selectedMuscle: Muscle?,
    list: ImmutableList<Muscle>,
    setMuscleTarget: (id: String) -> Unit
) {

    val lazyListState = rememberLazyListState()

    val selectedIndex = remember(list) { list.indexOfFirst { it.id == selectedMuscle?.id } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextH5(provideText = { "Target Muscle" })
    }

    PaddingM()

    LazyRow(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM)
    ) {
        items(list, key = { it.id }) {
            Chip(
                chipState = if (it.id == selectedMuscle?.id) ChipState.Selected() else ChipState.Default(),
                text = it.name,
                onClick = { setMuscleTarget.invoke(it.id) }
            )
        }
    }
}