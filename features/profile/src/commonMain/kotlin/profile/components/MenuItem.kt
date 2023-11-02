package profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import icons.ArrowRight
import icons.Weight
import molecule.IconSecondary
import molecule.TextBody1

@Composable
public fun MenuItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick
            ).height(36.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconSecondary(
            imageVector = Weight
        )

        TextBody1(
            provideText = { text }
        )

        Spacer(Modifier.weight(1f))

        IconSecondary(
            imageVector = ArrowRight,
            modifier = Modifier
        )
    }
}