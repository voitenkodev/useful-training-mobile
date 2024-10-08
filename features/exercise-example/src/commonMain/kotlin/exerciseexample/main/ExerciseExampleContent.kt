package exerciseexample.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import components.Error
import components.ShadowFooterSpace
import components.roots.ScreenRoot
import exercise.ExerciseExample
import exercise.Tutorial
import exerciseexample.main.components.Achievements
import exerciseexample.main.components.Equipments
import exerciseexample.main.components.Header
import exerciseexample.main.components.HeapMap
import exerciseexample.main.components.MusclePack
import exerciseexample.main.components.ResentVolume
import exerciseexample.main.components.Tutorial
import exerciseexample.main.models.ExerciseExampleAchievements
import molecule.PaddingM
import molecule.PaddingXL

@Composable
internal fun ExerciseExampleContent(
    vm: ExerciseExampleViewModel,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        close = close,
        error = { state.error },
        clearError = vm::clearError,
        primaryAction = primaryAction,
        achievements = state.achievements,
        exerciseExample = state.exerciseExample,
        fullFrontImage = state.fullFrontImageVector,
        fullBackImage = state.fullBackImageVector,
        selectTutorial = vm::selectTutorial
    )
}

@Composable
private fun Content(
    close: () -> Unit,
    error: () -> String?,
    clearError: () -> Unit,
    selectTutorial: (Tutorial) -> Unit,
    achievements: ExerciseExampleAchievements?,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    exerciseExample: ExerciseExample?,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            Header(exerciseExample = exerciseExample)

            if (exerciseExample?.equipments?.isNotEmpty() == true) {
                PaddingXL()

                Tutorial(
                    tutorials = exerciseExample.tutorials,
                    onClick = selectTutorial,
                )
            }

            PaddingXL()

            if (exerciseExample?.equipments?.isNotEmpty() == true) {

                Equipments(equipments = exerciseExample.equipments)
            }

            if (exerciseExample?.exerciseExampleBundles?.isNotEmpty() == true) {

                PaddingXL()

                MusclePack(exerciseExample = exerciseExample)

                PaddingXL()

                HeapMap(fullFrontImage = fullFrontImage, fullBackImage = fullBackImage)
            }

            if (achievements != null) {

                PaddingXL()

                Achievements(
                    maxWeight = achievements.maxWeight.weight,
                    maxRepetition = achievements.maxRepetition.repetition,
                    maxVolume = achievements.maxVolume.volume
                )

                PaddingXL()

                ResentVolume(volumes = achievements.lastVolumes)
            }

            PaddingM()

            ShadowFooterSpace()
        }

        Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL))
        }

        val primary = remember(primaryAction, exerciseExample?.id) {
            if (primaryAction != null && exerciseExample?.id != null) {
                Triple(
                    primaryAction.first,
                    true
                ) { primaryAction.second.invoke(exerciseExample.id) }
            } else null
        }

        // todo add actions
    }
}