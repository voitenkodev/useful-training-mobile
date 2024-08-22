package trainingbuilder.training.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.cards.HorizontalValueCard
import kg
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextH2
import resources.Icons
import trainingbuilder.training.components.timer.TimerComponent

@Composable
internal fun Header(
    finish: () -> Unit,
    finishEnabled: Boolean,
    startDateMillis: Long,
    volume: Double,
) {
    Column(modifier = Modifier.statusBarsPadding()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Design.dp.paddingL,
                    end = Design.dp.paddingL
                )
                .height(Design.dp.componentS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextH2(
                provideText = { "Training" },
                softWrap = false
            )

            PaddingWeight()

            ButtonPrimary(
                text = "Finish",
                onClick = finish,
                enabled = finishEnabled
            )
        }

        PaddingM()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingL),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            HorizontalValueCard(
                modifier = Modifier.weight(1f).wrapContentHeight(),
                title = "Volume",
                value = volume.kg(true),
                icon = Icons.handWeight,
            )

            TimerComponent(
                initialMillis = startDateMillis,
                content = { duration ->
                    HorizontalValueCard(
                        modifier = Modifier.weight(1f).wrapContentHeight(),
                        title = "Duration",
                        value = duration,
                        icon = Icons.time,
                    )
                }
            )
        }

        PaddingS()
    }
}