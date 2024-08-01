package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.TextBody2
import molecule.TextH4

@Composable
public fun EmptyData(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Design.dp.paddingXL)
            .height(130.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingXS, Alignment.CenterVertically)
    ) {
        TextH4(
            textAlign = TextAlign.Center,
            provideText = { title },
            color = Design.colors.caption,
        )

        TextBody2(
            textAlign = TextAlign.Center,
            provideText = { description },
            color = Design.colors.caption,
        )
    }
}