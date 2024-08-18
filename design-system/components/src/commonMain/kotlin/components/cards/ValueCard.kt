package components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextDecoration
import atom.Design
import molecule.ButtonText
import molecule.Icon
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody4
import molecule.TextH3

@Immutable
public data class ValueCardAction(
    val title: String,
    val onClick: () -> Unit,
    val trailingIcon: ImageVector? = null,
    val color: Color,
    val textDecoration: TextDecoration = TextDecoration.None
)

@Composable
public fun ValueCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    label: String,
    value: String,
    action: ValueCardAction? = null,
    trailingContent: (() -> Unit)? = null,
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
        Row(modifier = Modifier.fillMaxWidth()) {
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

            PaddingWeight()

            action?.let { a ->
                ButtonText(
                    text = a.title,
                    trailingIcon = a.trailingIcon,
                    onClick = a.onClick,
                    color = a.color,
                    textDecoration = a.textDecoration
                )
            }
        }


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

        trailingContent?.invoke()
    }
}

