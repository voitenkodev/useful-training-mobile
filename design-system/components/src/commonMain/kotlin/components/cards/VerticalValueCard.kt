package components.cards

import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.Icon
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody4
import molecule.TextH3

@Composable
public fun VerticalValueCard(
    modifier: Modifier = Modifier,
    title: Pair<String, Color>,
    description: Pair<String, Color>,
    icon: ImageVector
) {
    Column(
        modifier = modifier
            .border(width = 1.dp, shape = Design.shape.default, color = Design.colors.white5)
            .padding(vertical = Design.dp.paddingS, horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .padding(horizontal = Design.dp.paddingS),
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

        PaddingXS()

        TextBody4(
            textAlign = TextAlign.Center,
            maxLines = 1,
            provideText = { title.first },
            color = title.second
        )
    }
}