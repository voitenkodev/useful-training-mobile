package exerciseexamplebuilder.main.models

import androidx.compose.runtime.Immutable
import exercise.ResourceTypeEnum

@Immutable
internal data class ResourceTypeFilter(
    val value: ResourceTypeEnum,
    val isSelected: Boolean
)