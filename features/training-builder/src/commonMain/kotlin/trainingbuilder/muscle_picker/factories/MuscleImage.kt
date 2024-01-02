package trainingbuilder.muscle_picker.factories

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import musclepickerpicker.bodyBack
import musclepickerpicker.bodyFront
import musclepickerpicker.bodySplit
import musclepickerpicker.legsSplit
import trainingbuilder.muscle_picker.models.Muscle
import trainingbuilder.muscle_picker.models.MuscleEnum
import trainingbuilder.muscle_picker.models.MuscleTypeEnum
import trainingbuilder.muscle_picker.models.StatusEnum

private fun colorBySelection(
    muscle: Muscle?,
    includedMuscleStatuses: ImmutableList<StatusEnum>
): Color {

    val unSelected = Design.palette.orange.copy(alpha = 0.8f)
    val selected = Design.palette.toxic
    val default = Design.palette.white10

    return when {
        muscle?.isSelected == true && includedMuscleStatuses.contains(muscle.status) -> selected
        muscle?.isSelected == false && includedMuscleStatuses.contains(muscle.status) -> unSelected
        else -> default
    }
}

internal fun muscleImage(
    muscleTypeEnumState: MuscleTypeEnum,
    muscles: List<Muscle>,
    includedMuscleStatuses: ImmutableList<StatusEnum>,
): ImageVector {

    return when (muscleTypeEnumState) {
        MuscleTypeEnum.CHEST_MUSCLES -> {
            val pectoralisMinor = muscles.find { it.type == MuscleEnum.PECTORALIS_MINOR }
            val pectoralisMajor = muscles.find { it.type == MuscleEnum.PECTORALIS_MAJOR }

            bodyFront(
                pectoralisMinor = colorBySelection(pectoralisMinor, includedMuscleStatuses),
                pectoralisMajor = colorBySelection(pectoralisMajor, includedMuscleStatuses)
            )
        }

        MuscleTypeEnum.BACK_MUSCLES -> {
            val trapezius = muscles.find { it.type == MuscleEnum.TRAPEZIUS }
            val latissimus = muscles.find { it.type == MuscleEnum.LATISSIMUS_DORSI }
            val rhomboids = muscles.find { it.type == MuscleEnum.RHOMBOIDS }

            bodyBack(
                trapezius = colorBySelection(trapezius, includedMuscleStatuses),
                latissimus = colorBySelection(latissimus, includedMuscleStatuses),
                rhomboids = colorBySelection(rhomboids, includedMuscleStatuses)
            )
        }

        MuscleTypeEnum.ABDOMINAL_MUSCLES -> {
            val rectusAbdominis = muscles.find { it.type == MuscleEnum.RECTUS_ABDOMINIS }
            val obliquesAbdominis = muscles.find { it.type == MuscleEnum.OBLIQUES }

            bodyFront(
                rectusAbdominis = colorBySelection(rectusAbdominis, includedMuscleStatuses),
                obliquesAbdominis = colorBySelection(obliquesAbdominis, includedMuscleStatuses)
            )
        }

        MuscleTypeEnum.LEGS -> {
            val quadriceps = muscles.find { it.type == MuscleEnum.QUADRICEPS }
            val hamstrings = muscles.find { it.type == MuscleEnum.HAMSTRINGS }
            val calf = muscles.find { it.type == MuscleEnum.CALF }
            val gluteal = muscles.find { it.type == MuscleEnum.GLUTEAL }

            legsSplit(
                quadriceps = colorBySelection(quadriceps, includedMuscleStatuses),
                hamstrings = colorBySelection(hamstrings, includedMuscleStatuses),
                calf = colorBySelection(calf, includedMuscleStatuses),
                gluteal = colorBySelection(gluteal, includedMuscleStatuses)
            )
        }

        MuscleTypeEnum.ARMS_AND_FOREARMS -> {
            val biceps = muscles.find { it.type == MuscleEnum.BICEPS }
            val triceps = muscles.find { it.type == MuscleEnum.TRICEPS }
            val forearm = muscles.find { it.type == MuscleEnum.FOREARM }

            bodySplit(
                biceps = colorBySelection(biceps, includedMuscleStatuses),
                triceps = colorBySelection(triceps, includedMuscleStatuses),
                forearmFront = colorBySelection(forearm, includedMuscleStatuses),
                forearmBack = colorBySelection(forearm, includedMuscleStatuses)
            )
        }

        MuscleTypeEnum.SHOULDER_MUSCLES -> {
            val posteriorDeltoid = muscles.find { it.type == MuscleEnum.POSTERIOR_DELTOID }
            val anteriorDeltoid = muscles.find { it.type == MuscleEnum.ANTERIOR_DELTOID }
            val lateralDeltoid = muscles.find { it.type == MuscleEnum.LATERAL_DELTOID }

            bodySplit(
                posteriorDeltoid = colorBySelection(posteriorDeltoid, includedMuscleStatuses),
                anteriorDeltoid = colorBySelection(anteriorDeltoid, includedMuscleStatuses),
                lateralDeltoidFront = colorBySelection(lateralDeltoid, includedMuscleStatuses),
                lateralDeltoidBack = colorBySelection(lateralDeltoid, includedMuscleStatuses)
            )
        }
    }
}