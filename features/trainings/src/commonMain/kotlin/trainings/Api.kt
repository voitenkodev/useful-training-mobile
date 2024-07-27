package trainings

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import trainings.main.TrainingsContent
import trainings.main.TrainingsViewModel

@Serializable
public sealed class TrainingsRouter {
    @Serializable
    public data object Main : TrainingsRouter()
}

@Composable
public fun TrainingsGraph(
    toTrainingBuilder: (id: String?) -> Unit,
    toTrainingDetails: (id: String) -> Unit,
) {

    val router: Router<TrainingsRouter> = rememberRouter(TrainingsRouter::class) {
        listOf(TrainingsRouter.Main)
    }

    RoutedContent(router = router) { child ->
        when (child) {
            TrainingsRouter.Main -> {

                val vm = rememberOnRoute(TrainingsViewModel::class) {
                    TrainingsViewModel()
                }

                TrainingsContent(
                    vm = vm,
                    toTrainingById = { id -> toTrainingBuilder.invoke(id) },
                    toNewTraining = { toTrainingBuilder.invoke(null) }
                )
            }
        }
    }
}
