package muscles.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import molecule.TextH4
import muscles.MuscleGroup

@Composable
public fun MuscleGroup(
    modifier: Modifier = Modifier,
    item: MuscleGroup,
    loadingById: String? = null,
    semiFields: ImmutableList<ComponentVisible> = persistentListOf(),
    selectMuscle: (id: String) -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {

            Image(
                modifier = Modifier
                    .height(Design.dp.componentXL)
                    .aspectRatio(1f)
                    .align(Alignment.CenterEnd),
                imageVector = item.bodyImageVector,
                contentDescription = null
            )

            Column(
                modifier = Modifier.align(Alignment.TopStart),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                TextH4(
                    modifier = Modifier.fillMaxWidth().padding(bottom = Design.dp.paddingS),
                    provideText = { item.name },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )


                item.muscles.forEach { muscle ->
                    MuscleChip(
                        loadingById = loadingById,
                        muscle = muscle,
                        selectMuscle = selectMuscle,
                        semiFields = semiFields
                    )
                }
            }
        }
    }
}