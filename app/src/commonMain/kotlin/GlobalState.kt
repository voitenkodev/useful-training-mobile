import presentation.auth.AuthAction
import presentation.auth.AuthState
import presentation.auth.authReducer
import presentation.review.ReviewAction
import presentation.review.ReviewState
import presentation.review.reviewReducer
import presentation.training.TrainingAction
import presentation.training.TrainingState
import presentation.training.trainingReducer
import presentation.trainings.TrainingsAction
import presentation.trainings.TrainingsState
import presentation.trainings.trainingsReducer

data class GlobalState(
    val authState: AuthState = AuthState(),
    val trainingState: TrainingState = TrainingState(),
    val trainingsState: TrainingsState = TrainingsState(),
    val reviewState: ReviewState = ReviewState(),
)

abstract class Action(val group: ReduxGroups)

enum class ReduxGroups { AUTH, TRAINING, TRAININGS, REVIEW }

val globalReducer: Reducer<GlobalState> = { state, action ->
    when (action) {
        is AuthAction -> state.copy(authState = authReducer(state.authState, state, action))
        is TrainingAction -> state.copy(trainingState = trainingReducer(state.trainingState, state, action))
        is TrainingsAction -> state.copy(trainingsState = trainingsReducer(state.trainingsState, state, action))
        is ReviewAction -> state.copy(reviewState = reviewReducer(state.reviewState, state, action))
        else -> state
    }
}