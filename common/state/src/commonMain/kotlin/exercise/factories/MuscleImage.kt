package exercise.factories

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import exercise.ExerciseExample
import muscles.MuscleEnum
import muscles.fullBack
import muscles.fullFront

public fun ExerciseExample?.createFrontBackImages(): Pair<ImageVector, ImageVector> {
    if (this == null) return fullFront() to fullBack()

    val muscleWithAlpha = exerciseExampleBundles
//        .associate { it.muscle.type to it.percentage.toFloat() / 100 }
        .associate { it.muscle.type to 1.0f }

    val front = fullFront(
        biceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.BICEPS]),
        forearm = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.FOREARM]),
        lateralDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.LATERAL_DELTOID]),
        anteriorDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.ANTERIOR_DELTOID]),
        rectusAbdominis = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.RECTUS_ABDOMINIS]),
        obliquesAbdominis = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.OBLIQUES]),
        pectoralisMajorAbdominal = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.PECTORALIS_MAJOR_ABDOMINAL]),
        pectoralisMajorClavicular = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.PECTORALIS_MAJOR_CLAVICULAR]),
        pectoralisMajorSternocostal = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.PECTORALIS_MAJOR_STERNOCOSTAL]),
        quadriceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.QUADRICEPS]),

        outlineColor = Design.palette.content
    )

    val back = fullBack(
        rhomboids = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.RHOMBOIDS]),
        latissimus = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.LATISSIMUS_DORSI]),
        triceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.TRICEPS]),
        teresMajor = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.TERES_MAJOR]),
        trapezius = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.TRAPEZIUS]),
        forearm = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.FOREARM]),
        posteriorDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.POSTERIOR_DELTOID]),
        gluteal = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.GLUTEAL]),
        hamstrings = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.HAMSTRINGS]),
        calf = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.CALF]),
        adductors = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.ADDUCTORS]),
        abductors = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.ABDUCTORS]),

        outlineColor = Design.palette.content
    )

    return front to back
}

private fun colorSelectionWithAlpha(alpha: Float?): Color {
    val default = Design.palette.content.copy(alpha = 0.4f)
    if (alpha == null) return default
    val selected = Design.palette.orange
    return selected.copy(alpha = alpha)
}