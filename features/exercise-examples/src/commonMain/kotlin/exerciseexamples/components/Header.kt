package exerciseexamples.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH2
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .platformTopInset(),
    ) {

        PaddingS()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Design.dp.componentL),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Exercises" },
                softWrap = false
            )
        }

        PaddingS()

        Shadow()
    }
}