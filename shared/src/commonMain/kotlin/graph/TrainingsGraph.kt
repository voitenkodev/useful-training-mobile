package graph

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import trainingbuilder.TrainingFeature
import trainings.TrainingsFeature

@Parcelize
internal sealed class TrainingsRouter : Parcelable {
    data object Tab : TrainingsRouter()
    data class Training(val id: String? = null) : TrainingsRouter()
}

@Composable
internal fun TrainingsGraph() {

    val router: Router<TrainingsRouter> = rememberRouter(TrainingsRouter::class) {
        listOf(TrainingsRouter.Tab)
    }

    RoutedContent(
        router = router,
    ) { child ->

        when (child) {
            TrainingsRouter.Tab -> TrainingsFeature(
                toTrainingById = { },
                toNewTraining = { router.push(TrainingsRouter.Training(null)) },
                addTrainingWithTemplate = { id -> router.push(TrainingsRouter.Training(id)) },
                back = router::pop,
            )

            is TrainingsRouter.Training -> TrainingFeature(
                trainingId = child.id,
                toReview = { router.replaceAll(TrainingsRouter.Tab) },
                back = router::pop
            )
        }
    }
}