package ui.review

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import designsystem.common.DesignComponent

@Composable
fun LineChart(
    modifier: Modifier
) {
    val backgroundColor = DesignComponent.colors.secondary100.toArgb()
    val lineColor = DesignComponent.colors.primary100
    val textColor = DesignComponent.colors.secondaryInverse
    val filledColor = DesignComponent.colors.secondary100

    AndroidView(
        modifier = modifier
            .background(color = DesignComponent.colors.secondary100, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(6.dp, DesignComponent.colors.primary100), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        factory = { context ->
            LineChart(context).apply {
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
            it.data = listOf(
                2300.0 to 1,
                2200.0 to 2,
                2400.0 to 3,
                2800.0 to 4,
                2600.0 to 5,
                2200.0 to 6,
                2690.0 to 7,
            ).map {
                it.second.toFloat() to it.first.toFloat()
            }.toLineChart(
                label = "Tonnage",
                color = lineColor,
                backgroundColor = filledColor
            )
            it.animateY(500)
            it.invalidate()
        }
    )
}

fun List<Pair<Float, Float>>.toLineChart(
    label: String,
    color: Color,
    backgroundColor: Color,
): LineData {

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