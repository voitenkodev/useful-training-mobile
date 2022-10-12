import co.touchlab.kermit.Logger
import org.reduxkotlin.Reducer
import org.reduxkotlin.Store
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore
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
    val navigatorState: NavigatorState = NavigatorState(),
    val authState: AuthState = AuthState(),
    val trainingState: TrainingState = TrainingState(),
    val trainingsState: TrainingsState = TrainingsState(),
    val reviewState: ReviewState = ReviewState(),
)

abstract class Action(val group: ReduxGroups, val action: String)

enum class ReduxGroups { NAVIGATOR, AUTH, TRAINING, TRAININGS, REVIEW }

val globalReducer: Reducer<GlobalState> = { state, action ->
    when (action) {
        is AuthAction -> state.copy(authState = authReducer(state.authState, action))
        is TrainingAction -> state.copy(trainingState = trainingReducer(state.trainingState, action))
        is TrainingsAction -> state.copy(trainingsState = trainingsReducer(state.trainingsState, action))
        is ReviewAction -> state.copy(reviewState = reviewReducer(state.reviewState, action))
        is NavigatorAction -> state.copy(navigatorState = navigatorReducer(state.navigatorState, action))
        else -> state
    }
}

val store: Store<GlobalState> = createStore(
    globalReducer,
    GlobalState(),
    applyMiddleware(createMiddleware<Action, GlobalState> { action ->
        Logger.i { "reduxLogger::DISPATCHED => \"${action.group}/${action.action}\"" }
    })
)
