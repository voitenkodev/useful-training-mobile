package exerciseexample.main.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: ImmutableList<ExerciseExampleBundle>,
    val equipments: ImmutableList<Equipment>,
    val name: String,
    val description: String?,
    val imageUrl: String?
)