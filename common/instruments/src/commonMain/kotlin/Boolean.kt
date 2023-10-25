public fun buildBoolean(block: BooleanBuilder.() -> Unit): Boolean {
    val builder = BooleanBuilder()
    builder.block()
    return builder.result()
}

public class BooleanBuilder {
    private val conditions = mutableListOf<Boolean>()

    public fun addCondition(condition: Boolean) {
        conditions.add(condition)
    }

    public fun result(): Boolean {
        return conditions.any { it }
    }
}