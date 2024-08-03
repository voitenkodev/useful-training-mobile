package userequipments.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.labels.NoteLabel
import molecule.IconImage
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody3
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    close: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Equipment", icon = Icons.close to close)

        PaddingS()

        NoteLabel(modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM)) {

            TextBody3(provideText = { "Choose the equipment you do not have." })

            PaddingS()

            Row(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    content = {
                        IconImage(modifier = Modifier.size(20.dp), imageVector = Icons.checkOn)
                        TextBody3(provideText = { "Included" })
                    }
                )

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    content = {
                        IconImage(modifier = Modifier.size(20.dp), imageVector = Icons.redCircle)
                        TextBody3(provideText = { "Excluded" })
                    }
                )
            }
        }

        PaddingM()

        Shadow()
    }
}