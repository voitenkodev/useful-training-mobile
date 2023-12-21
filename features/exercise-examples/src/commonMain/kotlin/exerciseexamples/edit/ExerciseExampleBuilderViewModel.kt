package exerciseexamples.edit

import ExerciseExamplesRepository
import MusclesRepository
import ViewModel
import exerciseexamples.edit.factories.muscleImage
import exerciseexamples.edit.mapping.toDomain
import exerciseexamples.edit.mapping.toState
import exerciseexamples.edit.state.ExerciseExample
import exerciseexamples.edit.state.MuscleType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import models.MuscleExerciseBundle
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel(exerciseExampleId: String?) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()
    private val musclesApi by inject<MusclesRepository>()

    init {
        val flow = exerciseExampleId
            ?.let(api::observeExerciseExample)
            ?: flowOf<models.ExerciseExample?>(null)

        musclesApi
            .observeMuscleTypes()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState()) } }
            .flatMapConcat { flow }
            .onEach { ex ->
                _state.update {
                    it.copy(
                        loading = false,
                        exerciseExample = ex?.toState() ?: ExerciseExample(),
                        muscleTypes = it.muscleTypes.prefillMusclesWith(ex?.muscleExerciseBundles ?: emptyList())
                    )
                }
            }.catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncMuscleTypes()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun setExerciseExample(success: () -> Unit) {
        val exerciseExample = state.value.exerciseExample ?: return
        val muscleTypes = state.value.muscleTypes

        api.setExerciseExample(exerciseExample = exerciseExample.toDomain(muscleTypes))
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { success.invoke() }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .launchIn(this)
    }

    fun onMuscleBundleChange(values: ImmutableList<MuscleType>) {
        _state.update {
            it.exerciseExample ?: return@update it
            it.copy(muscleTypes = values)
        }
    }

    fun setExerciseExampleName(value: String) {
        _state.update {
            it.exerciseExample ?: return@update it
            it.copy(exerciseExample = it.exerciseExample.copy(name = value))
        }
    }

    private fun ImmutableList<MuscleType>.prefillMusclesWith(list: List<MuscleExerciseBundle>): ImmutableList<MuscleType> {
        return map { muscleType ->
            val muscles = muscleType.muscles.map { muscle ->
                val findItem = list.find { it.muscle?.id == muscle.id }
                muscle.copy(
                    isSelected = findItem != null,
                    percentage = findItem?.percentage ?: 0
                )
            }.toPersistentList()

            val image = muscleImage(
                muscleTypeEnumState = muscleType.type,
                muscles = muscles
            )
            muscleType.copy(
                muscles = muscles,
                imageVector = image
            )
        }.toPersistentList()
    }

    fun selectMuscle(id: String) {
        _state.update {
            it.exerciseExample ?: return@update it

            val selectedMuscle = it
                .muscleTypes
                .flatMap { m -> m.muscles }
                .find { f -> f.id == id } ?: return@update it

            val biggestMuscle = it.muscleTypes
                .flatMap { m -> m.muscles }
                .filterNot { f -> f.id == selectedMuscle.id }
                .maxBy { max -> max.percentage }
                .takeIf { t -> t.percentage > it.minimalRange }

            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->

                    val newValue = selectedMuscle.isSelected.not()

                    val newPercentage =
                        if (selectedMuscle.isSelected) 0 // become unselected
                        else if (selectedMuscle.isSelected.not() && biggestMuscle == null) it.sliderRange.endInclusive
                        else it.minimalRange

                    return@map when (muscle.id) {
                        selectedMuscle.id -> selectedMuscle.copy(
                            isSelected = newValue,
                            percentage = newPercentage
                        )

                        biggestMuscle?.id -> biggestMuscle.copy(
                            percentage = if (newValue) biggestMuscle.percentage - newPercentage
                            else biggestMuscle.percentage + selectedMuscle.percentage
                        )

                        else -> muscle
                    }
                }.toPersistentList()

                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )

            }.toPersistentList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}