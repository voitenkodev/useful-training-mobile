package components.edit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import molecule.TextBody2
import molecule.secondarySmallBackground

@Composable
public fun MutableValueSection(
    value: String,
    valueColor: Color,
    editValue: () -> Unit
) {
    Row(
        modifier = Modifier.secondarySmallBackground(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody2(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { value },
            color = valueColor
        )

        Chip(
            chipState = ChipState.Colored(
                backgroundColor = Design.colors.orange,
                borderColor = Design.colors.orange,
                contentColor = Design.colors.content
            ),
            text = "Change",
            onClick = editValue
        )
    }
}