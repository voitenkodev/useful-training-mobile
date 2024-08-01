package muscles.factories

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import muscles.Muscle
import muscles.MuscleEnum
import muscles.MuscleGroupEnum
import muscles.MuscleLoadEnum
import muscles.bodyBack
import muscles.bodyFront
import muscles.bodySplit
import muscles.legsSplit

@Immutable
internal sealed class MuscleColorStyle {

    data class Loading(val includedMuscleStatuses: ImmutableList<MuscleLoadEnum>) :
        MuscleColorStyle()

    data object Default :
        MuscleColorStyle()
}

private fun colorBySelection(
    muscle: Muscle?,
    style: MuscleColorStyle,
): Color {

    val unSelected = Design.palette.content.copy(0.3f)
    val default = Design.palette.white10

    return when (style) {
        is MuscleColorStyle.Loading -> {
            val selected = Design.palette.toxic.copy(alpha = 0.7f)

            when {
                muscle?.isSelected == true && style.includedMuscleStatuses.contains(muscle.load) -> selected
                muscle?.isSelected == false && style.includedMuscleStatuses.contains(muscle.load) -> unSelected
                else -> default
            }
        }

        is MuscleColorStyle.Default -> {
            val selected = Design.palette.toxic

            when (muscle?.isSelected) {
                true -> selected
                false -> unSelected
                else -> default
            }
        }
    }
}

public fun muscleImage(
    muscleGroupEnumState: MuscleGroupEnum,
    muscles: List<Muscle>,
    includedMuscleStatuses: ImmutableList<MuscleLoadEnum>?,
): ImageVector {

    val style = if (includedMuscleStatuses == null) {
        MuscleColorStyle.Default
    } else {
        MuscleColorStyle.Loading(includedMuscleStatuses)
    }

    return when (muscleGroupEnumState) {
        MuscleGroupEnum.CHEST_MUSCLES -> {
            val pectoralisMinor = muscles.find { it.type == MuscleEnum.PECTORALIS_MINOR }
            val pectoralisMajor = muscles.find { it.type == MuscleEnum.PECTORALIS_MAJOR }

            bodyFront(
                pectoralisMinor = colorBySelection(pectoralisMinor, style),
                pectoralisMajor = colorBySelection(pectoralisMajor, style)
            )
        }

        MuscleGroupEnum.BACK_MUSCLES -> {
            val trapezius = muscles.find { it.type == MuscleEnum.TRAPEZIUS }
            val latissimus = muscles.find { it.type == MuscleEnum.LATISSIMUS_DORSI }
            val rhomboids = muscles.find { it.type == MuscleEnum.RHOMBOIDS }
            val teresMajor = muscles.find { it.type == MuscleEnum.TERES_MAJOR }

            bodyBack(
                trapezius = colorBySelection(trapezius, style),
                latissimus = colorBySelection(latissimus, style),
                rhomboids = colorBySelection(rhomboids, style),
                teresMajor = colorBySelection(teresMajor, style)
            )
        }

        MuscleGroupEnum.ABDOMINAL_MUSCLES -> {
            val rectusAbdominis = muscles.find { it.type == MuscleEnum.RECTUS_ABDOMINIS }
            val obliquesAbdominis = muscles.find { it.type == MuscleEnum.OBLIQUES }

            bodyFront(
                rectusAbdominis = colorBySelection(rectusAbdominis, style),
                obliquesAbdominis = colorBySelection(obliquesAbdominis, style)
            )
        }

        MuscleGroupEnum.LEGS -> {
            val quadriceps = muscles.find { it.type == MuscleEnum.QUADRICEPS }
            val hamstrings = muscles.find { it.type == MuscleEnum.HAMSTRINGS }
            val calf = muscles.find { it.type == MuscleEnum.CALF }
            val gluteal = muscles.find { it.type == MuscleEnum.GLUTEAL }

            legsSplit(
                quadriceps = colorBySelection(quadriceps, style),
                hamstrings = colorBySelection(hamstrings, style),
                calf = colorBySelection(calf, style),
                gluteal = colorBySelection(gluteal, style)
            )
        }

        MuscleGroupEnum.ARMS_AND_FOREARMS -> {
            val biceps = muscles.find { it.type == MuscleEnum.BICEPS }
            val triceps = muscles.find { it.type == MuscleEnum.TRICEPS }
            val forearm = muscles.find { it.type == MuscleEnum.FOREARM }

            bodySplit(
                biceps = colorBySelection(biceps, style),
                triceps = colorBySelection(triceps, style),
                forearmFront = colorBySelection(forearm, style),
                forearmBack = colorBySelection(forearm, style)
            )
        }

        MuscleGroupEnum.SHOULDER_MUSCLES -> {
            val posteriorDeltoid = muscles.find { it.type == MuscleEnum.POSTERIOR_DELTOID }
            val anteriorDeltoid = muscles.find { it.type == MuscleEnum.ANTERIOR_DELTOID }
            val lateralDeltoid = muscles.find { it.type == MuscleEnum.LATERAL_DELTOID }

            bodySplit(
                posteriorDeltoid = colorBySelection(posteriorDeltoid, style),
                anteriorDeltoid = colorBySelection(anteriorDeltoid, style),
                lateralDeltoidFront = colorBySelection(lateralDeltoid, style)
            )
        }
    }
}