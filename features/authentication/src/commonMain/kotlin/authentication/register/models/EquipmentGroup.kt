package authentication.register.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class EquipmentGroup(
    val id: String,
    val name: String = "",
    val equipments: ImmutableList<Equipment>
)