package exerciseexamplebuilder.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.inputs.InputExerciseName
import components.roots.ScreenRoot
import molecule.PaddingM
import resources.Icons

@Composable
internal fun ExerciseExampleBuilderContent(
    vm: ExerciseExampleBuilderViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        close = close,
        error = { state.error },
        clearError = vm::clearError,
        updateName = vm::updateName,
        name = state.name
    )
}

@Composable
private fun Content(
    close: () -> Unit,
    error: () -> String?,
    clearError: () -> Unit,

    name: String,
    updateName: (String) -> Unit,

    ) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            ShadowHeaderSpace()
            PaddingM()

            InputExerciseName(
                provideName = { name },
                update = updateName
            )

            ShadowFooterSpace()
        }

        ShadowHeader(
            title = "Exercise Builder"
        )

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
//            primary = primary,
            close = close
        )
    }
}
