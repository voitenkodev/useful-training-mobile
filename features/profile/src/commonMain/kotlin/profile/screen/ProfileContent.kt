package profile.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import atom.Design
import components.Error
import components.Loading
import components.brand.UserCard
import components.roots.Root
import icons.Dumbbell
import icons.Logout
import icons.Support
import icons.Weight
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.TextH3
import molecule.secondaryDefaultBackground
import profile.components.Header
import profile.components.MenuItem
import profile.state.ExerciseExample
import profile.state.Muscle

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        exerciseExamples = state.exerciseExamples,
        muscles = state.muscles,
        toExerciseExample = toExerciseExampleBuilder,
        toMuscle = { },
        logout = vm::logout
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    exerciseExamples: ImmutableList<ExerciseExample>,
    muscles: ImmutableList<Muscle>,

    toExerciseExample: (exerciseExampleId: String?) -> Unit,
    toMuscle: (muscleId: String?) -> Unit,
    logout: () -> Unit
) {

    val listState = rememberLazyListState()

    val isHeaderInTop = remember {
        derivedStateOf { listState.layoutInfo.visibleItemsInfo.firstOrNull()?.key == HEADER_KEY }
    }

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        LazyColumn(
            state = listState,
            modifier = Modifier
                .animateContentSize()
                .fillMaxSize()
        ) {

            item {
                PaddingM()
            }

            stickyHeader(HEADER_KEY) {
                Header(showBackground = isHeaderInTop.value)
            }

            item {
                UserCard(
                    modifier = Modifier.padding(Design.dp.paddingM),
                    name = "Hello World",
                    weight = "123kg",
                    height = "184.4cm",
                    btn = "Update" to {}
                )
            }

            item { PaddingXL() }

            item {
                TextH3(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Menu" }
                )
            }

            item { PaddingS() }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingM)
                        .secondaryDefaultBackground()
                        .fillMaxWidth()
                        .padding(vertical = Design.dp.paddingS)
                        .clipToBounds()
                ) {

                    MenuItem(
                        icon = Weight,
                        text = "Weight History",
                        iconBackgroundColor = Design.colors.green.copy(alpha = 0.5f),
                        onClick = {}
                    )

                    MenuItem(
                        icon = Dumbbell,
                        text = "Exercise Examples",
                        iconBackgroundColor = Design.colors.purple.copy(alpha = 0.5f),
                        onClick = { toExerciseExample(null) }
                    )

                    MenuItem(
                        icon = Support,
                        text = "Support",
                        iconBackgroundColor = Design.colors.blue.copy(alpha = 0.5f),
                        onClick = {}
                    )

                    MenuItem(
                        icon = Logout,
                        text = "Logout",
                        contentColor = Design.colors.red,
                        allowRightArrow = false,
                        onClick = logout
                    )
                }
            }
        }
    }
}
