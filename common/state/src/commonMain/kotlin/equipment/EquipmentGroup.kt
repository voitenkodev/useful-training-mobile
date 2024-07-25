package equipment

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
public data class EquipmentGroup(
    val id: String,
    val name: String = "",
    val equipments: ImmutableList<Equipment>
)