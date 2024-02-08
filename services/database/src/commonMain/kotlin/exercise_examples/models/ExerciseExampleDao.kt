package exercise_examples.models

public data class ExerciseExampleDao(
    val id: String,
    val exerciseExampleBundles: List<ExerciseExampleBundleDao>,
    val equipments: List<ExerciseExampleEquipmentDao>,
    val tutorials: List<ExerciseExampleTutorialDao>,
    val name: String,
    val description: String?,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String?,
    val forceType: String,
    val experience: String,
    val weightType: String,
    val category: String
)