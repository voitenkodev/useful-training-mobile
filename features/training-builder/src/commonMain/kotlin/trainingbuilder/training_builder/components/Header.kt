package trainingbuilder.training_builder.components

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
import molecule.ButtonPrimarySmall
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.Shadow
import molecule.TextH2
import platformTopInset

@Composable
internal fun Header(
    finish: () -> Unit,
    loading: Boolean,
    finishEnabled: Boolean
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
                provideText = { "Training" },
                softWrap = false
            )

            PaddingWeight()

            ButtonPrimarySmall(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                text = "Finish",
                onClick = finish,
                loading = loading,
                enabled = finishEnabled
            )
        }

        PaddingS()

        Shadow()
    }
}