package exerciseexamplebuilder.screen

import ExerciseExamplesRepository
import ViewModel
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
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel(
    exerciseExampleId: String?
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        val flow = exerciseExampleId
            ?.let(api::observeExerciseExample)
            ?: flowOf<models.ExerciseExample?>(null)

        flow
            .onStart {
                _state.update { it.copy(loading = false) }
            }.onEach { r ->
                val exerciseExample = r?.toState() ?: ExerciseExample()
                _state.update { it.copy(exerciseExample = exerciseExample) }
            }.flatMapLatest {
                api.observeMuscles()
            }.onEach { r ->
                _state.update {
                    it.copy(
                        availableMuscles = r
                            .filterNot { f -> it.exerciseExample?.muscleExerciseBundles?.map { it.muscle.id }?.contains(f.id) == true }
                            .toState(),
                        loading = false
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)

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

    fun addMuscle(muscle: Muscle) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(
                    muscleExerciseBundles = it.exerciseExample.muscleExerciseBundles.addMuscle(
                        muscle = muscle,
                        maximalRange = it.sliderRange.endInclusive,
                        minimalRange = it.minimalRange
                    )
                ),
                availableMuscles = buildList {
                    addAll(it.availableMuscles)
                    remove(muscle)
                }.toPersistentList()
            )
        }
    }

    fun onMuscleBundleChange(values: ImmutableList<MuscleExerciseBundle>) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(
                    muscleExerciseBundles = values
                ),
            )
        }
    }

    fun setExerciseExampleName(value: String) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(
                    name = value
                )
            )
        }
    }

    fun removeMuscleBundle(muscleExerciseBundle: MuscleExerciseBundle) {
        _state.update {
            it.exerciseExample ?: return@update it

            it.copy(
                exerciseExample = it.exerciseExample.copy(
                    muscleExerciseBundles = it.exerciseExample.muscleExerciseBundles.removeMuscleBundle(
                        muscleExerciseBundle = muscleExerciseBundle,
                        maximalRange = it.sliderRange.endInclusive,
                    )
                ),
                availableMuscles = buildList {
                    addAll(it.availableMuscles)
                    add(muscleExerciseBundle.muscle)
                }.toPersistentList()
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
            value = if (this.isEmpty()) maximalRange else minimalRange
        )

        if (this.isEmpty()) return listOf(newOne).toPersistentList()

        val theMostBigItem = maxBy { it.value }

        return buildList {
            val list = this@addMuscle.map { item ->
                if (item == theMostBigItem) item.copy(value = item.value - minimalRange)
                else item
            }

            addAll(list)
            add(newOne)
        }.toPersistentList()
    }

    private fun ImmutableList<MuscleExerciseBundle>.removeMuscleBundle(
        muscleExerciseBundle: MuscleExerciseBundle,
        maximalRange: Int
    ): ImmutableList<MuscleExerciseBundle> {

        val newList = this
            .minus(muscleExerciseBundle)

        if (newList.isEmpty()) return persistentListOf()

        if (newList.size == 1) return newList
            .map { it.copy(value = maximalRange) }
            .toImmutableList()

        val theMostMinItem = newList.minBy { it.value }

        return buildList {
            val list = newList.map { item ->
                if (item == theMostMinItem) item.copy(value = item.value + muscleExerciseBundle.value)
                else item
            }

            addAll(list)
        }.toPersistentList()
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}