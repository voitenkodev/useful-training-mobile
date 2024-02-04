package searchexercise.main.factories

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import muscles.bodyBack
import muscles.bodyFront
import muscles.bodySplit
import muscles.legsSplit
import searchexercise.main.models.FilterMuscle
import searchexercise.main.models.MuscleEnum
import searchexercise.main.models.MuscleGroupEnum
import searchexercise.main.models.StatusEnum

private fun colorBySelection(muscle: FilterMuscle?): Color {

    val unSelected = Design.palette.white10
    val selected = Design.palette.toxic.copy(alpha = 0.7f)
    val default = Design.palette.white10

    return when (muscle?.status) {
        StatusEnum.SELECTED -> selected
        StatusEnum.UNSELECTED -> unSelected
        else -> default
    }
}

internal fun muscleImage(
    muscleGroupEnumState: MuscleGroupEnum,
    muscles: List<FilterMuscle>
): ImageVector {

    return when (muscleGroupEnumState) {
        MuscleGroupEnum.CHEST_MUSCLES -> {
            val pectoralisMinor = muscles.find { it.type == MuscleEnum.PECTORALIS_MINOR }
            val pectoralisMajor = muscles.find { it.type == MuscleEnum.PECTORALIS_MAJOR }

            bodyFront(
                pectoralisMinor = colorBySelection(pectoralisMinor),
                pectoralisMajor = colorBySelection(pectoralisMajor)
            )
        }

        MuscleGroupEnum.BACK_MUSCLES -> {
            val trapezius = muscles.find { it.type == MuscleEnum.TRAPEZIUS }
            val latissimus = muscles.find { it.type == MuscleEnum.LATISSIMUS_DORSI }
            val rhomboids = muscles.find { it.type == MuscleEnum.RHOMBOIDS }
            val teresMajor = muscles.find { it.type == MuscleEnum.TERES_MAJOR }

            bodyBack(
                trapezius = colorBySelection(trapezius),
                latissimus = colorBySelection(latissimus),
                rhomboids = colorBySelection(rhomboids),
                teresMajor = colorBySelection(teresMajor)
            )
        }

        MuscleGroupEnum.ABDOMINAL_MUSCLES -> {
            val rectusAbdominis = muscles.find { it.type == MuscleEnum.RECTUS_ABDOMINIS }
            val obliquesAbdominis = muscles.find { it.type == MuscleEnum.OBLIQUES }

            bodyFront(
                rectusAbdominis = colorBySelection(rectusAbdominis),
                obliquesAbdominis = colorBySelection(obliquesAbdominis)
            )
        }

        MuscleGroupEnum.LEGS -> {
            val quadriceps = muscles.find { it.type == MuscleEnum.QUADRICEPS }
            val hamstrings = muscles.find { it.type == MuscleEnum.HAMSTRINGS }
            val calf = muscles.find { it.type == MuscleEnum.CALF }
            val gluteal = muscles.find { it.type == MuscleEnum.GLUTEAL }

            legsSplit(
                quadriceps = colorBySelection(quadriceps),
                hamstrings = colorBySelection(hamstrings),
                calf = colorBySelection(calf),
                gluteal = colorBySelection(gluteal)
            )
        }

        MuscleGroupEnum.ARMS_AND_FOREARMS -> {
            val biceps = muscles.find { it.type == MuscleEnum.BICEPS }
            val triceps = muscles.find { it.type == MuscleEnum.TRICEPS }
            val forearm = muscles.find { it.type == MuscleEnum.FOREARM }

            bodySplit(
                biceps = colorBySelection(biceps),
                triceps = colorBySelection(triceps),
                forearmFront = colorBySelection(forearm),
                forearmBack = colorBySelection(forearm)
            )
        }

        MuscleGroupEnum.SHOULDER_MUSCLES -> {
            val posteriorDeltoid = muscles.find { it.type == MuscleEnum.POSTERIOR_DELTOID }
            val anteriorDeltoid = muscles.find { it.type == MuscleEnum.ANTERIOR_DELTOID }
            val lateralDeltoid = muscles.find { it.type == MuscleEnum.LATERAL_DELTOID }

            bodySplit(
                posteriorDeltoid = colorBySelection(posteriorDeltoid),
                anteriorDeltoid = colorBySelection(anteriorDeltoid),
                lateralDeltoidFront = colorBySelection(lateralDeltoid)
            )
        }
    }
}