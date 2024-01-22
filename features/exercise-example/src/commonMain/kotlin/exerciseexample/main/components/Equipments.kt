package exerciseexample.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import exerciseexample.main.models.Equipment
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.TextBody2
import molecule.TextLabel

@Composable
internal fun Equipments(equipments: ImmutableList<Equipment>) {

    Column(modifier = Modifier.background(Design.colors.black10)) {

        PaddingM()

        TextLabel(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Equipments" }
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentPadding = PaddingValues(Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            items(equipments, key = { it.id }) {
                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .fillMaxHeight()
                        .border(
                            color = Design.colors.white10,
                            width = 1.dp,
                            shape = Design.shape.default
                        )
                        .clip(shape = Design.shape.default)
                        .padding(bottom = Design.dp.paddingM),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = Design.dp.paddingL, end = Design.dp.paddingL, top = Design.dp.paddingM),
                        imageVector = it.image,
                        contentScale = ContentScale.Fit,
                        contentDescription = null
                    )

                    TextBody2(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        textAlign = TextAlign.Center,
                        provideText = { it.name },
                    )
                }
            }
        }
    }
}