package trainingbuilder.mapping

import models.MuscleTypeEnum
import trainingbuilder.state.MuscleTypeEnumState

internal fun MuscleTypeEnum.toState(): MuscleTypeEnumState? {
    return when (this) {
        MuscleTypeEnum.CHEST_MUSCLES -> MuscleTypeEnumState.CHEST_MUSCLES
        MuscleTypeEnum.BACK_MUSCLES -> MuscleTypeEnumState.BACK_MUSCLES
        MuscleTypeEnum.ABDOMINAL_MUSCLES -> MuscleTypeEnumState.ABDOMINAL_MUSCLES
        MuscleTypeEnum.LEGS -> MuscleTypeEnumState.LEGS
        MuscleTypeEnum.ARMS_AND_FOREARMS -> MuscleTypeEnumState.ARMS_AND_FOREARMS
        MuscleTypeEnum.SHOULDER_MUSCLES -> MuscleTypeEnumState.SHOULDER_MUSCLES
        MuscleTypeEnum.UNKNOWN -> null
    }
}