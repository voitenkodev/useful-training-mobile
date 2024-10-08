package usermuscles.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import muscles.MuscleGroup
import muscles.component.MuscleGroup
import usermuscles.main.components.Header

@Composable
internal fun UserMusclesContent(vm: UserMusclesViewModel, close: () -> Unit) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        loadingById = state.loadingById,
        list = state.muscleGroups,
        clearError = vm::clearError,
        selectMuscle = vm::selectMuscle,
        close = close
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    loadingById: String? = null,
    list: ImmutableList<MuscleGroup>,
    selectMuscle: (id: String) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {

            Header(close = close)

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(
                    vertical = Design.dp.paddingL,
                    horizontal = Design.dp.paddingL
                ),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->
                    MuscleGroup(
                        item = item,
                        selectMuscle = selectMuscle,
                        loadingById = loadingById
                    )
                }
            }
        }
    }
}