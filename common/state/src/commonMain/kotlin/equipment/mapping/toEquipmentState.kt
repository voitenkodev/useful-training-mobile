package equipment.mapping

import IncludedStatusEnum
import androidx.compose.ui.graphics.vector.ImageVector
import equipment.Equipment
import equipments.AbMachine
import equipments.AbductorMachine
import equipments.AdductorMachine
import equipments.AdjustableBench
import equipments.Barbell
import equipments.BicepsMachine
import equipments.Butterfly
import equipments.Cable
import equipments.CalfRaiseMachines
import equipments.ChestPressMachines
import equipments.CloseGripHandle
import equipments.CordHandles
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
import equipments.LegPressMachine
import equipments.PreacherCurlBench
import equipments.PullUpBar
import equipments.RomainChair
import equipments.Rope
import equipments.RowBench
import equipments.RowCable
import equipments.ShoulderPressMachines
import equipments.SmithMachine
import equipments.SquatRack
import equipments.StraightBar
import equipments.TrapBar
import equipments.TricepsMachines
import equipments.VBar
import equipments.WideGripHandle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.EquipmentEnum
import models.EquipmentStatusEnum

public fun List<models.Equipment>.toState(
    eachEquipment: (models.Equipment) -> Equipment? = {
        it.toState(false)
    },
): ImmutableList<Equipment> {
    return mapNotNull(eachEquipment)
        .toPersistentList()
}

public fun models.Equipment.toState(
    isSelected: Boolean,
    defaultStatus: IncludedStatusEnum? = null,
): Equipment? {
    return Equipment(
        name = name,
        id = id,
        loading = false,
        image = type.toImageState() ?: return null,
        status = defaultStatus ?: status.toState(),
        isSelected = isSelected
    )
}

private fun EquipmentStatusEnum.toState(): IncludedStatusEnum? {
    return when (this) {
        EquipmentStatusEnum.EXCLUDED -> IncludedStatusEnum.EXCLUDED
        EquipmentStatusEnum.UNKNOWN -> null
        else -> IncludedStatusEnum.INCLUDED
    }
}

private fun EquipmentEnum.toImageState(): ImageVector? {
    return when (this) {
        EquipmentEnum.DUMBBELLS -> Dumbbell
        EquipmentEnum.ROPE -> Rope
        EquipmentEnum.CORD_HANDLES -> CordHandles
        EquipmentEnum.STRAIGHT_BAR -> StraightBar
        EquipmentEnum.BARBELL -> Barbell
        EquipmentEnum.EZ_BAR -> EzBar
        EquipmentEnum.VBar -> VBar
        EquipmentEnum.CloseGripHandle -> CloseGripHandle
        EquipmentEnum.WideGripHandle -> WideGripHandle
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
        EquipmentEnum.ADDUCTOR_MACHINE -> AdductorMachine
        EquipmentEnum.ABDUCTOR_MACHINE -> AbductorMachine
        EquipmentEnum.DECLINE_BENCH -> DeclineBench
        EquipmentEnum.FLAT_BENCH_WITH_RACK -> FlatBenchWithRack
        EquipmentEnum.INCLINE_BENCH_WITH_RACK -> InclineBenchWithRack
        EquipmentEnum.DECLINE_BENCH_WITH_RACK -> DeclineBenchWithRack
        EquipmentEnum.SQUAT_RACK -> SquatRack
        EquipmentEnum.PREACHER_CURL_BENCH -> PreacherCurlBench
        EquipmentEnum.ROW_BENCH -> RowBench
        EquipmentEnum.LEG_PRESS_MACHINE -> LegPressMachine
        EquipmentEnum.UNKNOWN -> null
    }
}