package authentication.register.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import components.BottomButtons
import equipment.EquipmentGroup
import equipment.component.EquipmentChip
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH1
import molecule.TextH3

@Composable
internal fun ExcludeEquipmentPage(
    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = Design.dp.paddingL),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            content = {

                item(span = { GridItemSpan(3) }) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PaddingL()

                        TextH1(
                            provideText = { "Exclude equipments" },
                        )

                        PaddingXS()

                        TextBody1(
                            provideText = { "You may to exclude equipment you cannot find in gym" },
                            color = Design.colors.label
                        )

                        PaddingM()
                    }
                }

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

                item {
                    PaddingS()
                }
            }
        )

        PaddingL()

        BottomButtons(
            modifier = Modifier.fillMaxWidth(),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    text = "Back",
                    onClick = back
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = "Next",
                    onClick = confirm,
                )
            }
        )
    }
}
