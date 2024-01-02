package weighthistory.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.overlay.TopShadow
import molecule.PaddingS
import molecule.Toolbar

@Composable
internal fun Header() {

    Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {

        TopShadow(modifier = Modifier.fillMaxSize())

        Column(modifier = Modifier.statusBarsPadding()) {

            PaddingS()

            Toolbar(title = "Weight History")
        }
    }
}