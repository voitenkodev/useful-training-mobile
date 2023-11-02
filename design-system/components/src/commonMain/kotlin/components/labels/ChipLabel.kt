package components.labels

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import molecular.molecule.ButtonIconSecondary
import molecular.molecule.TextBody1
import molecular.molecule.secondaryDefaultBackground

@Composable
public fun ChipLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String,
    onClick: (String) -> Unit,
    remove: (String) -> Unit
) {
    val txt by rememberUpdatedState(provideText())

    Row(
        modifier = Modifier
            .background(color = Design.colors.white10, shape = CircleShape)
            .secondaryDefaultBackground()
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextBody1(
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true),
                    onClick = { onClick.invoke(txt) }
                ),
            provideText = provideText,
            color = Design.colors.content.copy(alpha = 0.5f),
            fontWeight = FontWeight.Bold
        )

        ButtonIconSecondary(
            imageVector = Icons.Default.Clear,
            onClick = { remove.invoke(txt) }
        )
    }
}