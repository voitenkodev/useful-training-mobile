package searchexercise

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import searchexercise.main.SearchExerciseContent
import searchexercise.main.SearchExerciseViewModel

@Serializable
public sealed class SearchExerciseFeature {
    public data object Main : SearchExerciseFeature()
}

@Composable
public fun SearchExerciseGraph(
    autoFocus: Boolean,
    close: () -> Unit,
    toDetails: (id: String) -> Unit,
    itemAction: (Pair<String, (id: String) -> Unit>)?
) {

    val router: Router<SearchExerciseFeature> = rememberRouter(SearchExerciseFeature::class) {
        listOf(SearchExerciseFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(fade())) { child ->
        when (child) {
            is SearchExerciseFeature.Main -> {
                val vm = rememberOnRoute(SearchExerciseViewModel::class) {
                    SearchExerciseViewModel()
                }

                SearchExerciseContent(
                    autoFocus = autoFocus,
                    vm = vm,
                    toDetails = toDetails,
                    itemAction = itemAction,
                    close = close
                )
            }
        }
    }
}