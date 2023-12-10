package trainingbuilder.muscle_picker.components

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
import molecule.ButtonIconTransparent
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.Shadow
import molecule.TextH2
import platformTopInset
import resources.Icons

@Composable
internal fun Header(
    close: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Design.colors.secondary)
            .platformTopInset()
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
                provideText = { "Target Muscles" },
                softWrap = false
            )


            PaddingWeight()

            ButtonIconTransparent(
                imageVector = Icons.close,
                contentColor = Design.colors.content,
                onClick = close
            )
        }

        Shadow()
    }
}