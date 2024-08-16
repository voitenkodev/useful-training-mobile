package authentication.register.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.BottomButtons
import components.ShadowFooterSpace
import equipment.EquipmentGroup
import equipment.component.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.Shadow
import molecule.TextBody2
import molecule.TextH1

@Composable
internal fun ExcludeEquipmentPage(
    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingL()

            TextH1(provideText = { "Equipment" }, textAlign = TextAlign.Center)

            PaddingXS()

            TextBody2(
                provideText = { "If you don't have any of equipment you\nmay to exclude it?" },
                textAlign = TextAlign.Center,
                color = Design.colors.label
            )

            PaddingXL()

            Shadow()

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                item {
                    PaddingM()
                }

                itemsIndexed(equipments, key = { _, item -> item.id }) { _, item ->

                    EquipmentGroup(
                        item = item,
                        selectEquipment = selectEquipment,
                    )
                }

                item("navigation_padding") {
                    ShadowFooterSpace()
                }
            }
        }

        BottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
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
