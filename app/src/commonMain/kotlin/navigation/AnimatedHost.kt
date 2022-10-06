package navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import redux.Direction

@Composable
fun AnimatedHost(
    currentScreen: Direction?,
    screenToRemove: Direction?,
    animationType: AnimationType,
    isForward: Boolean,
    onScreenRemove: ((Direction) -> Unit)? = null,
    content: @Composable (Direction) -> Unit
) {
    val stateHolder = rememberSaveableStateHolder()

    AnimatedTransition(
        targetState = currentScreen,
        animation = animationType,
        isForwardDirection = isForward,
        content = { direct ->
            if (direct != null) {
                stateHolder.SaveableStateProvider(direct.route) { content(direct) }
            }
        }
    )

    LaunchedEffect(currentScreen, screenToRemove) {
        screenToRemove?.let {
            stateHolder.removeState(it.route)
            onScreenRemove?.invoke(it)
        }
    }
}

@Composable
fun <T> AnimatedTransition(
    targetState: T,
    animation: AnimationType,
    isForwardDirection: Boolean,
    onAnimationEnd: (() -> Unit)? = null,
    content: @Composable (T) -> Unit
) = AnimatedContentWithCallback(
    targetState = targetState,
    onAnimationEnd = onAnimationEnd ?: { },
    content = { target -> content(target) },
    transitionSpec = when (animation) {
        is AnimationType.Present -> presentation(isForwardDirection, animation.animationTime)
        is AnimationType.Fade -> crossFade(animation.animationTime)
        AnimationType.None -> presentation(isForwardDirection, 1)
        is AnimationType.Push -> push(isForwardDirection, animation.animationTime)
    }
)


@Composable
fun <S> AnimatedContentWithCallback(
    targetState: S,
    modifier: Modifier = Modifier,
    transitionSpec: AnimatedContentScope<S>.() -> ContentTransform,
    contentAlignment: Alignment = Alignment.TopStart,
    onAnimationEnd: () -> Unit,
    content: @Composable AnimatedVisibilityScope.(targetState: S) -> Unit
) {
    val previousValue = remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = targetState, label = "AnimatedContent")

    if (transition.isRunning != previousValue.value) {
        previousValue.value = transition.isRunning
        if (!transition.isRunning) onAnimationEnd()
    }

    transition.AnimatedContent(
        modifier,
        transitionSpec,
        contentAlignment,
        content = content
    )
}