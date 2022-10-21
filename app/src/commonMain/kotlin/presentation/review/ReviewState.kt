package presentation.review

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
data class ReviewState(
    val reviewTraining: Training = Training(),
    val compareTraining: Training? = null,
    val otherTrainings: List<Training> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

sealed class ReviewAction : Action(ReduxGroups.REVIEW) {

    data class FetchTrainings(val selected: Training) : ReviewAction()

    data class CompareTrainings(val training: Training? = null) : ReviewAction()

    data class Error(val message: String? = null) : ReviewAction()

    data class Loading(val value: Boolean) : ReviewAction()
}

val reviewReducer: ReducerForActionType<ReviewState, GlobalState, ReviewAction> = { state, globalState, action ->
    when (action) {
        is ReviewAction.FetchTrainings -> state.copy(
            reviewTraining = action.selected,
            otherTrainings = globalState.trainingsState.trainings.filterNot { action.selected.id == it.id },
            compareTraining = null
        )
        is ReviewAction.CompareTrainings -> state.copy(compareTraining = action.training)
        is ReviewAction.Error -> state.copy(error = action.message)
        is ReviewAction.Loading -> state.copy(loading = action.value)
    }
}