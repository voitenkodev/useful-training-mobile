package presentation.trainings

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import org.reduxkotlin.ReducerForActionType
import Action
import ReduxGroups
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

val trainingsReducer: ReducerForActionType<TrainingsState, TrainingsAction> = { state, action ->
    when (action) {
        is TrainingsAction.GetTrainings -> state.copy(trainings = action.trainings)
    }
}