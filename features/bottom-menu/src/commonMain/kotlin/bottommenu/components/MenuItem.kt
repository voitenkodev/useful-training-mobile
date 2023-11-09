package bottommenu.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonIconSecondary
import molecule.coloredDefaultBackgroundNoBorder

@Composable
internal fun MenuItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {

    val background =
        if (isSelected) Design.colors.black30
        else Color.Transparent

    val iconColor =
        if (isSelected) Design.colors.content
        else Design.colors.caption

    Box(
        modifier = modifier
            .fillMaxHeight()
            .coloredDefaultBackgroundNoBorder(color = background)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            ButtonIconSecondary(
                modifier = Modifier.size(26.dp),
                imageVector = if (isSelected) icon else icon,
                onClick = onClick,
                color = iconColor
            )
        }
    }
}