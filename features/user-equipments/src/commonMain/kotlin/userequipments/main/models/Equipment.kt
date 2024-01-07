package userequipments.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class Equipment(
    val id: String,
    val name: String,
    val loading: Boolean,
    val imageUrl: String,
    val status: StatusEnum
)

