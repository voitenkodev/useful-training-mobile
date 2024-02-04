package searchexercise.main

import EquipmentsRepository
import ExerciseExamplesRepository
import FiltersRepository
import MusclesRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import searchexercise.main.factories.muscleImage
import searchexercise.main.mapping.toState
import searchexercise.main.models.StatusEnum
import kotlinx.collections.immutable.toPersistentList as toPersistentList1

internal class SearchExerciseViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()
    private val musclesApi by inject<MusclesRepository>()
    private val equipmentsApi by inject<EquipmentsRepository>()
    private val filtersApi by inject<FiltersRepository>()

    init {
        exerciseExampleApi
            .observeExerciseExamples()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(loading = false, exerciseExamples = r.toState()) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .launchIn(this)

        musclesApi
            .syncUserMuscles()
            .flatMapConcat { exerciseExampleApi.syncExerciseExamples() }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        equipmentsApi
            .observeEquipments()
            .onEach { r -> _state.update { it.copy(equipments = r.flatMap { it.equipments }.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi
            .observeMuscles()
            .onEach { r -> _state.update { it.copy(muscles = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        filtersApi
            .getExerciseExampleFilters()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(filterPack = r.toState(), loading = false) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)
    }

    fun setQuery(value: String) {
        _state.update { it.copy(query = value) }
    }

    fun openFiltersPopup() {
        _state.update { it.copy(filtersPopupIsVisible = true) }
    }

    fun closeFiltersPopup() {
        _state.update { it.copy(filtersPopupIsVisible = false) }
    }

    fun selectCategory(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                categories = it.filterPack.categories.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList1()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectWeightType(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                weightTypes = it.filterPack.weightTypes.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList1()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectExperience(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                experiences = it.filterPack.experiences.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList1()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectEquipment(id: String) {
        _state.update {
            it.copy(
                equipments = it.equipments.map equipMap@{ v ->
                    if (id != v.id) {
                        return@equipMap v
                    }
                    v.copy(
                        status = when (v.status) {
                            StatusEnum.SELECTED -> StatusEnum.UNSELECTED
                            StatusEnum.UNSELECTED -> StatusEnum.SELECTED
                        }
                    )
                }.toPersistentList()
            )
        }
    }

    fun selectForceType(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                forceTypes = it.filterPack.forceTypes.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList1()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectMuscle(id: String) {
        _state.update {
            it.copy(
                muscles = it.muscles.map { mt ->
                    val muscles = mt.muscles.map muscleMap@{ m ->
                        if (id != m.id) {
                            return@muscleMap m
                        }

                        m.copy(
                            status = when (m.status) {
                                StatusEnum.SELECTED -> StatusEnum.UNSELECTED
                                StatusEnum.UNSELECTED -> StatusEnum.SELECTED
                            }
                        )
                    }.toPersistentList()

                    mt.copy(
                        muscles = muscles,
                        bodyImageVector = muscleImage(mt.type, muscles)
                    )
                }.toPersistentList()
            )
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}