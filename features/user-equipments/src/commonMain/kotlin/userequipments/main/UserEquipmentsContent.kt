package userequipments.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.roots.ScreenRoot
import equipment.EquipmentGroup
import equipment.component.EquipmentGrid
import kotlinx.collections.immutable.ImmutableList
import userequipments.main.components.Header

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

        Column(
            modifier = Modifier.fillMaxSize().navigationBarsPadding()
        ) {

            Header(close = close)

            EquipmentGrid(
                modifier = Modifier.fillMaxWidth().weight(1f),
                equipments = list,
                selectEquipment = selectEquipment
            )
        }
    }
}