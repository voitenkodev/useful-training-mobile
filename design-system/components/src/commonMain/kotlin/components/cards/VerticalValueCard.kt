package components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import molecule.Icon
import molecule.PaddingS
import molecule.TextBody3
import molecule.TextH3
import molecule.secondaryDefaultBackground

@Composable
public fun VerticalValueCard(
    modifier: Modifier = Modifier,
    title: Pair<String, Color>,
    description: Pair<String, Color>,
    icon: ImageVector
) {
    Column(
        modifier = modifier
            .aspectRatio(0.8f)
            .secondaryDefaultBackground()
            .padding(Design.dp.paddingM),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier.weight(1f).aspectRatio(1f).padding(Design.dp.paddingXS),
            color = Design.colors.content,
            imageVector = icon
        )

        PaddingS()

        TextH3(
            textAlign = TextAlign.Center,
            provideText = { description.first },
            maxLines = 1,
            color = description.second
        )

        TextBody3(
            textAlign = TextAlign.Center,
            maxLines = 1,
            provideText = { title.first },
            color = title.second
        )
    }
}