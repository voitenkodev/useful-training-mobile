//package modifiers
//
//import android.view.MotionEvent
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.TransformOrigin
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.input.pointer.pointerInteropFilter
//import androidx.compose.ui.layout.onGloballyPositioned
//import androidx.compose.ui.unit.dp
//
//@ExperimentalFoundationApi
//@ExperimentalAnimationApi
//@ExperimentalComposeUiApi
//fun Modifier.rolling(
//    initialX: Float =0f,
//    initialY: Float = 0f,
//    maxAngle: Float = 35f,
//    thicknessCoefficient: Float = 1f,
//    sideColor1: Color,
//    sideColor2: Color,
//): Modifier = composed {
//    var angle by remember { mutableStateOf(Pair(initialX, initialY)) }
//    var start by remember { mutableStateOf(Pair(-1f, -1f)) }
//    var viewSize by remember { mutableStateOf(Size.Zero) }
//
//    this.then(Modifier
//        .onGloballyPositioned { coordinates ->
//            viewSize = Size(coordinates.size.width.toFloat(), coordinates.size.height.toFloat())
//        }
//        .pointerInteropFilter { m ->
//            when (m.action) {
//                MotionEvent.ACTION_UP -> {
//                    start = Pair(-1f, -1f)
//                }
//                MotionEvent.ACTION_DOWN -> {
//                    start = Pair(m.rawX, m.rawY)
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    if (viewSize != Size.Zero) {
//                        val end = Pair(m.rawX, m.rawY)
//                        val acceleration = 3
//                        val distances = Pair(start.first - end.first, start.second - end.second)
//                        val rotationX = (distances.first / viewSize.width) * maxAngle * acceleration
//                        val rotationY =
//                            (distances.second / viewSize.height) * maxAngle * acceleration
//                        var x: Float = angle.first + rotationX
//                        var y: Float = angle.second + rotationY
//                        if (x > maxAngle) x = maxAngle
//                        else if (x < -maxAngle) x = -maxAngle
//                        if (y > maxAngle) y = maxAngle
//                        else if (y < -maxAngle) y = -maxAngle
//                        angle = Pair(x, y)
//                        start = end
//                    }
//                }
//            }
//            true
//        }
//        .graphicsLayer(
//            transformOrigin = TransformOrigin(0.5f, 0.5f),
//            rotationY = animateFloatAsState(-angle.first).value,
//            rotationX = animateFloatAsState(angle.second).value,
//            cameraDistance = 12.dp.value
//        )
//        .parallelepiped(
//            angleX = angle.first,
//            angleY = angle.second,
//            color1 = sideColor1,
//            color2 = sideColor2,
//            thicknessCoefficient = thicknessCoefficient
//        )
//    )
//}