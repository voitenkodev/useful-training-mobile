package bar

internal fun List<String>.getLongestString(): String? {
    var longest = this.firstOrNull() ?: return null
    for (str in this) {
        if (str.length > longest.length) {
            longest = str
        }
    }
    return longest
}