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
import components.animation.Levitating
import components.brand.UserCard
import components.roots.Root
import icons.Dumbbell
import icons.Logout
import icons.Support
import icons.Weight
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.TextH3
import molecule.secondaryDefaultBackground
import profile.components.Header
import profile.components.MenuItem
import profile.state.User

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        user = state.user,
        updateUser = {},
        toExerciseExamples = {},
        toWeightHistory = {},
        toSupport = {},
        logout = vm::logout
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,

    user: User,
    updateUser: () -> Unit,

    toExerciseExamples: () -> Unit,
    toSupport: () -> Unit,
    toWeightHistory: () -> Unit,
    logout: () -> Unit
) {

    val listState = rememberLazyListState()

    val isHeaderInTop = remember {
        derivedStateOf { listState.layoutInfo.visibleItemsInfo.firstOrNull()?.key == HEADER_KEY }
    }

    Root(
        error = { Error(message = error, close = clearError) },
    ) {

        LazyColumn(
            state = listState,
            modifier = Modifier.animateContentSize().fillMaxSize()
        ) {

            item {
                PaddingM()
            }

            stickyHeader(HEADER_KEY) {
                Header(showBackground = isHeaderInTop.value)
            }

            item {
                Levitating { modifier ->
                    UserCard(
                        modifier = modifier.padding(Design.dp.paddingM),
                        name = user.name,
                        weight = user.weight,
                        height = user.height,
                        btn = "Update" to updateUser
                    )
                }
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
                        onClick = toWeightHistory
                    )

                    MenuItem(
                        icon = Dumbbell,
                        text = "Exercise Examples",
                        iconBackgroundColor = Design.colors.purple.copy(alpha = 0.5f),
                        onClick = toExerciseExamples
                    )

                    MenuItem(
                        icon = Support,
                        text = "Support",
                        iconBackgroundColor = Design.colors.blue.copy(alpha = 0.5f),
                        onClick = toSupport
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
