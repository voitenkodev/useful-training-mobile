package userequipments.main

import EquipmentsRepository
import UserRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import userequipments.main.mapping.toState
import userequipments.main.models.StatusEnum

internal class UserEquipmentsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val equipmentsApi by inject<EquipmentsRepository>()
    private val userApi by inject<UserRepository>()

    init {
        equipmentsApi
            .observeEquipments()
            .onEach { r -> _state.update { it.copy(equipmentGroups = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        equipmentsApi.syncUserEquipments()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun selectEquipment(id: String) {
        _state.update {
            it.copy(
                equipmentGroups = it.equipmentGroups.map { mt ->
                    mt.copy(
                        equipments = mt.equipments.map { m ->
                            m.copy(loading = id == m.id)
                        }.toPersistentList()
                    )
                }.toPersistentList()
            )
        }

        val equipment = state.value.equipmentGroups
            .flatMap { it.equipments }
            .find { it.id == id } ?: return

        val flow = if (equipment.status == StatusEnum.EXCLUDED) userApi.deleteExcludedEquipment(equipment.id)
        else userApi.setExcludedEquipment(equipment.id)

        flow
            .flatMapConcat { equipmentsApi.syncUserEquipments() }
            .onStart { _state.update { it.copy(loading = true) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}