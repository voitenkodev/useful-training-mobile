package usermuscles.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingL
import molecule.PaddingXS
import molecule.TextBody1
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    close: () -> Unit
) {
    Column(modifier = modifier.statusBarsPadding()) {

        Toolbar(
            title = "Muscles",
            icon = Icons.close to close
        )

        PaddingXS()

        TextBody1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { "You may to exclude muscles you don't want to train with!" },
            color = Design.colors.label
        )

        PaddingL()
    }
}