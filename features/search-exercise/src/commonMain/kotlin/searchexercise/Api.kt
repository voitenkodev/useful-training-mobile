package searchexercise

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import searchexercise.main.SearchExerciseContent
import searchexercise.main.SearchExerciseViewModel


@Parcelize
public sealed class SearchExerciseFeature : Parcelable {
    public data object Main : SearchExerciseFeature()
}

@Composable
public fun SearchExerciseGraph(close: () -> Unit) {

    val router: Router<SearchExerciseFeature> = rememberRouter(SearchExerciseFeature::class) {
        listOf(SearchExerciseFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(fade())) { child ->
        when (child) {
            is SearchExerciseFeature.Main -> {
                val api = SearchExerciseController.api
                val vm = rememberOnRoute(SearchExerciseViewModel::class) { SearchExerciseViewModel() }
                SearchExerciseContent(vm = vm, select = { api.select(it); close.invoke() }, close = close)
            }
        }
    }
}