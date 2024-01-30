package models

public data class ExerciseExample(
    val id: String,
    val exerciseExampleBundles: List<ExerciseExampleBundle>,
    val equipments: List<Equipment>,
    val name: String,
    val description: String?,
    val imageUrl: String?,
    val experience: ExperienceEnum,
    val forceType: ForceTypeEnum,
    val weightType: WeightTypeEnum,
    val category: CategoryEnum
)