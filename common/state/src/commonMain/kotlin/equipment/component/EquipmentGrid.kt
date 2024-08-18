package equipment.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import molecule.TextH3

@Composable
public fun EquipmentGrid(
    modifier: Modifier = Modifier,
    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    leadingContent: (LazyGridScope.() -> Unit)? = null
) {
    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = Design.dp.paddingL,
            vertical = Design.dp.paddingM
        ),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        content = {

            leadingContent?.invoke(this)

            equipments.forEach { group ->

                item(
                    key = group.id,
                    span = { GridItemSpan(3) }
                ) {

                    TextH3(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = Design.dp.paddingS),
                        provideText = { group.name },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                items(group.equipments) { item ->
                    EquipmentChip(
                        item = item,
                        selectEquipment = selectEquipment,
                    )
                }
            }
        }
    )
}