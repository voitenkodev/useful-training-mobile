package profile.main

import androidx.compose.runtime.Immutable
import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import trainings.Training
import user.User
import user.WeightHistory

@Immutable
internal data class State(
    val user: User? = null,

    val lastWeight: WeightHistory? = null,
    val lastTraining: Training? = null,
    val lastExerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    val error: String? = null,
    val loading: Boolean = false
)
