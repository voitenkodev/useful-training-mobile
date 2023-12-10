package exerciseexamples.edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.Shadow

@Composable
internal fun Footer(
    modifier: Modifier = Modifier,
    confirmEnabled: Boolean,
    loading: Boolean,
    confirmClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .navigationBarsPadding(),
    ) {

        Shadow()

        PaddingM()

        ButtonPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingM),
            text = "Confirm",
            onClick = confirmClick,
            enabled = confirmEnabled,
            loading = loading
        )

        PaddingM()
    }
}