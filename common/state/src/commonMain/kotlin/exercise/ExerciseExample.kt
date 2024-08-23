package exercise

import androidx.compose.runtime.Immutable
import equipment.Equipment
import kotlinx.collections.immutable.ImmutableList
import user.ExperienceEnum

@Immutable
public data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: ImmutableList<ExerciseExampleBundle>,
    val name: String,
    val imageUrl: String?,
    val description: String,
    val equipments: ImmutableList<Equipment>,
    val tutorials: ImmutableList<Tutorial>,
    val experience: ExperienceEnum?,
    val forceType: ForceType?,
    val weightType: WeightType?,
    val category: Category?,
)