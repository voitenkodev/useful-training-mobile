import presentation.auth.AuthState
import presentation.review.ReviewState
import presentation.training.TrainingState
import presentation.trainings.TrainingsState

internal data class GlobalState(
    val authState: AuthState = AuthState(),
    val trainingState: TrainingState = TrainingState(),
    val trainingsState: TrainingsState = TrainingsState(),
    val reviewState: ReviewState = ReviewState(),
)

internal abstract class Action(val group: ReduxGroups)

internal enum class ReduxGroups { AUTH, TRAINING, TRAININGS, REVIEW }

//internal val globalReducer: Reducer<GlobalState> = { state, action ->
//    when (action) {
//        is AuthAction -> state.copy(authState = authReducer(state.authState, state, action))
//        is TrainingAction -> state.copy(trainingState = trainingReducer(state.trainingState, state, action))
//        is TrainingsAction -> state.copy(trainingsState = trainingsReducer(state.trainingsState, state, action))
//        is ReviewAction -> state.copy(reviewState = reviewReducer(state.reviewState, state, action))
//        else -> state
//    }
//}