package ui.review

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import co.touchlab.kermit.Logger
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import presentation.ReviewContent
import designsystem.common.DesignComponent
import ui.navigation.ScreenNavigator
import ui.navigation.Router

@Composable
fun ReviewScreen(
    viewModel: ReviewViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.trainingState.collectAsState()

    ScreenNavigator(
        event = viewModel.event,
        navigate = navigate
    )

    ReviewContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        ok = viewModel::ok,
        chart = { label, list, color -> LineChart(label = label, state = list, color = color) }
    )
}

@Composable
fun LineChart(
    label: String,
    state: List<Float>,
    color: Color,
) {
    val backgroundColor = Color.Transparent.toArgb()
    val lineColor = color
    val textColor = DesignComponent.colors.content
    val filledColor = color.copy(alpha = 0.3f)

    AndroidView(
        factory = { context ->
            com.github.mikephil.charting.charts.LineChart(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )

                setBackgroundColor(backgroundColor)

                // Actions
                setTouchEnabled(false)
                isDragEnabled = false
                setScaleEnabled(false)
                setPinchZoom(false)

                // labels need
                axisLeft.isEnabled = true
                axisLeft.textColor = textColor.toArgb()
                axisLeft.textSize = 11f
                xAxis.isEnabled = true
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.textSize = 10f
                xAxis.textColor = textColor.toArgb()
                xAxis.axisMinimum = 0.8f
                // labels NOT need
                axisRight.isEnabled = false

                // description
                description.isEnabled = false
                legend.isEnabled = false
                legend.form = Legend.LegendForm.NONE

                // borders / grids
                setDrawBorders(false)
                axisLeft.setDrawAxisLine(false)
                xAxis.setDrawAxisLine(false)
                axisLeft.setDrawGridLines(false)
                xAxis.setDrawGridLines(false)
            }
        }, update = {
            it.data = state.mapIndexed { index: Int, item: Float ->
                (index + 1).toFloat() to item
            }.toLineChart(
                label = label,
                color = lineColor,
                backgroundColor = filledColor
            )
            it.invalidate()
        }
    )
}

fun List<Pair<Float, Float>>.toLineChart(
    label: String,
    color: Color,
    backgroundColor: Color,
): LineData {

    Logger.i { this.toString() }

    val values = ArrayList<Entry>()
    values.addAll(this.map { Entry(it.first, it.second) })

    val set = LineDataSet(values, label)
    set.setDrawIcons(false)

    set.color = color.toArgb()
    set.setCircleColor(color.toArgb())

    // line thickness and point size
    set.lineWidth = 3f
    set.circleRadius = 5f
    set.setDrawCircleHole(false)

    // text values
    set.setDrawValues(false)

    // set the filled area
    set.setDrawFilled(true)

    // soft angles mode
    set.mode = LineDataSet.Mode.CUBIC_BEZIER

    // set color of filled area
    set.fillColor = backgroundColor.toArgb()

    // add the data sets
    val dataSets = ArrayList<ILineDataSet>()
    dataSets.add(set)

    // create a data object with the data sets
    val data = LineData(dataSets)

    data.isHighlightEnabled = false

    return data
}