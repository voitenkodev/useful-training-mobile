package components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import molecule.Icon
import molecule.PaddingM
import molecule.TextBody4
import molecule.TextH3

@Composable
public fun ValueCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    label: String,
    value: String,
    trailingContent: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .clip(
                shape = Design.shape.large
            ).background(
                color = Design.colors.secondary,
            ).padding(
                horizontal = Design.dp.paddingM,
                vertical = Design.dp.paddingM,
            )
    ) {
        Icon(
            modifier = Modifier
                .clip(
                    shape = Design.shape.default
                ).background(
                    color = Design.colors.tertiary
                ).padding(
                    all = Design.dp.paddingS
                ).size(
                    size = Design.dp.iconL
                ),
            imageVector = icon,
            color = Design.colors.content
        )

        PaddingM()

        TextBody4(
            provideText = { title.uppercase() },
            color = Design.colors.content,
            maxLines = 1
        )

        PaddingM()

        TextH3(
            provideText = { value.uppercase() },
            color = Design.colors.content,
            maxLines = 1
        )

        TextBody4(
            provideText = { label },
            color = Design.colors.label,
            maxLines = 1
        )
    }
}

