package exerciseexamplebuilder.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import molecular.ButtonPrimary
import molecular.PaddingM
import molecular.Shadow
import platformBottomInset
import platformTopInset

@Composable
internal fun Footer(
    modifier: Modifier = Modifier,
    confirmEnabled: Boolean,
    confirmClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .platformBottomInset(),
    ) {

        Shadow()

        PaddingM()

        ButtonPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingM),
            text = "Confirm",
            onClick = confirmClick,
            enabled = confirmEnabled
        )

        PaddingM()
    }
}