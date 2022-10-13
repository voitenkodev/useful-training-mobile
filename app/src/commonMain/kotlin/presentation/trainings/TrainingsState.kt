package presentation.trainings

import Action
import GlobalState
import ReducerForActionType
import ReduxGroups
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.TrainingState

@Serializable
@Parcelize
data class TrainingsState(
    val trainings: List<TrainingState> = emptyList()
) : Parcelable

sealed class TrainingsAction(action: String) : Action(ReduxGroups.TRAININGS, action) {

    data class GetTrainings(
        val trainings: List<TrainingState>
    ) : TrainingsAction("GET_TRAININGS_ACTION")
}

val trainingsReducer: ReducerForActionType<TrainingsState, GlobalState, TrainingsAction> = { state, _, action ->
    when (action) {
        is TrainingsAction.GetTrainings -> state.copy(trainings = action.trainings)
    }
}