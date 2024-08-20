package exercise

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
public data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: ImmutableList<ExerciseExampleBundle>,
    val name: String,
    val imageUrl: String?,
)