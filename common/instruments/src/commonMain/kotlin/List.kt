fun <T> List<T>.next(last: T): T? {
    val currentIndex = indexOf(last)
    if (currentIndex != -1) {
        val nextIndex = (currentIndex + 1) % size
        return get(nextIndex)
    }
    return null
}