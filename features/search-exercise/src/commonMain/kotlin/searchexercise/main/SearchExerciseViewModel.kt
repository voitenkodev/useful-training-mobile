package searchexercise.main

import EquipmentsRepository
import ExerciseExamplesRepository
import FiltersRepository
import MusclesRepository
import ViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import searchexercise.main.mapping.toState
import searchexercise.main.models.StatusEnum
import searchexercise.main.popups.ExerciseExampleFiltersState

@OptIn(FlowPreview::class)
internal class SearchExerciseViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

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
            .flatMapConcat { exerciseExampleApi.getExerciseExamples(page = 1, size = 10) }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        equipmentsApi
            .observeEquipments()
            .onEach { r ->
                _state.update {
                    val filters = it.filtersState.copy(equipments = r.flatMap { it.equipments }.toState())
                    it.copy(filtersState = filters)
                }
            }.catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi
            .observeMuscles()
            .onEach { r ->
                _state.update {
                    val filters = it.filtersState.copy(muscles = r.toState())
                    it.copy(filtersState = filters)
                }
            }.catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        filtersApi
            .getExerciseExampleFilters()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r ->
                _state.update {
                    val filters = it.filtersState.copy(filterPack = r.toState())
                    it.copy(filtersState = filters)
                }
            }.catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)


        state
            .map { it.query to it.filtersState }
            .distinctUntilChanged()
            .debounce(500)
            .flatMapLatest {
                val filters = it.second
                val query = it.first
                exerciseExampleApi.getExerciseExamples(
                    page = 1,
                    size = 10,
                    weightType = filters.filterPack.weightTypes.firstOrNull { it.isSelected }?.value,
                    category = filters.filterPack.categories.firstOrNull { it.isSelected }?.value,
                    forceType = filters.filterPack.forceTypes.firstOrNull { it.isSelected }?.value,
                    experience = filters.filterPack.experiences.firstOrNull { it.isSelected }?.value,
                    muscleIds = filters.muscles.flatMap { it.muscles }.filter { it.status == StatusEnum.SELECTED }.map { it.id },
                    equipmentIds = filters.equipments.filter { it.status == StatusEnum.SELECTED }.map { it.id },
                    query = query.takeIf { it.isNotBlank() }
                )
            }.onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(loading = false, exerciseExamples = r.toState()) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
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

    fun applyFilters(filtersState: ExerciseExampleFiltersState) {
        _state.update { it.copy(filtersState = filtersState) }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}