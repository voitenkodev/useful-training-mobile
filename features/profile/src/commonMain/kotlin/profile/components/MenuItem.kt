package profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import icons.ArrowRight
import molecule.IconPrimary
import molecule.PaddingWeight
import molecule.TextH4
import molecule.coloredDefaultBackgroundNoBorder

@Composable
public fun MenuItem(
    icon: ImageVector,
    text: String,
    allowRightArrow: Boolean = true,
    contentColor: Color = Design.colors.content,
    iconBackgroundColor: Color = Design.colors.white5,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = Design.dp.paddingS, horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconPrimary(
            modifier = Modifier.coloredDefaultBackgroundNoBorder(iconBackgroundColor),
            imageVector = icon,
            contentColor = contentColor
        )

        TextH4(
            provideText = { text },
            color = contentColor
        )

        PaddingWeight()

        if (allowRightArrow) IconPrimary(
            imageVector = ArrowRight,
            contentColor = contentColor
        )
    }
}