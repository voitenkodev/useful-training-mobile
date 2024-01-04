package components.labels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import molecule.Icon
import resources.Icons

@Composable
public fun NoteLabel(
    modifier: Modifier = Modifier,
    color: Color = Design.colors.yellow,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(shape = Design.shape.small, color = Design.colors.white10)
            .padding(Design.dp.paddingM)
            .defaultMinSize(minHeight = Design.dp.componentS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.size(Design.dp.componentXS),
            imageVector = Icons.note,
            color = color
        )

        Column(modifier = Modifier.weight(1f), content = content)

        Spacer(modifier = Modifier.size(Design.dp.paddingM))
    }
}