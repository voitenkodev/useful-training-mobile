package components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH3

@Composable
public fun ActionCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    btnText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                shape = Design.shape.default,
                color = Design.colors.white10
            ).padding(Design.dp.paddingL),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextH3(
            provideText = { title },
            color = Design.colors.content
        )

        PaddingXS()

        TextBody1(
            provideText = { description },
            color = Design.colors.content
        )

        PaddingL()

        ButtonPrimary(
            modifier = Modifier.padding(horizontal = Design.dp.paddingXL),
            text = btnText,
            onClick = onClick
        )
    }
}