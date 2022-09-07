package ui.designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.designsystem.common.DesignComponent

@Composable
fun ChipPrimary(
    text: String,
    onClick: (String) -> Unit,
    onDelete: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick.invoke(text) }
            .background(color = DesignComponent.colors.special2, shape = CircleShape)
            .padding(horizontal = 12.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextFieldBody2(
            text = text,
            color = DesignComponent.colors.primary
        )
    }
}