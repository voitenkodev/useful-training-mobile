package trainings

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import trainings.main.TrainingsContent
import trainings.main.TrainingsViewModel

@Parcelize
public sealed class TrainingsRouter : Parcelable {
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
                    toNewTraining = { toTrainingBuilder.invoke(null) },
                    addTrainingWithTemplate = { id -> toTrainingDetails.invoke(id) },
                    back = router::pop
                )
            }
        }
    }
}
