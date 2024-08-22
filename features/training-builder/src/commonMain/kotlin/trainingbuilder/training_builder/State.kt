package trainingbuilder.training_builder

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import muscles.Muscle
import trainingbuilder.training_builder.factories.createFrontBackImages
import trainingbuilder.training_builder.models.BuildExercise
import trainingbuilder.training_builder.models.BuildTraining
import trainingbuilder.training_builder.models.SetExerciseState

@Immutable
internal data class State(
    val buildTraining: BuildTraining = BuildTraining(),

    val muscles: ImmutableList<Muscle> = persistentListOf(),
    val selectedMuscle: Muscle? = null,
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    val setExerciseState: SetExerciseState = SetExerciseState.Closed,
    val findExercisePopupIsVisible: Boolean = false,
    val recommendationsLoading: Boolean = false,

    val fullFrontImageVector: ImageVector = buildTraining.buildExercises.createFrontBackImages().first,
    val fullBackImageVector: ImageVector = buildTraining.buildExercises.createFrontBackImages().second,

    val error: String? = null,
    val loading: Boolean = false,

    // SetExercisePage
    val selectedBuildExercise: BuildExercise? = null
)