package trainingbuilder.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import molecule.PaddingL
import molecule.TextBody2
import molecule.TextH2
import platformBottomInset

@Composable
internal fun ConfigurationPage() {
    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaddingL()

        TextH2(provideText = { "Goal" })

        TextBody2(provideText = { "Which muscle do you want to train?" })

        FlowColumn {

        }
    }
}