package presentation.review

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Training
import Action
import GlobalState
import ReducerForActionType
import ReduxGroups
import presentation.auth.AuthAction

@Serializable
@Parcelize
data class ReviewState(
    val reviewTraining: Training = Training(),
    val compareTraining: Training? = null,
    val otherTrainings: List<Training> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

sealed class ReviewAction(action: String) : Action(ReduxGroups.REVIEW, action) {

    data class FetchTrainings(
        val selected: Training
    ) : ReviewAction("GET_TRAINING_ACTION")

    data class CompareTrainings(
        val training: Training? = null,
    ) : ReviewAction("COMPARE_TRAINING_ACTION")

    data class Error(val message: String? = null) : ReviewAction("ERROR_ACTION")
    data class Loading(val value: Boolean) : ReviewAction("LOADING_ACTION")
}

val reviewReducer: ReducerForActionType<ReviewState, GlobalState, ReviewAction> = { state, globalState, action ->
    when (action) {
        is ReviewAction.FetchTrainings -> state.copy(
            reviewTraining = action.selected,
            otherTrainings = globalState.trainingsState.trainings.filterNot { action.selected.id == it.id }
        )

        is ReviewAction.CompareTrainings -> state.copy(compareTraining = action.training)
        is ReviewAction.Error -> state.copy(error = action.message)
        is ReviewAction.Loading -> state.copy(loading = action.value)
    }
}