package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody1

@Composable
fun AccentLabel(modifier: Modifier = Modifier, text: String) = TextFieldBody1(
    modifier = modifier
        .background(
            color = DesignComponent.colors.accent_primary,
            shape = DesignComponent.shape.circleShape
        ).padding(horizontal = 8.dp, vertical = 2.dp),
    text = text,
    fontWeight = FontWeight.Bold
)

@Composable
fun InputLabel(modifier: Modifier = Modifier, text: String) = TextFieldBody1(
    modifier = modifier.width(64.dp),
    text = text,
    color = DesignComponent.colors.caption,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)
