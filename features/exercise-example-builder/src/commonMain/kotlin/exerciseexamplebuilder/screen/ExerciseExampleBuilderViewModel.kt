package exerciseexamplebuilder.screen

import ExerciseExamplesRepository
import ViewModel
import exerciseexamplebuilder.factory.muscleImage
import exerciseexamplebuilder.mapping.toDomain
import exerciseexamplebuilder.mapping.toState
import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.Muscle
import exerciseexamplebuilder.state.MuscleExerciseBundle
import exerciseexamplebuilder.state.State
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
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
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel(exerciseExampleId: String?) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        val flow = exerciseExampleId
            ?.let(api::observeExerciseExample)
            ?: flowOf<models.ExerciseExample?>(null)

        api
            .observeMuscleTypes()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState()) } }
            .flatMapConcat { flow }
            .onEach { ex ->
                _state.update { it.copy(loading = false, exerciseExample = ex?.toState() ?: ExerciseExample()) }
                ex?.muscleExerciseBundles?.forEach { bundle -> selectMuscleById(id = bundle.muscleId) }
            }.catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        api.syncMuscleTypes()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun setExerciseExample(success: () -> Unit) {
        val exerciseExample = state.value.exerciseExample ?: return

        api.setExerciseExample(
            exerciseExample = exerciseExample.toDomain(),
        ).onStart {
            _state.update { it.copy(loading = true) }
        }.onEach {
            success.invoke()
        }.catch { t ->
            _state.update { it.copy(loading = false, error = t.message) }
        }.launchIn(this)
    }

    fun onMuscleBundleChange(values: ImmutableList<MuscleExerciseBundle>) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(
                    muscleExerciseBundles = values
                )
            )
        }
    }

    fun setExerciseExampleName(value: String) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(name = value)
            )
        }
    }

    private fun ImmutableList<MuscleExerciseBundle>.addMuscle(
        muscle: Muscle,
        minimalRange: Int,
        maximalRange: Int,
    ): ImmutableList<MuscleExerciseBundle> {

        val newOne = MuscleExerciseBundle(
            muscle = muscle,
            percentage = if (this.isEmpty()) maximalRange else minimalRange
        )

        if (this.isEmpty()) return listOf(newOne).toPersistentList()

        val theMostBigItem = maxBy { it.percentage }

        return buildList {
            val list = this@addMuscle.map { item ->
                if (item == theMostBigItem) item.copy(percentage = item.percentage - minimalRange)
                else item
            }

            addAll(list)
            add(newOne)
        }.toPersistentList()
    }

    private fun ImmutableList<MuscleExerciseBundle>.removeMuscleBundle(
        muscle: Muscle,
        maximalRange: Int
    ): ImmutableList<MuscleExerciseBundle> {
        val muscleExerciseBundle = this.find { it.muscle.id == muscle.id } ?: return this

        val newList = this.minus(muscleExerciseBundle)

        if (newList.isEmpty()) return persistentListOf()

        if (newList.size == 1) return newList
            .map { it.copy(percentage = maximalRange) }
            .toImmutableList()

        val theMostMinItem = newList.minBy { it.percentage }

        return buildList {
            val list = newList.map { item ->
                if (item == theMostMinItem) item.copy(percentage = item.percentage + muscleExerciseBundle.percentage)
                else item
            }

            addAll(list)
        }.toPersistentList()
    }

    fun selectMuscleBundle(id: String) {
        selectMuscleById(id)

        _state.update {
            it.exerciseExample ?: return@update it

            val selectedMuscle = it.muscleTypes.flatMap { it.muscles }.find { it.id == id } ?: return@update it

            val muscleExerciseBundles = if (selectedMuscle.isSelected) {
                // become unselected
                it.exerciseExample.muscleExerciseBundles.removeMuscleBundle(
                    muscle = selectedMuscle,
                    maximalRange = it.sliderRange.endInclusive
                )
            } else {
                // become selected
                it.exerciseExample.muscleExerciseBundles.addMuscle(
                    muscle = selectedMuscle,
                    maximalRange = it.sliderRange.endInclusive,
                    minimalRange = it.minimalRange
                )
            }

            it.copy(
                exerciseExample = it.exerciseExample.copy(muscleExerciseBundles = muscleExerciseBundles)
            )
        }
    }

    private fun selectMuscleById(id: String) {
        _state.update {
            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    if (id == muscle.id) muscle.copy(isSelected = muscle.isSelected.not())
                    else muscle
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )
            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}