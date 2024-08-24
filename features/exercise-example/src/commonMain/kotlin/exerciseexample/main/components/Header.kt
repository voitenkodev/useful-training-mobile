package exerciseexample.main.components

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import atom.Design
import exercise.ExerciseExample
import molecule.PaddingM
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody1
import molecule.TextBody4
import molecule.TextH2
import resources.Icons

@Composable
internal fun Header(exerciseExample: ExerciseExample?) {
    Box(modifier = Modifier.height(IntrinsicSize.Min)) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = exerciseExample?.imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(modifier = Modifier.statusBarsPadding()) {

            PaddingXL()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { exerciseExample?.name },
            )

            PaddingM()

            TextBody1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { exerciseExample?.description?.take(150).plus("...") }
            )

            PaddingM()

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM)) {

                Column(modifier = Modifier.weight(1f)) {
                    Item(
                        title = "Category:",
                        value = exerciseExample?.category?.name ?: "-",
                        icon = Icons.weight
                    )

                    Item(
                        title = "Force Type:",
                        value = exerciseExample?.forceType?.name ?: "-",
                        icon = Icons.equipment
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Item(
                        title = "Weight Type:",
                        value = exerciseExample?.weightType?.name ?: "-",
                        icon = Icons.time
                    )

                    Item(
                        title = "Level:",
                        value = exerciseExample?.experience?.name ?: "-",
                        icon = Icons.time
                    )
                }
            }

            PaddingXL()
        }

        Shadow(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun Item(
    title: String,
    value: String,
    icon: ImageVector
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {
        TextBody4(
            provideText = { title },
            color = Design.colors.label
        )
        TextBody4(
            provideText = { value },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )
    }
}