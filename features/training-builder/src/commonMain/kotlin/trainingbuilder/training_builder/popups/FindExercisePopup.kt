package trainingbuilder.training_builder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.inputs.InputSearch
import components.roots.PopupRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import molecule.ButtonSecondary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.SmallToolbar
import resources.Icons
import trainingbuilder.training_builder.popups.components.ExerciseExamples
import trainingbuilder.training_builder.popups.components.Muscles
import trainingbuilder.training_builder.state.ExerciseExample
import trainingbuilder.training_builder.state.Muscle

@Composable
internal fun FindExercisePopup(
    close: () -> Unit,
    loading: Boolean,
    selectedMuscle: Muscle?,
    muscles: ImmutableList<Muscle>,
    exerciseExamples: ImmutableList<ExerciseExample>,
    setMuscleTarget: (id: String) -> Unit,
    createExercise: () -> Unit,
    selectExercise: (ExerciseExample) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,
    search: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    PopupRoot {

        PaddingS()

        SmallToolbar(
            title = "Find Exercise",
            icon = Icons.close to close
        )

        Shadow()

        PaddingM()

        InputSearch(
            provideName = { "" },
            update = {},
            onClick = {
                coroutineScope.launch {
                    close.invoke()
                    delay(POPUP_ANIM_DURATION_MS)
                    search.invoke()
                }
            }
        )

        PaddingM()

        if (muscles.isNotEmpty()) {

            Muscles(
                list = muscles,
                setMuscleTarget = setMuscleTarget,
                selectedMuscle = selectedMuscle
            )

            PaddingL()
        }

        ExerciseExamples(
            list = exerciseExamples,
            loading = loading,
            select = {
                coroutineScope.launch {
                    close.invoke()
                    delay(POPUP_ANIM_DURATION_MS)
                    selectExercise.invoke(it)
                }
            },
            details = {
                toExerciseExampleDetails
            }
        )

        PaddingM()

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "Create by own",
                onClick = {
                    coroutineScope.launch {
                        close.invoke()
                        delay(POPUP_ANIM_DURATION_MS)
                        createExercise.invoke()
                    }
                }
            )
        }
    }
}
