package statistics.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import buildBoolean
import components.Error
import components.Loading
import components.roots.Root
import molecule.PopupSheet
import statistics.components.Header
import statistics.popups.FilterPopup

@Composable
internal fun StatisticsContent(vm: StatisticsViewModel) {

    val state by vm.state.collectAsState()

    PopupSheet(
        visibility = buildBoolean { addCondition(state.filterPopupIsVisible) },
        onClose = vm::closePopups,
        modifierSheet = Modifier.fillMaxSize(),
        sheetContent = {
            if (state.filterPopupIsVisible) FilterPopup(
                exerciseExamples = state.exerciseExamples,
                muscles = state.muscles,
                intervals = state.intervals,
                muscleClick = vm::setMuscleFilter,
                exerciseExampleClick = vm::setExerciseExampleFilter,
                intervalClick = vm::setIntervalFilter
            )
        },
        content = {
            Content(
                loading = { state.loading },
                error = { state.error },
                clearError = vm::clearError,
                filterClick = vm::openFilters
            )
        }
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    filterClick: () -> Unit,
    clearError: () -> Unit
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column {

            Header(filterClick = filterClick)

        }
    }
}