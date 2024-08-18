package equipment.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import equipment.EquipmentGroup
import molecule.PaddingS
import molecule.TextH3

@Composable
public fun EquipmentGroup(
    modifier: Modifier = Modifier,
    item: EquipmentGroup,
    selectEquipment: (id: String) -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextH3(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingL),
            provideText = { item.name },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        PaddingS()

        item.equipments.forEach { equipment ->

            EquipmentChip(
                modifier = Modifier.padding(
                    start = Design.dp.paddingL,
                    end = Design.dp.paddingL,
                    bottom = Design.dp.paddingS
                ),
                item = equipment,
                selectEquipment = selectEquipment
            )
        }
    }
}