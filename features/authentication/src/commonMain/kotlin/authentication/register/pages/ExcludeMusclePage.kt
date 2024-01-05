package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import authentication.register.components.MuscleGroup
import authentication.register.models.MuscleType
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody2
import molecule.TextH2
import molecule.primaryBackground

@Composable
internal fun ExcludeMusclePage(
    muscles: ImmutableList<MuscleType>,
    selectMuscle: (id: String) -> Unit,
    confirm: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().imePadding().navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        TextH2(provideText = { "Muscles" }, textAlign = TextAlign.Center)

        TextBody2(provideText = { "Would you like to exclude some muscles from you workouts?" }, textAlign = TextAlign.Center)

        PaddingXL()

        if (muscles.isNotEmpty()) LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).primaryBackground()) {

            itemsIndexed(muscles, key = { _, item -> item.id }) { index, item ->

                MuscleGroup(
                    item = item,
                    selectMuscle = selectMuscle
                )

                if (index < muscles.lastIndex) Shadow()
            }

            item("navigation_padding") {
                Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingM))
            }
        }

        PaddingM()

        ButtonPrimary(
            modifier = Modifier.width(Design.dp.componentXXL),
            text = "Continue",
            onClick = confirm
        )

        PaddingXL()
    }
}
