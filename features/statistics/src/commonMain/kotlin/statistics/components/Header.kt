package statistics.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import components.ShadowDivider
import components.inputs.InputSearch
import controls.TextFieldH1
import kotlinx.collections.immutable.ImmutableList
import platformTopInset

@Composable
internal fun Header(
    query: () -> String,
    search: (String) -> Unit,
    removeNameOption: (String) -> Unit,
    nameOptions: ImmutableList<String>,
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

    Column(
        modifier = Modifier
            .background(Design.colors.secondary)
            .platformTopInset(),
    ) {

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        Box(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {

            TextFieldH1(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                provideText = { "Statistics" },
                softWrap = false
            )
        }

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

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

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        ShadowDivider()
    }
}