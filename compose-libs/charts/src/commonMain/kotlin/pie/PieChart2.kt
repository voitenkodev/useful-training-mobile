//package pie
//
//import androidx.compose.animation.core.TweenSpec
//import androidx.compose.animation.core.animateDpAsState
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import kotlin.math.PI
//import kotlin.math.pow
//import kotlin.math.sqrt
//
//
//// Resource: https://github.com/eozsahin1993/Fancy-Donut-Chart-Compose/blob/master/app/src/main/java/com/example/donutchart/ui/theme/components/DonutChart.kt
//
//private const val TOTAL_ANGLE = 360.0f
//private val STROKE_SIZE_UNSELECTED = 16.dp
//private val STROKE_SIZE_SELECTED = 16.dp
//
//public data class PieChartData(
//    val value: Float,
//    val color: Color,
//    val title: String
//)
//
//public data class PieChartDataCollection(var items: List<PieChartData>) {
//    internal var totalAmount: Float = items.sumOf { it.value.toDouble() }.toFloat()
//        private set
//}
//
//private data class DrawingAngles(val start: Float, val end: Float)
//
//private fun DrawingAngles.isInsideAngle(angle: Float) = angle > this.start && angle < this.start + this.end
//
//private class PieChartState(val state: State = State.Unselected) {
//    val stroke: Dp
//        get() = when (state) {
//            State.Selected -> STROKE_SIZE_SELECTED
//            State.Unselected -> STROKE_SIZE_UNSELECTED
//        }
//
//    enum class State { Selected, Unselected }
//}
//
//@Composable
//public fun PieChart(
//    modifier: Modifier = Modifier,
//    data: PieChartDataCollection,
//    gapPercentage: Float = 0.05f,
//    selectionView: @Composable (selectedItem: PieChartData?) -> Unit = {},
//) {
//
//    var selectedIndex by remember { mutableStateOf(-1) }
//    val animationTargetState = (0..data.items.size).map {
//        remember { mutableStateOf(PieChartState()) }
//    }
//
//    val animValues = (0..data.items.size).map {
//        animateDpAsState(
//            targetValue = animationTargetState[it].value.stroke,
//            animationSpec = TweenSpec(700)
//        )
//    }
//    val anglesList: MutableList<DrawingAngles> = remember { mutableListOf() }
//    val gapAngle = data.calculateGapAngle(gapPercentage)
//    var center = Offset(0f, 0f)
//
//    LaunchedEffect(data) {
//        if (data.items.isNotEmpty()) {
//            val index = data.items.map { it.value }.indexOfMaxValue()
//            selectedIndex = index
//            animationTargetState.getOrNull(index)?.value = PieChartState(PieChartState.State.Selected)
//        }
//    }
//
//    Box(
//        modifier = modifier,
//        contentAlignment = Alignment.Center,
//    ) {
//        Canvas(
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f)
//                .pointerInput(Unit) {
//                    detectTapGestures(
//                        onTap = { tapOffset ->
//                            handleCanvasTap(
//                                center = center,
//                                tapOffset = tapOffset,
//                                anglesList = anglesList,
//                                currentSelectedIndex = selectedIndex,
//                                currentStrokeValues = animationTargetState.map { it.value.stroke.toPx() },
//                                onItemSelected = { index ->
//                                    selectedIndex = index
//                                    animationTargetState[index].value = PieChartState(
//                                        PieChartState.State.Selected
//                                    )
//                                },
//                                onItemDeselected = { index ->
//                                    animationTargetState[index].value = PieChartState(
//                                        PieChartState.State.Unselected
//                                    )
//                                },
//                                onNoItemSelected = {
////                                    selectedIndex = -1
//                                }
//                            )
//                        }
//                    )
//                },
//            onDraw = {
//                val defaultStrokeWidth = STROKE_SIZE_UNSELECTED.toPx()
//                center = this.center
//                anglesList.clear()
//                var lastAngle = 0f
//                data.items.forEachIndexed { ind, item ->
//                    val sweepAngle = data.findSweepAngle(ind, gapPercentage)
//                    anglesList.add(DrawingAngles(lastAngle, sweepAngle))
//                    val strokeWidth = animValues[ind].value.toPx()
//                    drawArc(
//                        color = item.color,
//                        startAngle = lastAngle,
//                        sweepAngle = sweepAngle,
//                        alpha = if(selectedIndex == ind) 1f else 0.7f,
//                        useCenter = false,
//                        topLeft = Offset(defaultStrokeWidth / 2, defaultStrokeWidth / 2),
//                        style = Stroke(strokeWidth, cap = StrokeCap.Butt),
//                        size = Size(
//                            size.width - defaultStrokeWidth,
//                            size.height - defaultStrokeWidth
//                        )
//                    )
//                    lastAngle += sweepAngle + gapAngle
//                }
//            }
//        )
//        selectionView(if (selectedIndex >= 0) data.items[selectedIndex] else null)
//    }
//}
//
//private fun List<Float>.indexOfMaxValue(): Int {
//    if (isEmpty()) {
//        return -1
//    }
//
//    var maxIndex = 0
//    var maxValue = this[0]
//
//    for (i in 1 until size) {
//        if (this[i] > maxValue) {
//            maxValue = this[i]
//            maxIndex = i
//        }
//    }
//
//    return maxIndex
//}
//
//private fun handleCanvasTap(
//    center: Offset,
//    tapOffset: Offset,
//    anglesList: List<DrawingAngles>,
//    currentSelectedIndex: Int,
//    currentStrokeValues: List<Float>,
//    onItemSelected: (Int) -> Unit = {},
//    onItemDeselected: (Int) -> Unit = {},
//    onNoItemSelected: () -> Unit = {},
//) {
//    val normalized = tapOffset.findNormalizedPointFromTouch(center)
//    val touchAngle =
//        calculateTouchAngleAccordingToCanvas(center, normalized)
//    val distance = findTouchDistanceFromCenter(center, normalized)
//
//    var selectedIndex = -1
//    var newDataTapped = false
//
//    anglesList.forEachIndexed { ind, angle ->
//        val stroke = currentStrokeValues[ind]
//        if (angle.isInsideAngle(touchAngle)) {
//            if (distance > (center.x - stroke) &&
//                distance < (center.x)
//            ) { // since it's a square center.x or center.y will be the same
//                selectedIndex = ind
//                newDataTapped = true
//            }
//        }
//    }
//
//    if (selectedIndex >= 0 && newDataTapped) {
//        onItemSelected(selectedIndex)
//    }
//    if (currentSelectedIndex >= 0) {
//        onItemDeselected(currentSelectedIndex)
//        if (currentSelectedIndex == selectedIndex || !newDataTapped) {
//            onNoItemSelected()
//        }
//    }
//}
//
///**
// * Find the distance based on two points in a graph. Calculated using the pythagorean theorem.
// */
//private fun findTouchDistanceFromCenter(center: Offset, touch: Offset) =
//    sqrt((touch.x - center.x).pow(2) + (touch.y - center.y).pow(2))
//
///**
// * The touch point start from Canvas top left which ranges from (0,0) -> (canvas.width, canvas.height).
// * We need to normalize this point so that it's based on the canvas center instead.
// */
//private fun Offset.findNormalizedPointFromTouch(canvasCenter: Offset) =
//    Offset(this.x, canvasCenter.y + (canvasCenter.y - this.y))
//
///**
// * Calculate the touch angle based on the canvas center. Then adjust the angle so that
// * drawing starts from the 4th quadrant instead of the first.
// */
//private fun calculateTouchAngleAccordingToCanvas(canvasCenter: Offset, normalizedPoint: Offset): Float {
//    val angle = calculateTouchAngleInDegrees(canvasCenter, normalizedPoint)
//    return adjustAngleToCanvas(angle).toFloat()
//}
//
///**
// * Calculate touch angle in radian using atan2(). Afterwards, convert the radian to degrees to be
// * compared to other data points.
// */
//private fun calculateTouchAngleInDegrees(canvasCenter: Offset, normalizedPoint: Offset): Double {
//    val touchInRadian = kotlin.math.atan2(
//        normalizedPoint.y - canvasCenter.y,
//        normalizedPoint.x - canvasCenter.x
//    )
//    return touchInRadian * -180 / PI // Convert radians to angle in degrees
//}
//
///**
// * Start from 4th quadrant going to 1st quadrant, degrees ranging from 0 to 360
// */
//private fun adjustAngleToCanvas(angle: Double) = (angle + TOTAL_ANGLE) % TOTAL_ANGLE
//
///**
// * Calculate the gap width between the arcs based on [gapPercentage]. The percentage is applied
// * to the average count to determine the width in pixels.
// */
//private fun PieChartDataCollection.calculateGap(gapPercentage: Float): Float {
//    if (this.items.isEmpty()) return 0f
//
//    return (this.totalAmount / this.items.size) * gapPercentage
//}
//
///**
// * Returns the total data points including the individual gap widths indicated by the
// * [gapPercentage].
// */
//private fun PieChartDataCollection.getTotalAmountWithGapIncluded(gapPercentage: Float): Float {
//    val gap = this.calculateGap(gapPercentage)
//    return this.totalAmount + (this.items.size * gap)
//}
//
///**
// * Calculate the sweep angle of an arc including the gap as well. The gap is derived based
// * on [gapPercentage].
// */
//private fun PieChartDataCollection.calculateGapAngle(gapPercentage: Float): Float {
//    val gap = this.calculateGap(gapPercentage)
//    val totalAmountWithGap = this.getTotalAmountWithGapIncluded(gapPercentage)
//
//    return (gap / totalAmountWithGap) * TOTAL_ANGLE
//}
//
///**
// * Returns the sweep angle of a given point in the [PieChartDataCollection]. This calculations
// * takes the gap between arcs into the account.
// */
//private fun PieChartDataCollection.findSweepAngle(
//    index: Int,
//    gapPercentage: Float
//): Float {
//    val amount = items[index].value
//    val gap = this.calculateGap(gapPercentage)
//    val totalWithGap = getTotalAmountWithGapIncluded(gapPercentage)
//    val gapAngle = this.calculateGapAngle(gapPercentage)
//    return ((((amount + gap) / totalWithGap) * TOTAL_ANGLE)) - gapAngle
//}