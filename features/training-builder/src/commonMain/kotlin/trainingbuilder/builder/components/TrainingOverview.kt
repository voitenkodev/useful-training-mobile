package trainingbuilder.builder.components

import Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import components.indication.HeapIndicator
import molecule.IconSecondary
import molecule.PaddingS
import molecule.TextBody3
import molecule.TextH4
import molecule.secondaryDefaultBackground
import musclepickerpicker.fullBack
import musclepickerpicker.fullFront

@Composable
internal fun TrainingOverview() {
    Row(
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingM),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                IconSecondary(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    color = Design.colors.content,
                    imageVector = Icons.time
                )

                PaddingS()

                TextH4(
                    textAlign = TextAlign.Center,
                    provideText = { "10M" }
                )

                TextBody3(
                    textAlign = TextAlign.Center,
                    provideText = { "Duration" },
                    color = Design.colors.caption
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingM),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                IconSecondary(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    color = Design.colors.content,
                    imageVector = Icons.weight
                )

                PaddingS()


                TextH4(
                    textAlign = TextAlign.Center,
                    provideText = { "14K" }
                )

                TextBody3(
                    textAlign = TextAlign.Center,
                    provideText = { "Volume" },
                    color = Design.colors.caption
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .aspectRatio(1f)
                .secondaryDefaultBackground()
                .padding(Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextH4(provideText = { "HEAP MAP" })

                HeapIndicator(modifier = Modifier.weight(1f).padding(bottom = 4.dp))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {
                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullFront(
                        backgroundFront = Design.colors.white10,
                        pectoralisMajor = Design.colors.red,
                        pectoralisMinor = Design.colors.red.copy(alpha = 0.7f),
                        biceps = Design.colors.red.copy(alpha = 0.3f),
                        forearm = Design.colors.red.copy(alpha = 0.3f),
                        anteriorDeltoid = Design.colors.red,
                        lateralDeltoid = Design.colors.red.copy(alpha = 0.7f)
                    )
                )

                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullBack(
                        backgroundBack = Design.colors.white10,
                        trapezius = Design.colors.red.copy(alpha = 0.5f),
                        latissimus = Design.colors.red.copy(alpha = 0.6f),
                        hamstrings = Design.colors.red.copy(alpha = 0.3f),
                        gluteal = Design.colors.red.copy(alpha = 0.2f)
                    )
                )
            }
        }
    }
}