package exerciseexample.main.mapping

import equipment.Equipment
import equipment.mapping.toState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

internal fun List<models.Equipment>.toState(): ImmutableList<Equipment> {
    return mapNotNull {
        it.toState()
    }.toPersistentList()
}