package graph

import androidx.compose.runtime.Composable
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import trainingbuilder.TrainingFeature

@Parcelize
internal sealed class TrainingRouter : Parcelable {
    data class TrainingBuilder(val id: String? = null) : TrainingRouter()
}

@Composable
internal fun TrainingGraph(
    id: String? = null,
    toTrainingDetails: (id: String) -> Unit,
    closeFlow: () -> Unit
) {

    val router: Router<TrainingRouter> = rememberRouter(TrainingRouter::class) {
        listOf(TrainingRouter.TrainingBuilder(id))
    }

    RoutedContent(router = router) { child ->
        when (child) {
            is TrainingRouter.TrainingBuilder -> TrainingFeature(
                trainingId = child.id,
                toTrainingDetails = { id -> toTrainingDetails.invoke(id) },
                back = closeFlow
            )
        }
    }
}