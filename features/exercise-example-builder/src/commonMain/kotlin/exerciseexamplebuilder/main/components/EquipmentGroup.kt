package exerciseexamplebuilder.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import equipment.EquipmentGroup
import equipment.component.EquipmentChip
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS

@Composable
internal fun EquipmentGroups(
    items: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit
) {

    val multiplier = 3

    PaddingS()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        LazyHorizontalGrid(
            modifier = Modifier.fillMaxWidth().height(200.dp * multiplier),
            rows = GridCells.Fixed(multiplier),
            contentPadding = PaddingValues(
                horizontal = Design.dp.paddingL,
                vertical = Design.dp.paddingM
            ),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            items(items.flatMap { it.equipments }, key = { it.id }) { equipment ->

                EquipmentChip(
                    modifier = Modifier.width(140.dp),
                    item = equipment,
                    selectEquipment = selectEquipment
                )
            }
        }
    }
}