package internal

import Store

public object StoreImpl : Store {

    @PublishedApi
    internal val saver: MutableMap<String, Pair<Any, ((Any) -> Unit)?>> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    public override fun <T : Any> provide(key: String, factory: () -> T, clear: (T) -> Unit): T {
        return saver.getOrPut(key) { factory.invoke() to (clear as (Any) -> Unit) }.first as T
    }

    public fun remove(screenKey: String) {
        saver.forEach {
            if (it.key.startsWith(screenKey)) {
                it.value.second?.invoke(it.value.first)
                saver -= it.key
            }
        }
    }
}
