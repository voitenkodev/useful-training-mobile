package components.labels

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import molecule.TextBody3

@Composable
public fun InputLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String,
    textAlign: TextAlign? = null
) {
    TextBody3(
        modifier = modifier.padding(
            start = Design.dp.paddingXS,
            bottom = Design.dp.paddingXS,
            top = Design.dp.paddingXS,
            end = Design.dp.paddingS
        ),
        provideText = provideText,
        color = Design.colors.caption,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign
    )
}