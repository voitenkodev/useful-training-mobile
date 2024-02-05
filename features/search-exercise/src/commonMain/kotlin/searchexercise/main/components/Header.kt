package searchexercise.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import atom.Design
import components.inputs.InputSearch
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    autoFocus: Boolean,
    query: String,
    setQuery: (String) -> Unit,
    openFilters: () -> Unit,
    close: () -> Unit
) {

    val inputRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        if (autoFocus) {
            inputRequester.requestFocus()
        }
    }

    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Exercises", icon = Icons.close to close)

        PaddingS()

        Row(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            InputSearch(
                modifier = Modifier.weight(1f).focusRequester(inputRequester),
                provideName = { query },
                update = setQuery
            )

            ButtonIconTransparent(
                imageVector = Icons.filters,
                contentColor = Design.colors.content,
                onClick = {
                    inputRequester.freeFocus()
                    openFilters.invoke()
                }
            )
        }

        PaddingM()

        Shadow()
    }
}