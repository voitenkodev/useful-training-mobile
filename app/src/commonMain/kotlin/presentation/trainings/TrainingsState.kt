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
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

sealed class TrainingsAction : Action(ReduxGroups.TRAININGS) {

    data class FetchTrainings(val trainings: List<Training>) : TrainingsAction()

    data class Error(val message: String? = null) : TrainingsAction()

    data class Loading(val value: Boolean) : TrainingsAction()
}

val trainingsReducer: ReducerForActionType<TrainingsState, GlobalState, TrainingsAction> = { state, _, action ->
    when (action) {
        is TrainingsAction.FetchTrainings -> state.copy(trainings = action.trainings)
        is TrainingsAction.Error -> state.copy(error = action.message)
        is TrainingsAction.Loading -> state.copy(loading = action.value)
    }
}