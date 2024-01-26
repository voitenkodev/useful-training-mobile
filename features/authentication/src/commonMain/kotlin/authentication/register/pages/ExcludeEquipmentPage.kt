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
import authentication.register.components.EquipmentGroup
import authentication.register.models.EquipmentGroup
import components.ShadowFooter
import components.ShadowFooterSpace
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody2
import molecule.TextH2

@Composable
internal fun ExcludeEquipmentPage(
    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    confirm: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingM()

            TextH2(provideText = { "Equipment" }, textAlign = TextAlign.Center)

            TextBody2(provideText = { "Would you like to exclude some equipments?" }, textAlign = TextAlign.Center)

            PaddingXL()

            Shadow()

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                itemsIndexed(equipments, key = { _, item -> item.id }) { index, item ->

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

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            primary = Triple("Continue", true, confirm)
        )
    }
}
