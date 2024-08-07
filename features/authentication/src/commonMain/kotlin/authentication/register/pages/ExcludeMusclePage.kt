package authentication.register.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.ShadowBottomButtons
import components.ShadowFooterSpace
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.Shadow
import molecule.TextBody2
import molecule.TextH2
import muscles.MuscleGroup
import muscles.component.MuscleGroup

@Composable
internal fun ExcludeMusclePage(
    muscles: ImmutableList<MuscleGroup>,
    selectMuscle: (id: String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingL()

            TextH2(provideText = { "Muscles" }, textAlign = TextAlign.Center)

            PaddingXS()

            TextBody2(
                provideText = { "Would you like to exclude some muscles\nfrom your workouts?" },
                textAlign = TextAlign.Center,
                color = Design.colors.caption
            )

            PaddingXL()

            Shadow()

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                itemsIndexed(muscles, key = { _, item -> item.id }) { index, item ->

                    MuscleGroup(
                        item = item,
                        selectMuscle = selectMuscle
                    )

                    if (index < muscles.lastIndex) Shadow()
                }

                item("navigation_padding") {
                    ShadowFooterSpace()
                }
            }
        }

        ShadowBottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    text = "Back",
                    onClick = back
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = "Next",
                    onClick = confirm,
                )
            }
        )
    }
}
