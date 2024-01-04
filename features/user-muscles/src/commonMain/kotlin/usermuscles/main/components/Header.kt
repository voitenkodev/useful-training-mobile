package usermuscles.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.labels.NoteLabel
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.Toolbar

@Composable
internal fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Muscles")

        PaddingS()

        NoteLabel(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
            text = "Choose the muscles you wish to exclude from your workouts.",
            color = Design.colors.orange
        )

        PaddingM()

        Shadow()
    }
}