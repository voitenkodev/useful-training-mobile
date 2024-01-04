package components.labels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import molecule.Icon
import molecule.TextBody2
import resources.Icons

@Composable
public fun NoteLabel(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Design.colors.yellow
) {
    Row(
        modifier = modifier
            .background(
                shape = Design.shape.small,
                color = color.copy(alpha = 0.4f)
            ).padding(Design.dp.paddingM)
            .defaultMinSize(minHeight = Design.dp.componentS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.size(Design.dp.componentXS),
            imageVector = Icons.note,
            color = color
        )

        TextBody2(
            { text },
            color = Design.colors.content
        )
    }
}