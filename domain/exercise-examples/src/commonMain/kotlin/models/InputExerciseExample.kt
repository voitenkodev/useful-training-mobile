package models

public data class InputExerciseExample(
    val exerciseExampleBundles: List<InputExerciseExampleBundle>,
    val exerciseExampleTutorial: InputExerciseExampleTutorial?,
    val equipmentIds: List<String>,
    val name: String,
    val description: String?,
    val imageUrl: String?,
    val experience: ExperienceEnum,
    val forceType: ForceTypeEnum,
    val weightType: WeightTypeEnum,
    val category: CategoryEnum
)