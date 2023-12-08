package trainingbuilder.builder.factory

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import musclepickerpicker.fullBack
import musclepickerpicker.fullFront
import trainingbuilder.builder.state.Exercise
import trainingbuilder.builder.state.Muscle
import trainingbuilder.builder.state.MuscleEnum

internal fun List<Exercise>.createFrontBackImages(): Pair<ImageVector, ImageVector> {
    val muscleWithAlpha = calculate()
        .toList()
        .sortedByDescending { it.second }
        .mapValueToAlpha()

    val front = fullFront(
        biceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.BICEPS]),
        forearm = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.FOREARM]),
        lateralDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.LATERAL_DELTOID]),
        anteriorDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.ANTERIOR_DELTOID]),
        rectusAbdominis = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.RECTUS_ABDOMINIS]),
        pectoralisMajor = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.PECTORALIS_MAJOR]),
        pectoralisMinor = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.PECTORALIS_MINOR]),
        quadriceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.QUADRICEPS])
    )

    val back = fullBack(
        rhomboids = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.RHOMBOIDS]),
        latissimus = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.LATISSIMUS_DORSI]),
        triceps = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.TRICEPS]),
        trapezius = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.TRAPEZIUS]),
        forearm = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.FOREARM]),
        posteriorDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.POSTERIOR_DELTOID]),
        lateralDeltoid = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.LATERAL_DELTOID]),
        gluteal = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.GLUTEAL]),
        hamstrings = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.HAMSTRINGS]),
        calf = colorSelectionWithAlpha(muscleWithAlpha[MuscleEnum.CALF])
    )

    return front to back
}

private fun colorSelectionWithAlpha(alpha: Float?): Color {
    val default = Design.palette.content.copy(alpha = 0.4f)
    if (alpha == null) return default
    val selected = Design.palette.red
    return selected.copy(alpha = alpha)
}

private fun List<Pair<Muscle, Double>>.mapValueToAlpha(): Map<MuscleEnum, Float> {
    val alphaValues = mutableMapOf<MuscleEnum, Float>()

    if (isEmpty()) return alphaValues

    val step = 0.9 / (size - 1)
    var currentAlpha = 1.0

    forEach { (muscle, _) ->
        alphaValues[muscle.type] = currentAlpha.toFloat()
        currentAlpha -= step
    }

    return alphaValues
}

private fun List<Exercise>.calculate(): Map<Muscle, Double> {
    val allMuscleRatios = map { it.calculateMuscleWorkRatio() }

    return allMuscleRatios
        .flatMap { it.entries }
        .groupBy({ it.key }) { it.value }
        .mapValues { (_, values) -> values.sumOf { it } }
        .mapValues { (_, total) -> total / allMuscleRatios.size * 100 }
}

private fun Exercise.calculateMuscleWorkRatio(): Map<Muscle, Double> {
    return exerciseExample?.muscleExerciseBundles
        ?.associate { bundle -> bundle.muscle to volume * bundle.percentage / 100.0 }
        ?: emptyMap()
}