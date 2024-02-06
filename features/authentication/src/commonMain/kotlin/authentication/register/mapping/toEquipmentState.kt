package authentication.register.mapping

import androidx.compose.ui.graphics.vector.ImageVector
import authentication.register.models.Equipment
import authentication.register.models.StatusEnum
import equipments.AbMachine
import equipments.AdjustableBench
import equipments.Barbell
import equipments.BicepsMachine
import equipments.Butterfly
import equipments.Cable
import equipments.CalfRaiseMachines
import equipments.ChestPressMachines
import equipments.Crossower
import equipments.DeadliftMachines
import equipments.DeclineBench
import equipments.DeclineBenchWithRack
import equipments.DipBar
import equipments.Dumbbell
import equipments.EzBar
import equipments.FlatBench
import equipments.FlatBenchWithRack
import equipments.GluteHamRaiseBench
import equipments.GluteMachines
import equipments.HackSquatMachines
import equipments.InclineBenchWithRack
import equipments.LatPulldown
import equipments.LateralRaiseMachines
import equipments.LegCurlMachine
import equipments.LegExtensionMachine
import equipments.PreacherCurlBench
import equipments.PullUpBar
import equipments.RomainChair
import equipments.Rope
import equipments.RowBench
import equipments.RowCable
import equipments.ShoulderPressMachines
import equipments.SmithMachine
import equipments.SquatRack
import equipments.TrapBar
import equipments.TricepsMachines
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.EquipmentEnum

internal fun List<models.Equipment>.toState(): ImmutableList<Equipment> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Equipment.toState(): Equipment? {
    return Equipment(
        name = name,
        id = id,
        image = type.toImageState() ?: return null,
        status = StatusEnum.INCLUDED
    )
}

private fun EquipmentEnum.toImageState(): ImageVector? {
    return when (this) {
        EquipmentEnum.DUMBBELLS -> Dumbbell
        EquipmentEnum.ROPE -> Rope
        EquipmentEnum.BARBELL -> Barbell
        EquipmentEnum.EZ_BAR -> EzBar
        EquipmentEnum.TRAP_BAR -> TrapBar
        EquipmentEnum.AB_MACHINES -> AbMachine
        EquipmentEnum.BUTTERFLY -> Butterfly
        EquipmentEnum.BUTTERFLY_REVERSE -> Butterfly
        EquipmentEnum.LEG_EXTENSION_MACHINES -> LegExtensionMachine
        EquipmentEnum.LEG_CURL_MACHINES -> LegCurlMachine
        EquipmentEnum.CHEST_PRESS_MACHINES -> ChestPressMachines
        EquipmentEnum.BICEPS_MACHINES -> BicepsMachine
        EquipmentEnum.SMITH_MACHINES -> SmithMachine
        EquipmentEnum.HACK_SQUAT_MACHINES -> HackSquatMachines
        EquipmentEnum.DEADLIFT_MACHINES -> DeadliftMachines
        EquipmentEnum.SHOULDER_PRESS_MACHINES -> ShoulderPressMachines
        EquipmentEnum.LATERAL_RAISE_MACHINES -> LateralRaiseMachines
        EquipmentEnum.TRICEPS_MACHINES -> TricepsMachines
        EquipmentEnum.CALF_RAISE_MACHINES -> CalfRaiseMachines
        EquipmentEnum.GLUTE_MACHINES -> GluteMachines
        EquipmentEnum.LAT_PULLDOWN -> LatPulldown
        EquipmentEnum.CABLE -> Cable
        EquipmentEnum.CABLE_CROSSOVER -> Crossower
        EquipmentEnum.ROW_CABLE -> RowCable
        EquipmentEnum.PULL_UP_BAR -> PullUpBar
        EquipmentEnum.DIP_BARS -> DipBar
        EquipmentEnum.ROMAIN_CHAIR -> RomainChair
        EquipmentEnum.GLUTE_HAM_RAISE_BENCH -> GluteHamRaiseBench
        EquipmentEnum.FLAT_BENCH -> FlatBench
        EquipmentEnum.ADJUSTABLE_BENCH -> AdjustableBench
        EquipmentEnum.DECLINE_BENCH -> DeclineBench
        EquipmentEnum.FLAT_BENCH_WITH_RACK -> FlatBenchWithRack
        EquipmentEnum.INCLINE_BENCH_WITH_RACK -> InclineBenchWithRack
        EquipmentEnum.DECLINE_BENCH_WITH_RACK -> DeclineBenchWithRack
        EquipmentEnum.SQUAT_RACK -> SquatRack
        EquipmentEnum.PREACHER_CURL_BENCH -> PreacherCurlBench
        EquipmentEnum.ROW_BENCH -> RowBench
        else -> null
    }
}