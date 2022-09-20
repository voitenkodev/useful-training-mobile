package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody1
import designsystem.controls.TextFieldH1

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
fun Title(modifier: Modifier = Modifier, text: String) = TextFieldH1(
    modifier = modifier.padding(top = 44.dp),
    text = text,
)

@Composable
fun InputLabel(modifier: Modifier = Modifier, text: String) = TextFieldBody1(
    modifier = modifier.defaultMinSize(minWidth = 66.dp),
    text = text,
    color = DesignComponent.colors.caption
)
