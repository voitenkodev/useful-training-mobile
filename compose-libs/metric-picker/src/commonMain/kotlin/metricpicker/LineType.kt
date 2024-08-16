package metricpicker

internal sealed class LineType {
    data object Normal : LineType()
    data object FiveStep : LineType()
    data object TenStep : LineType()
}