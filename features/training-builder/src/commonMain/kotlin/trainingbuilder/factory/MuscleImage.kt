package trainingbuilder.factory

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import musclepickerpicker.bodyBack
import musclepickerpicker.bodyFront
import musclepickerpicker.bodySplit
import musclepickerpicker.legsSplit
import trainingbuilder.state.Muscle
import trainingbuilder.state.MuscleEnumState
import trainingbuilder.state.MuscleTypeEnumState

private fun colorBySelection(condition: Boolean?): Color {
    val default = Design.palette.orange
    val selected = Design.palette.toxic
    return if (condition == true) selected else default
}

internal fun muscleImage(
    muscleTypeEnumState: MuscleTypeEnumState,
    muscles: List<Muscle>
): ImageVector {

    return when (muscleTypeEnumState) {
        MuscleTypeEnumState.CHEST_MUSCLES -> {
            val pectoralisMinor = muscles.find { it.type == MuscleEnumState.PECTORALIS_MINOR }?.isSelected
            val pectoralisMajor = muscles.find { it.type == MuscleEnumState.PECTORALIS_MAJOR }?.isSelected

            bodyFront(
                pectoralisMinor = colorBySelection(pectoralisMinor),
                pectoralisMajor = colorBySelection(pectoralisMajor)
            )
        }

        MuscleTypeEnumState.BACK_MUSCLES -> {
            val trapezius = muscles.find { it.type == MuscleEnumState.TRAPEZIUS }?.isSelected
            val latissimus = muscles.find { it.type == MuscleEnumState.LATISSIMUS_DORSI }?.isSelected
            val rhomboids = muscles.find { it.type == MuscleEnumState.RHOMBOIDS }?.isSelected

            bodyBack(
                trapezius = colorBySelection(trapezius),
                latissimus = colorBySelection(latissimus),
                rhomboids = colorBySelection(rhomboids)
            )
        }

        MuscleTypeEnumState.ABDOMINAL_MUSCLES -> {
            val rectusAbdominis = muscles.find { it.type == MuscleEnumState.RECTUS_ABDOMINIS }?.isSelected
            val obliquesAbdominis = muscles.find { it.type == MuscleEnumState.OBLIQUES }?.isSelected

            bodyFront(
                rectusAbdominis = colorBySelection(rectusAbdominis),
                obliquesAbdominis = colorBySelection(obliquesAbdominis)
            )
        }

        MuscleTypeEnumState.LEGS -> {
            val quadriceps = muscles.find { it.type == MuscleEnumState.QUADRICEPS }?.isSelected
            val hamstrings = muscles.find { it.type == MuscleEnumState.HAMSTRINGS }?.isSelected
            val calf = muscles.find { it.type == MuscleEnumState.CALF }?.isSelected
            val gluteal = muscles.find { it.type == MuscleEnumState.GLUTEAL }?.isSelected

            legsSplit(
                quadriceps = colorBySelection(quadriceps),
                hamstrings = colorBySelection(hamstrings),
                calf = colorBySelection(calf),
                gluteal = colorBySelection(gluteal)
            )
        }

        MuscleTypeEnumState.ARMS_AND_FOREARMS -> {
            val biceps = muscles.find { it.type == MuscleEnumState.BICEPS }?.isSelected
            val triceps = muscles.find { it.type == MuscleEnumState.TRICEPS }?.isSelected
            val forearm = muscles.find { it.type == MuscleEnumState.FOREARM }?.isSelected

            bodySplit(
                biceps = colorBySelection(biceps),
                triceps = colorBySelection(triceps),
                forearmFront = colorBySelection(forearm),
                forearmBack = colorBySelection(forearm)
            )
        }

        MuscleTypeEnumState.SHOULDER_MUSCLES -> {
            val posteriorDeltoid = muscles.find { it.type == MuscleEnumState.POSTERIOR_DELTOID }?.isSelected
            val anteriorDeltoid = muscles.find { it.type == MuscleEnumState.ANTERIOR_DELTOID }?.isSelected
            val lateralDeltoid = muscles.find { it.type == MuscleEnumState.LATERAL_DELTOID }?.isSelected

            bodySplit(
                posteriorDeltoid = colorBySelection(posteriorDeltoid),
                anteriorDeltoid = colorBySelection(anteriorDeltoid),
                lateralDeltoidFront = colorBySelection(lateralDeltoid),
                lateralDeltoidBack = colorBySelection(lateralDeltoid)
            )
        }
    }
}