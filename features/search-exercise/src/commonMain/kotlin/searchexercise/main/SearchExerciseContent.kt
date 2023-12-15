package searchexercise.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.brand.ExerciseCardDefault
import components.brand.ExerciseCardDefaultLoading
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.primaryBackground
import searchexercise.main.components.Header
import searchexercise.main.models.ExerciseExample

@Composable
internal fun SearchExerciseContent(
    vm: SearchExerciseViewModel,
    select: (id: String) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        loading = state.loading,
        clearError = vm::clearError,
        query = state.query,
        setQuery = vm::setQuery,
        exerciseExamples = state.exerciseExamples,
        selectExerciseExample = select,
        toExerciseExampleDetails = toExerciseExampleDetails,
        close = close
    )
}

@Composable
private fun Content(
    error: () -> String?,
    loading: Boolean,
    clearError: () -> Unit,
    query: String,
    setQuery: (String) -> Unit,
    exerciseExamples: ImmutableList<ExerciseExample>,
    selectExerciseExample: (id: String) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header(
                query = query,
                setQuery = setQuery,
                close = close
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                if (loading) repeat(3) {
                    item { ExerciseCardDefaultLoading() }
                }

                items(exerciseExamples, key = { it.id }) {
                    ExerciseCardDefault(
                        name = it.name,
                        imageUrl = it.imageUrl,
                        btn = "Select" to { selectExerciseExample.invoke(it.id) },
                        viewDetails = { toExerciseExampleDetails.invoke(it.id) },
                        musclesWithPercent = it.muscleExerciseBundles.map { b -> b.muscle.name to b.percentage }
                    )
                }
            }
        }
    }
}