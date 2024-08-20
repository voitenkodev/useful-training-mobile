package profile.main

import androidx.compose.runtime.Immutable
import exercise.ExerciseExample
import trainings.Training
import user.User
import user.WeightHistory

@Immutable
internal data class State(
    val user: User? = null,

    val lastWeight: WeightHistory? = null,
    val lastTraining: Training? = null,
    val lastExerciseExample: ExerciseExample? = null,

    val error: String? = null,
    val loading: Boolean = false
)
