package components.labels

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import molecule.TextBody4

@Composable
public fun InputLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String,
    color: Color = Design.colors.caption,
    textAlign: TextAlign? = null
) {
    TextBody4(
        modifier = modifier.padding(
            start = Design.dp.paddingXS,
            bottom = Design.dp.paddingXS,
            top = Design.dp.paddingXS,
            end = Design.dp.paddingS
        ),
        fontWeight = FontWeight.Medium,
        provideText = provideText,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign
    )
}