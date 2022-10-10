package redux

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import org.reduxkotlin.ReducerForActionType

@Serializable
@Parcelize
data class ReviewState(
    val reviewTraining: TrainingState = TrainingState(),
    val compareTraining: TrainingState? = null,
    val otherTrainings: List<TrainingState> = emptyList()
) : Parcelable

sealed class ReviewAction(action: String) : Action(ReduxGroups.REVIEW, action) {

    data class GetTrainings(
        val selected: TrainingState,
        val all: List<TrainingState>
    ) : ReviewAction("GET_TRAINING_ACTION")

    data class CompareTrainings(
        val training: TrainingState? = null,
    ) : ReviewAction("GET_TRAINING_ACTION")
}

val reviewReducer: ReducerForActionType<ReviewState, ReviewAction> = { state, action ->
    when (action) {
        is ReviewAction.GetTrainings -> state.copy(
            reviewTraining = action.selected,
            otherTrainings = action.all.filterNot { action.selected.id == it.id }
        )

        is ReviewAction.CompareTrainings -> state.copy(compareTraining = action.training)
    }
}