package authentication.register.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import equipment.EquipmentGroup
import equipment.component.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
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

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            item(key = "header") {

                PaddingL()

                TextH1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "Exclude equipments" },
                )

                PaddingXS()

                TextBody1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "You may to exclude equipment you cannot find in gym" },
                    color = Design.colors.label
                )

                PaddingM()
            }

            itemsIndexed(equipments, key = { _, item -> item.id }) { _, item ->

                EquipmentGroup(
                    modifier = Modifier.padding(bottom = Design.dp.paddingM),
                    item = item,
                    selectEquipment = selectEquipment,
                )
            }
        }

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
