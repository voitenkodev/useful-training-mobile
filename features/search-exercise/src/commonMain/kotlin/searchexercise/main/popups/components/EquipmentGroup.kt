package searchexercise.main.popups.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import equipment.Equipment
import equipment.component.EquipmentChip
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun EquipmentGroups(
    items: ImmutableList<Equipment>,
    selectEquipment: (id: String) -> Unit
) {

    val multiplier = 3

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyHorizontalGrid(
            modifier = Modifier.fillMaxWidth().height(200.dp * multiplier),
            rows = GridCells.Fixed(multiplier),
            contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            items(items, key = { it.id }) { equipment ->

                EquipmentChip(
                    item = equipment,
                    selectEquipment = selectEquipment
                )
            }
        }
    }
}