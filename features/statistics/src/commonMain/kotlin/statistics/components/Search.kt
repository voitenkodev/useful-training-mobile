package statistics.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import components.inputs.InputSearch
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingS

@Composable
internal fun Search(
    query: () -> String,
    search: (String) -> Unit,
    removeNameOption: (String) -> Unit,
    nameOptions: ImmutableList<String>
) {
    val queryProvide = rememberUpdatedState(query())

    val focusManager = LocalFocusManager.current
    val helpVisible = remember { mutableStateOf(false) }
    val selectExerciseNameProvider by remember {
        mutableStateOf(
            { s: String ->
                search.invoke(s)
                focusManager.clearFocus()
            }
        )
    }

    Column {

        InputSearch(
            modifier = Modifier
                .padding(horizontal = Design.dp.paddingM)
                .onFocusChanged { helpVisible.value = it.hasFocus },
            value = query,
            onValueChange = search
        )

        ExerciseNameList(
            querySort = queryProvide.value,
            visible = helpVisible.value,
            select = selectExerciseNameProvider,
            remove = removeNameOption,
            options = nameOptions
        )

        PaddingS()
    }
}
