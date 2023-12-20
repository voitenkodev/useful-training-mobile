package searchexercise.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.inputs.InputSearch
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    query: String,
    setQuery: (String) -> Unit,
    close: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Exercises", icon = Icons.close to close)

        PaddingS()

        InputSearch(provideName = { query }, update = setQuery,)

        PaddingM()

        Shadow()
    }
}