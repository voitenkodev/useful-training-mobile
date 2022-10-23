package presentation.trainings

import Action
import GlobalState
import ReducerForActionType
import ReduxGroups
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Training

@Serializable
@Parcelize
data class TrainingsState(
    val trainings: List<Training> = emptyList(),
    val weekTrainings: Map<WeekInfo, List<Training>> = emptyMap(),
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

@Serializable
@Parcelize
data class WeekInfo(
    val startWeekDate: String,
    val endWeekDate: String,
    val tonnage: Double,
    val intensity: Double,
    val countOfTrainings: Int
) : Parcelable

sealed class TrainingsAction : Action(ReduxGroups.TRAININGS) {

    data class FetchTrainings(val trainings: List<Training>) : TrainingsAction()

    data class Error(val message: String? = null) : TrainingsAction()

    data class Loading(val value: Boolean) : TrainingsAction()
}

val trainingsReducer: ReducerForActionType<TrainingsState, GlobalState, TrainingsAction> = { state, _, action ->
    when (action) {
        is TrainingsAction.FetchTrainings -> state.fetchTrainings(action)
        is TrainingsAction.Error -> state.copy(error = action.message)
        is TrainingsAction.Loading -> state.copy(loading = action.value)
    }
}

private fun TrainingsState.fetchTrainings(action: TrainingsAction.FetchTrainings) = copy(
    trainings = action.trainings,
    weekTrainings = action.trainings.groupBy { it.endOfWeek }.mapKeys { item ->
        val startDate = item.value.firstOrNull()?.startOfWeek
        val endDate = item.value.firstOrNull()?.endOfWeek
        WeekInfo(
            startWeekDate = startDate ?: "",
            endWeekDate = endDate ?: "",
            tonnage = item.value.mapNotNull { it.tonnage }.sum(),
            intensity = item.value.mapNotNull { it.intensity }.sum() / item.value.size,
            countOfTrainings = item.value.size
        )
    }
)