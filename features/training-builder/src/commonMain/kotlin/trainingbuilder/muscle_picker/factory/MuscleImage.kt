package trainingbuilder.muscle_picker.factory

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import musclepickerpicker.bodyBack
import musclepickerpicker.bodyFront
import musclepickerpicker.bodySplit
import musclepickerpicker.legsSplit
import trainingbuilder.muscle_picker.state.Muscle
import trainingbuilder.muscle_picker.state.MuscleEnum
import trainingbuilder.muscle_picker.state.MuscleTypeEnum

private fun colorBySelection(condition: Boolean?): Color {
    val muscle = Color(0xffb12a1a)

    val default = muscle.copy(alpha = 0.8f)
    val selected = Design.palette.toxic
    return if (condition == true) selected else default
}

internal fun muscleImage(
    muscleTypeEnumState: MuscleTypeEnum,
    muscles: List<Muscle>
): ImageVector {

    return when (muscleTypeEnumState) {
        MuscleTypeEnum.CHEST_MUSCLES -> {
            val pectoralisMinor = muscles.find { it.type == MuscleEnum.PECTORALIS_MINOR }?.isSelected
            val pectoralisMajor = muscles.find { it.type == MuscleEnum.PECTORALIS_MAJOR }?.isSelected

            bodyFront(
                pectoralisMinor = colorBySelection(pectoralisMinor),
                pectoralisMajor = colorBySelection(pectoralisMajor)
            )
        }

        MuscleTypeEnum.BACK_MUSCLES -> {
            val trapezius = muscles.find { it.type == MuscleEnum.TRAPEZIUS }?.isSelected
            val latissimus = muscles.find { it.type == MuscleEnum.LATISSIMUS_DORSI }?.isSelected
            val rhomboids = muscles.find { it.type == MuscleEnum.RHOMBOIDS }?.isSelected

            bodyBack(
                trapezius = colorBySelection(trapezius),
                latissimus = colorBySelection(latissimus),
                rhomboids = colorBySelection(rhomboids)
            )
        }

        MuscleTypeEnum.ABDOMINAL_MUSCLES -> {
            val rectusAbdominis = muscles.find { it.type == MuscleEnum.RECTUS_ABDOMINIS }?.isSelected
            val obliquesAbdominis = muscles.find { it.type == MuscleEnum.OBLIQUES }?.isSelected

            bodyFront(
                rectusAbdominis = colorBySelection(rectusAbdominis),
                obliquesAbdominis = colorBySelection(obliquesAbdominis)
            )
        }

        MuscleTypeEnum.LEGS -> {
            val quadriceps = muscles.find { it.type == MuscleEnum.QUADRICEPS }?.isSelected
            val hamstrings = muscles.find { it.type == MuscleEnum.HAMSTRINGS }?.isSelected
            val calf = muscles.find { it.type == MuscleEnum.CALF }?.isSelected
            val gluteal = muscles.find { it.type == MuscleEnum.GLUTEAL }?.isSelected

            legsSplit(
                quadriceps = colorBySelection(quadriceps),
                hamstrings = colorBySelection(hamstrings),
                calf = colorBySelection(calf),
                gluteal = colorBySelection(gluteal)
            )
        }

        MuscleTypeEnum.ARMS_AND_FOREARMS -> {
            val biceps = muscles.find { it.type == MuscleEnum.BICEPS }?.isSelected
            val triceps = muscles.find { it.type == MuscleEnum.TRICEPS }?.isSelected
            val forearm = muscles.find { it.type == MuscleEnum.FOREARM }?.isSelected

            bodySplit(
                biceps = colorBySelection(biceps),
                triceps = colorBySelection(triceps),
                forearmFront = colorBySelection(forearm),
                forearmBack = colorBySelection(forearm)
            )
        }

        MuscleTypeEnum.SHOULDER_MUSCLES -> {
            val posteriorDeltoid = muscles.find { it.type == MuscleEnum.POSTERIOR_DELTOID }?.isSelected
            val anteriorDeltoid = muscles.find { it.type == MuscleEnum.ANTERIOR_DELTOID }?.isSelected
            val lateralDeltoid = muscles.find { it.type == MuscleEnum.LATERAL_DELTOID }?.isSelected

            bodySplit(
                posteriorDeltoid = colorBySelection(posteriorDeltoid),
                anteriorDeltoid = colorBySelection(anteriorDeltoid),
                lateralDeltoidFront = colorBySelection(lateralDeltoid),
                lateralDeltoidBack = colorBySelection(lateralDeltoid)
            )
        }
    }
}