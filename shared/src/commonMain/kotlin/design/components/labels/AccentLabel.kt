package design.components.labels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody1

@Composable
internal fun AccentLabel(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = Design.colors.accent_primary
) {
    val txt = remember(text) { text.uppercase() }

    TextFieldBody1(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = Design.shape.circleShape
            ).padding(horizontal = 8.dp, vertical = 2.dp),
        text = txt,
        fontWeight = FontWeight.Bold
    )
}