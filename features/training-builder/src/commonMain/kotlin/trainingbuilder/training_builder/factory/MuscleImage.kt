package trainingbuilder.training_builder.factory

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import musclepickerpicker.fullBack
import musclepickerpicker.fullFront
import trainingbuilder.training_builder.state.Exercise
import trainingbuilder.training_builder.state.Muscle
import trainingbuilder.training_builder.state.MuscleEnum

internal fun List<Exercise>.createFrontBackImages(): Pair<ImageVector, ImageVector> {
    val muscleWithAlpha = calculateMuscleRatios()
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

    val distinctValues = groupBy { it.second }

    val step = if (distinctValues.size > 1) 0.9f / (distinctValues.size - 1) else 0.0f
    var currentAlpha = 1.0f

    distinctValues.forEach { (_, values) ->
        values.forEach { (muscle, _) ->
            alphaValues[muscle.type] = currentAlpha
        }
        currentAlpha -= step
    }

    return alphaValues
}

private fun List<Exercise>.calculateMuscleRatios(): Map<Muscle, Double> {
    val totalMuscleRatios = mutableMapOf<Muscle, Double>()

    forEach { exercise ->
        val muscleWorkRatios = mutableMapOf<Muscle, Double>()

        exercise.exerciseExample?.muscleExerciseBundles?.forEach { bundle ->
            val musclePercentage = bundle.percentage / 100.0
            val muscleWork = exercise.volume * musclePercentage * exercise.repetitions

            muscleWorkRatios[bundle.muscle] = (muscleWorkRatios[bundle.muscle] ?: 0.0) + muscleWork
        }
        muscleWorkRatios.forEach { (muscle, ratio) ->
            totalMuscleRatios[muscle] = (totalMuscleRatios[muscle] ?: 0.0) + ratio
        }
    }

    val totalWork = totalMuscleRatios.values.sum()

    return if (totalWork != 0.0) {
        totalMuscleRatios.mapValues { it.value / totalWork * 100 }
    } else {
        totalMuscleRatios.mapValues { 0.0 }
    }
}