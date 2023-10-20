package statistics.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import components.inputs.InputSearch
import components.items.HelpExerciseNameItem

@Composable
internal fun Search(
    query: () -> String,
    search: (String) -> Unit,
    removeNameOption: (String) -> Unit,
    nameOptions: () -> List<String>,
) {
    val focusManager = LocalFocusManager.current
    val helpVisible = remember { mutableStateOf(false) }
    val selectExerciseNameProvider by remember {
        mutableStateOf({ s: String ->
            search.invoke(s)
            focusManager.clearFocus()
        })
    }

    InputSearch(
        modifier = Modifier
            .onFocusChanged { helpVisible.value = it.hasFocus },
        value = query,
        onValueChange = search
    )

    HelpExerciseNameItem(
        querySort = query,
        visibility = { helpVisible.value },
        select = selectExerciseNameProvider,
        remove = removeNameOption,
        options = nameOptions
    )
}