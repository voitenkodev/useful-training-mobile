package configurations.popups

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import molecular.TextH4

@Composable
internal fun ColumnScope.SetNewMusclePopup() {
    TextH4(
        provideText = { "Add new muscle" }
    )


}