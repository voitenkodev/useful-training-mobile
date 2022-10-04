package redux

import org.reduxkotlin.Reducer

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


