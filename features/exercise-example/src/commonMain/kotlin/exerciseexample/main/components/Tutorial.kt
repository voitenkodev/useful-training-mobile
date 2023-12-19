package exerciseexample.main.components

import VideoPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.TextLabel
import molecule.secondaryDefaultBackground

@Composable
internal fun Tutorial(
    url: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Video tutorial" })

        VideoPlayer(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .secondaryDefaultBackground(),
            url = url
        )
    }
}