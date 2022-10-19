import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.touchlab.kermit.Logger
import presentation.auth.AuthContent
import presentation.review.ReviewContent
import presentation.training.TrainingContent
import presentation.trainings.TrainingsContent
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit,
    content: @Composable () -> Unit
) {

    DesignTheme(modifier = modifier) {
        ReduxStoreProvider(
            globalReducer = globalReducer,
            globalState = GlobalState(),
            logging = { if (it is Action) Logger.i { "reduxLogger::DISPATCHED => \"${it.group}/${it.action}\"" } },
            content = content
        )
    }
}

fun RootComposeBuilder.generateGraph() {
    screen(name = Graph.Auth.link) {
        AuthContent()
    }

    screen(name = Graph.Review.link) {
        ReviewContent()
    }
    screen(name = Graph.Trainings.link) {
        TrainingsContent()
    }

    screen(name = Graph.Training.link) {
        TrainingContent()
    }
}

sealed class Graph(val link: String) {
    object Auth : Graph("auth_screen")

    object Trainings : Graph("trainings_screen")

    object Training : Graph("training_screen")

    object Review : Graph("review_screen")
}