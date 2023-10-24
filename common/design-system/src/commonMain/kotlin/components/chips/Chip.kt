package components.chips

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import conditional
import molecular.ButtonIconSecondary
import molecular.TextBody2
import molecular.secondaryCircleBackground
import molecular.transparentCircleBackground

@Composable
public fun Chip(
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .conditional(
                condition = isSelected,
                onYes = { transparentCircleBackground() },
                onNot = { secondaryCircleBackground() }
            )
            .padding(
                horizontal = Design.dp.paddingM,
                vertical = Design.dp.paddingS
            ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ButtonIconSecondary(
            modifier = Modifier.size(18.dp),
            imageVector = Icons.Default.Search
        )

        TextBody2(
            provideText = { "Some chip" }
        )
    }
}