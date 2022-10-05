package navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with

sealed class AnimationType {
    object None : AnimationType()
    data class Push(val animationTime: Int = 300) : AnimationType()
    data class Present(val animationTime: Int = 300) : AnimationType()
    data class Fade(val animationTime: Int = 300) : AnimationType()
}

fun <T> crossFade(transitionTime: Int): AnimatedContentScope<T>.() -> ContentTransform = {
    (fadeIn(animationSpec = tween(transitionTime)) with fadeOut(animationSpec = tween(transitionTime)))
        .using(SizeTransform(clip = false))
}

fun <T> push(isForward: Boolean, transitionTime: Int): AnimatedContentScope<T>.() -> ContentTransform = {
    if (isForward) {
        (slideInHorizontally(
            animationSpec = tween(transitionTime),
            initialOffsetX = { width -> width })
                + fadeIn(animationSpec = tween(transitionTime)) with slideOutHorizontally(
            animationSpec = tween(transitionTime),
            targetOffsetX = { width -> -width })
                + fadeOut(animationSpec = tween(transitionTime)))
            .using(SizeTransform(clip = false))
    } else {
        (slideInHorizontally(
            animationSpec = tween(transitionTime),
            initialOffsetX = { width -> -width })
                + fadeIn(animationSpec = tween(transitionTime)) with slideOutHorizontally(
            animationSpec = tween(transitionTime), targetOffsetX = { width -> width })
                + fadeOut(animationSpec = tween(transitionTime)))
            .using(SizeTransform(clip = false))
    }
}

fun <T> presentation(isOpen: Boolean, transitionTime: Int): AnimatedContentScope<T>.() -> ContentTransform = {
    if (isOpen) {
        (slideInVertically(
            animationSpec = tween(transitionTime),
            initialOffsetY = { height -> height })
                + fadeIn(animationSpec = tween(transitionTime)) with slideOutVertically(
            animationSpec = tween(transitionTime),
            targetOffsetY = { height -> -(height / 8) })
                + fadeOut(animationSpec = tween(transitionTime)))
            .using(SizeTransform(clip = false))
    } else {
        (slideInVertically(
            animationSpec = tween(transitionTime),
            initialOffsetY = { height -> -(height / 8) })
                + fadeIn(animationSpec = tween(transitionTime)) with slideOutVertically(
            animationSpec = tween(transitionTime), targetOffsetY = { height -> height })
                + fadeOut(animationSpec = tween(transitionTime)))
            .using(SizeTransform(clip = false))
    }
}