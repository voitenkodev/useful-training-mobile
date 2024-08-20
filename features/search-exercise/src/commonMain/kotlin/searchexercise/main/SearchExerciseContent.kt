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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.cards.ExerciseCardDefault
import components.cards.ExerciseCardDefaultLoading
import components.roots.ScreenRoot
import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import molecule.PopupSheet
import searchexercise.main.components.Header
import searchexercise.main.popups.ExerciseExampleFiltersPopup
import searchexercise.main.popups.ExerciseExampleFiltersStateHolder

@Composable
internal fun SearchExerciseContent(
    vm: SearchExerciseViewModel,
    autoFocus: Boolean,
    itemAction: (Pair<String, (id: String) -> Unit>)?,
    toDetails: (id: String) -> Unit,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    if (state.filtersPopupIsVisible) PopupSheet(
        onDismiss = vm::closeFiltersPopup,
        content = { hideLambda ->
            ExerciseExampleFiltersPopup(
                close = hideLambda,
                applyFilters = vm::applyFilters,
                stateHolder = ExerciseExampleFiltersStateHolder(
                    equipments = state.filtersState.equipmentGroups,
                    filterPack = state.filtersState.filterPack,
                    muscles = state.filtersState.muscles
                )
            )
        }
    )

    Content(
        error = { state.error },
        loading = state.loading,
        clearError = vm::clearError,
        autoFocus = autoFocus,
        query = state.query,
        setQuery = vm::setQuery,
        exerciseExamples = state.exerciseExamples,
        toDetails = toDetails,
        close = close,
        openFilters = vm::openFiltersPopup,
        itemAction = itemAction
    )
}

@Composable
private fun Content(
    autoFocus: Boolean,
    error: () -> String?,
    loading: Boolean,
    openFilters: () -> Unit,
    clearError: () -> Unit,
    query: String,
    setQuery: (String) -> Unit,
    exerciseExamples: ImmutableList<ExerciseExample>,
    itemAction: (Pair<String, (id: String) -> Unit>)?,
    toDetails: (id: String) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Header(
                autoFocus = autoFocus,
                query = query,
                setQuery = setQuery,
                openFilters = openFilters,
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

                    val actionProvider = remember(itemAction) {
                        if (itemAction == null) return@remember null
                        itemAction.first to { itemAction.second.invoke(it.id) }
                    }

                    ExerciseCardDefault(
                        name = it.name,
                        imageUrl = it.imageUrl,
                        btn = actionProvider,
                        viewDetails = { toDetails.invoke(it.id) },
                        musclesWithPercent = it.exerciseExampleBundles.map { b -> b.muscle.name to b.percentage }
                    )
                }
            }
        }
    }
}