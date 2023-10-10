package components.items

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import controls.TextFieldBody2
import recomposeHighlighter

@Composable
fun IterationCaptionItem() = Column(
    modifier = Modifier
        .padding(vertical = 4.dp)
        .width(60.dp)
        .recomposeHighlighter()
) {
    TextFieldBody2(
        modifier = Modifier
            .height(Design.dp.componentM)
            .fillMaxWidth()
            .wrapContentHeight()
            .recomposeHighlighter(),
        provideText = { "Weight" },
        textAlign = TextAlign.Center,
        color = Design.colors.caption,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        modifier = Modifier
            .height(Design.dp.componentM)
            .fillMaxWidth()
            .wrapContentHeight()
            .recomposeHighlighter(),
        provideText = { "Repeat" },
        color = Design.colors.caption,
        textAlign = TextAlign.Center,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )
}