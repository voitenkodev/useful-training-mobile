package statistics.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import components.Error
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.roots.ScreenRoot
import molecule.PaddingM
import resources.Icons

@Composable
internal fun StatisticsContent(vm: StatisticsViewModel) {

    val state by vm.state.collectAsState()

//    PopupSheet(
//        visibility = buildBoolean { addCondition(state.filterPopupIsVisible) },
//        onClose = vm::closePopups,
//        modifierSheet = Modifier.fillMaxSize(),
//        sheetContent = {
//            if (state.filterPopupIsVisible) FilterPopup(
//                exerciseExamples = state.exerciseExamples,
//                muscles = state.muscles,
//                intervals = state.intervals,
//                muscleClick = vm::setMuscleFilter,
//                exerciseExampleClick = vm::setExerciseExampleFilter,
//                intervalClick = vm::setIntervalFilter
//            )
//        }
//    )

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        filterClick = vm::openFilters
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    filterClick: () -> Unit,
    clearError: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column {

            ShadowHeaderSpace()
            PaddingM()

        }
    }

    ShadowHeader(
        title = "Statistics",
        icon = Icons.filters to filterClick
    )
}