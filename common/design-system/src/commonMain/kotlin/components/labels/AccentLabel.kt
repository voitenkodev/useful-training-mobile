package components.labels

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import recomposeHighlighter

@Composable
public fun AccentLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String,
    backgroundColor: Color = Design.colors.accent_primary
) {

    TextFieldBody1(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = Design.shape.circleShape
            ).padding(horizontal = 8.dp, vertical = 4.dp)
            .recomposeHighlighter(),
        provideText = provideText,
        fontWeight = FontWeight.Bold
    )
}