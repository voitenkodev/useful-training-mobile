package bottommenu.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import controls.IconPrimary

@Composable
internal fun MenuItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {

    val background =
        if (isSelected) Design.colors.accent_primary
        else Color.Transparent

    val textColor =
        if (isSelected) Design.colors.content
        else Color.Transparent

    val iconColor =
        if (isSelected) Design.colors.content
        else Design.colors.caption

    Box(
        modifier = modifier
            .height(Design.dp.componentM)
            .clip(shape = Design.shape.circleShape)
            .background(color = background)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            IconPrimary(
                modifier = Modifier.size(26.dp),
                imageVector = if (isSelected) icon else icon,
                onClick = onClick,
                color = iconColor
            )

//            AnimatedVisibility(visible = isSelected) {
//                TextFieldBody2(
//                    provideText = { text },
//                    color = textColor
//                )
//            }
        }
    }
}