package design.components.labels

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody1

@Composable
fun ChipLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String,
    onClick: (String) -> Unit
) {
    val txt by rememberUpdatedState(provideText())

    TextFieldBody1(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true),
                onClick = { onClick.invoke(txt) }
            ),
        provideText = provideText,
        color = Design.colors.content.copy(alpha = 0.5f),
        fontWeight = FontWeight.Bold
    )
}