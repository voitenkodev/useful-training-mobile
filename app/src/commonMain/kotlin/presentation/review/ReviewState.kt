package presentation.review

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.TrainingState
import Action
import GlobalState
import ReducerForActionType
import ReduxGroups

@Serializable
@Parcelize
data class ReviewState(
    val reviewTraining: TrainingState = TrainingState(),
    val compareTraining: TrainingState? = null,
    val otherTrainings: List<TrainingState> = emptyList()
) : Parcelable

sealed class ReviewAction(action: String) : Action(ReduxGroups.REVIEW, action) {

    data class FetchTrainings(
        val selected: TrainingState
    ) : ReviewAction("GET_TRAINING_ACTION")

    data class CompareTrainings(
        val training: TrainingState? = null,
    ) : ReviewAction("COMPARE_TRAINING_ACTION")
}

val reviewReducer: ReducerForActionType<ReviewState, GlobalState, ReviewAction> = { state, globalState, action ->
    when (action) {
        is ReviewAction.FetchTrainings -> state.copy(
            reviewTraining = action.selected,
            otherTrainings = globalState.trainingsState.trainings.filterNot { action.selected.id == it.id }
        )

        is ReviewAction.CompareTrainings -> state.copy(compareTraining = action.training)
    }
}