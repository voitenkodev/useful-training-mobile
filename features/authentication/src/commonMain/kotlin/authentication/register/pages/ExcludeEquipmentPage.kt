package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import equipment.EquipmentGroup
import equipment.component.EquipmentGrid
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH1

@Composable
internal fun ExcludeEquipmentPage(
    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        EquipmentGrid(
            modifier = Modifier.fillMaxWidth().weight(1f),
            equipments = equipments,
            selectEquipment = selectEquipment,
            leadingContent = {
                item(span = { GridItemSpan(3) }) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PaddingS()

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
