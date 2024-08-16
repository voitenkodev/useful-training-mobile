package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody1
import molecule.TextH1
import muscles.MuscleGroup
import muscles.component.MuscleGroup
import resources.Icons

@Composable
internal fun ExcludeMusclePage(
    muscles: ImmutableList<MuscleGroup>,
    selectMuscle: (id: String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

            item(key = "header") {

                PaddingL()

                TextH1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "Exclude muscles" },
                )

                PaddingXS()

                TextBody1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = {
                        "Would you like to exclude some muscles\n" +
                                "from your workouts?"
                    },
                    color = Design.colors.label
                )

                PaddingXXL()
            }

            itemsIndexed(muscles, key = { _, item -> item.id }) { index, item ->

                MuscleGroup(
                    item = item,
                    selectMuscle = selectMuscle
                )
            }
        }

        PaddingL()

        BottomButtons(
            modifier = Modifier.fillMaxWidth(),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    text = "Back",
                    leadingIcon = Icons.arrowLeft,
                    onClick = back
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    trailingIcon = Icons.arrowRight,
                    text = "Next",
                    onClick = confirm,
                )
            }
        )
    }
}
