package usermuscles.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingS
import molecule.Shadow
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(close: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Target Muscles", icon = Icons.close to close)

        Shadow()
    }
}