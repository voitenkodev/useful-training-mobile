package utils


object Logger {

    fun l(msg: () -> String?) {
        print(msg.invoke())
        println(msg.invoke())
    }
}