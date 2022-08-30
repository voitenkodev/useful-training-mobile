//package com.voitenko.dev.designsystem.modifiers
//
//import android.graphics.Matrix
//import androidx.compose.animation.core.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.draw.DrawModifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.geometry.toRect
//import androidx.compose.ui.graphics.*
//import androidx.compose.ui.graphics.drawscope.ContentDrawScope
//import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
//import androidx.compose.ui.layout.LayoutCoordinates
//import androidx.compose.ui.layout.OnGloballyPositionedModifier
//import androidx.compose.ui.layout.positionInWindow
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlin.math.*
//
//fun Modifier.shimmer(): Modifier = composed {
//    val shimmer = rememberShimmer()
//    val width = with(LocalDensity.current) { shimmer.theme.shimmerWidth.toPx() }
//    val area = remember(width, shimmer.theme.rotation) {
//        ShimmerArea(width, shimmer.theme.rotation)
//    }
//
//    LaunchedEffect(area, shimmer) {
//        shimmer.boundsFlow.collect {
//            area.updateBounds(it)
//        }
//    }
//
//    remember(area, shimmer) { ShimmerModifier(area, shimmer.effect) }
//}
//
//private class ShimmerModifier(
//    private val area: ShimmerArea,
//    private val effect: ShimmerEffect,
//) : DrawModifier, OnGloballyPositionedModifier {
//
//    override fun ContentDrawScope.draw() {
//        with(effect) { draw(area) }
//    }
//
//    override fun onGloballyPositioned(coordinates: LayoutCoordinates) {
//        val viewBounds = coordinates.unclippedBoundsInWindow()
//        area.viewBounds = viewBounds
//    }
//}
//
//@Composable
//private fun rememberShimmer(
//    theme: ShimmerConfiguration = ShimmerConfiguration(),
//): Shimmer {
//    val displayMetrics = LocalContext.current.resources.displayMetrics
//
//    val effect = rememberShimmerEffect(theme)
//    val bounds = remember(displayMetrics) {
//        Rect(0f, 0f, displayMetrics.widthPixels.toFloat(), displayMetrics.heightPixels.toFloat())
//    }
//
//    return remember(theme, effect, bounds) {
//        Shimmer(theme, effect, bounds)
//    }
//}
//
//private class Shimmer constructor(
//    val theme: ShimmerConfiguration,
//    val effect: ShimmerEffect,
//    bounds: Rect?,
//) {
//
//    val boundsFlow = MutableStateFlow(bounds)
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//        other as Shimmer
//        if (theme != other.theme) return false
//        if (effect != other.effect) return false
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = theme.hashCode()
//        result = 31 * result + effect.hashCode()
//        return result
//    }
//}
//
///**
// * Describes the area in which the shimmer effect will be drawn.
// */
//private class ShimmerArea(
//    private val widthOfShimmer: Float,
//    rotationInDegree: Float,
//) {
//
//    private val reducedRotation = rotationInDegree.reduceRotation().toRadian()
//
//    // = Rect.Zero -> Don't draw
//    // = null -> Draw into view
//    private var requestedShimmerBounds: Rect? = null
//    private var shimmerSize: Size = Size.Zero
//
//    var translationDistance = 0f
//        private set
//
//    var pivotPoint = Offset.Unspecified
//        private set
//
//    var shimmerBounds = Rect.Zero
//        private set
//
//    var viewBounds = Rect.Zero
//        set(value) {
//            if (value == field) return
//            field = value
//            computeShimmerBounds()
//        }
//
//    fun updateBounds(shimmerBounds: Rect?) {
//        if (this.requestedShimmerBounds == shimmerBounds) return
//        requestedShimmerBounds = shimmerBounds
//        computeShimmerBounds()
//    }
//
//    private fun computeShimmerBounds() {
//        if (viewBounds.isEmpty) return
//        shimmerBounds = requestedShimmerBounds ?: viewBounds
//        pivotPoint = -viewBounds.topLeft + shimmerBounds.center
//        val newShimmerSize = shimmerBounds.size
//        if (shimmerSize != newShimmerSize) {
//            shimmerSize = newShimmerSize
//            computeTranslationDistance()
//        }
//    }
//
//    private fun computeTranslationDistance() {
//        val width = shimmerSize.width / 2
//        val height = shimmerSize.height / 2
//        val distanceCornerToCenter = sqrt(width.pow(2) + height.pow(2))
//        val beta = acos(width / distanceCornerToCenter)
//        val alpha = beta - reducedRotation
//        val distanceCornerToRotatedCenterLine = cos(alpha) * distanceCornerToCenter
//        translationDistance = distanceCornerToRotatedCenterLine * 2 + widthOfShimmer
//    }
//
//    private fun Float.reduceRotation(): Float {
//        if (this < 0f) throw IllegalArgumentException("The shimmer's rotation must be a positive number")
//        var rotation = this % 180   // 0..179, 0
//        rotation -= 90              // -90..0..89, -90
//        rotation = -abs(rotation)   // -90..0..-90
//        return rotation + 90        // 0..90..0
//    }
//
//    private fun Float.toRadian(): Float = this / 180 * 3.141592653589793f
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as ShimmerArea
//
//        if (widthOfShimmer != other.widthOfShimmer) return false
//        if (reducedRotation != other.reducedRotation) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = widthOfShimmer.hashCode()
//        result = 31 * result + reducedRotation.hashCode()
//        return result
//    }
//}
//
//@Composable
//private fun rememberShimmerEffect(theme: ShimmerConfiguration): ShimmerEffect {
//    val shimmerWidth = with(LocalDensity.current) { theme.shimmerWidth.toPx() }
//    val shimmerEffect = remember(theme) {
//        ShimmerEffect(
//            animationSpec = theme.animationSpec,
//            blendMode = theme.blendMode,
//            rotation = theme.rotation,
//            shaderColors = theme.shaderColors,
//            shaderColorStops = theme.shaderColorStops,
//            shimmerWidth = shimmerWidth,
//        )
//    }
//
//    LaunchedEffect(shimmerEffect) {
//        shimmerEffect.startAnimation()
//    }
//    return shimmerEffect
//}
//
//private class ShimmerEffect(
//    private val animationSpec: AnimationSpec<Float>,
//    private val blendMode: BlendMode,
//    private val rotation: Float,
//    private val shaderColors: List<Color>,
//    private val shaderColorStops: List<Float>?,
//    private val shimmerWidth: Float,
//) {
//
//    private val animatedState = Animatable(0f)
//
//    private val transformationMatrix = Matrix()
//
//    private val shader = LinearGradientShader(
//        from = Offset(-shimmerWidth / 2, 0f),
//        to = Offset(shimmerWidth / 2, 0f),
//        colors = shaderColors,
//        colorStops = shaderColorStops,
//    )
//
//    private val paint = Paint().apply {
//        isAntiAlias = true
//        style = PaintingStyle.Fill
//        blendMode = this@ShimmerEffect.blendMode
//        shader = this@ShimmerEffect.shader
//    }
//
//    suspend fun startAnimation() {
//        animatedState.animateTo(
//            targetValue = 1f,
//            animationSpec = animationSpec,
//        )
//    }
//
//    private val emptyPaint = Paint()
//
//    fun ContentDrawScope.draw(shimmerArea: ShimmerArea) = with(shimmerArea) {
//        if (shimmerBounds.isEmpty || viewBounds.isEmpty) return
//
//        val progress = animatedState.value
//        val traversal = -translationDistance / 2 + translationDistance * progress + pivotPoint.x
//
//        transformationMatrix.apply {
//            reset()
//            postTranslate(traversal, 0f)
//            postRotate(rotation, pivotPoint.x, pivotPoint.y)
//        }
//        shader.setLocalMatrix(transformationMatrix)
//
//        val drawArea = size.toRect()
//        drawIntoCanvas { canvas ->
//            canvas.withSaveLayer(
//                bounds = drawArea, emptyPaint
//            ) {
//                drawContent()
//                canvas.drawRect(drawArea, paint)
//            }
//        }
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//        other as ShimmerEffect
//        if (animationSpec != other.animationSpec) return false
//        if (blendMode != other.blendMode) return false
//        if (rotation != other.rotation) return false
//        if (shaderColors != other.shaderColors) return false
//        if (shaderColorStops != other.shaderColorStops) return false
//        if (shimmerWidth != other.shimmerWidth) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = animationSpec.hashCode()
//        result = 31 * result + blendMode.hashCode()
//        result = 31 * result + rotation.hashCode()
//        result = 31 * result + shaderColors.hashCode()
//        result = 31 * result + shaderColorStops.hashCode()
//        result = 31 * result + shimmerWidth.hashCode()
//        return result
//    }
//}
//
//private data class ShimmerConfiguration(
//    val animationSpec: AnimationSpec<Float> = infiniteRepeatable(
//        animation = tween(900, easing = LinearEasing, delayMillis = 700),
//        repeatMode = RepeatMode.Restart,
//    ),
//    val blendMode: BlendMode = BlendMode.DstIn,
//    val rotation: Float = 15.0f,
//    val shaderColors: List<Color> = listOf(
//        Color.Unspecified.copy(alpha = 0.25f),
//        Color.Unspecified.copy(alpha = 1.00f),
//        Color.Unspecified.copy(alpha = 0.25f),
//    ),
//    val shaderColorStops: List<Float>? = listOf(0.0f, 0.5f, 1.0f),
//    val shimmerWidth: Dp = 400.dp,
//)
//
//private fun LayoutCoordinates.unclippedBoundsInWindow(): Rect {
//    val positionInWindow = positionInWindow()
//    return Rect(
//        positionInWindow.x,
//        positionInWindow.y,
//        positionInWindow.x + size.width,
//        positionInWindow.y + size.height,
//    )
//}
