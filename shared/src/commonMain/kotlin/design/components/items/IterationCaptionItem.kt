package design.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody2

@Composable
internal fun IterationCaptionItem() = Column(modifier = Modifier.padding(vertical = 4.dp)) {
    TextFieldBody2(
        modifier = Modifier
            .height(Design.dp.component)
            .wrapContentWidth()
            .wrapContentHeight(),
        text = "• Weight",
        textAlign = TextAlign.Center,
        color = Design.colors.caption,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        modifier = Modifier
            .height(Design.dp.component)
            .wrapContentWidth()
            .wrapContentHeight(),
        text = "• Repeat",
        color = Design.colors.caption,
        textAlign = TextAlign.Center,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )
}