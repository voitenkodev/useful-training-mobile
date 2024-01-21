package userequipments.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.primaryBackground
import userequipments.main.components.EquipmentGroup
import userequipments.main.components.Header
import userequipments.main.models.EquipmentGroup

@Composable
internal fun UserEquipmentsContent(vm: UserEquipmentsViewModel, close: () -> Unit) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        list = state.equipmentGroups,
        clearError = vm::clearError,
        selectEquipment = vm::selectEquipment,
        close = close
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    list: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(close = close)

            if (list.isNotEmpty()) LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).primaryBackground()) {

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    EquipmentGroup(
                        item = item,
                        selectEquipment = selectEquipment
                    )
                }

                item("navigation_padding") {
                    Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingM))
                }
            }
        }
    }
}