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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.overlay.TopShadow
import components.roots.ScreenRoot
import exerciseexample.main.components.Achievements
import exerciseexample.main.components.Header
import exerciseexample.main.components.HeapMap
import exerciseexample.main.components.MusclePack
import exerciseexample.main.components.ResentVolume
import exerciseexample.main.models.ExerciseExample
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
        fullBackImage = state.fullBackImageVector
    )
}

@Composable
private fun Content(
    close: () -> Unit,
    error: () -> String?,
    clearError: () -> Unit,
    achievements: ExerciseExampleAchievements?,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    exerciseExample: ExerciseExample?,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            Header(exerciseExample = exerciseExample)

            PaddingXL()

//            Tutorial(url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", onClick = {})

//            PaddingXL()

            MusclePack(exerciseExample = exerciseExample)

            PaddingXL()

            HeapMap(fullFrontImage = fullFrontImage, fullBackImage = fullBackImage)

            if (achievements != null) {

                PaddingXL()

                Achievements()

                PaddingXL()

                ResentVolume(volumes = achievements.lastVolumes)
            }

            PaddingM()

            ShadowFooterSpace()
        }

        Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            TopShadow(modifier = Modifier.fillMaxSize())
            Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL))
        }

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            primary = if (primaryAction != null && exerciseExample?.id != null) {
                primaryAction.first to { primaryAction.second.invoke(exerciseExample.id) }
            } else null,
            close = close
        )
    }
}