package exerciseexample.main.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: ImmutableList<ExerciseExampleBundle>,
    val equipments: ImmutableList<Equipment>,
    val tutorials: ImmutableList<Tutorial>,
    val name: String,
    val experience: Experience?,
    val forceType: ForceType?,
    val weightType: WeightType?,
    val category: Category?,
    val description: String?,
    val imageUrl: String?
)