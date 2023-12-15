package exerciseexample.main

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import exerciseexample.main.factories.createFrontBackImages
import exerciseexample.main.models.ExerciseExample

@Immutable
internal data class State(
    val exerciseExample: ExerciseExample? = null,

    val fullFrontImageVector: ImageVector = exerciseExample.createFrontBackImages().first,
    val fullBackImageVector: ImageVector = exerciseExample.createFrontBackImages().second,

    val error: String? = null,
    val loading: Boolean = false
)
