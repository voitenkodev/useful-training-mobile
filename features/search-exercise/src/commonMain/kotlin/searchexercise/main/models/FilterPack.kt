package searchexercise.main.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class FilterPack(
    val categories: ImmutableList<Filter> = persistentListOf(),
    val experiences: ImmutableList<Filter> = persistentListOf(),
    val weightTypes: ImmutableList<Filter> = persistentListOf(),
    val forceTypes: ImmutableList<Filter> = persistentListOf()
)