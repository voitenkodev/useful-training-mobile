package graph

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import trainings.TrainingsFeature

@Parcelize
internal sealed class TrainingsRouter : Parcelable {
    data object Tab : TrainingsRouter()
}

@Composable
internal fun TrainingsGraph(
    toTrainingBuilder: (id: String?) -> Unit,
    toTrainingDetails: (id: String) -> Unit,
) {

    val router: Router<TrainingsRouter> = rememberRouter(TrainingsRouter::class) {
        listOf(TrainingsRouter.Tab)
    }

    RoutedContent(router = router) { child ->

        when (child) {
            TrainingsRouter.Tab -> TrainingsFeature(
                toEditTraining = { id -> toTrainingBuilder.invoke(id) },
                toNewTraining = { toTrainingBuilder.invoke(null) },
                addTrainingWithTemplate = { id -> toTrainingDetails.invoke(id) },
                back = router::pop,
            )
        }
    }
}