import app.cash.sqldelight.ColumnAdapter

internal object DateAdapter : ColumnAdapter<String, Long> {

    override fun decode(databaseValue: Long): String {
        return DateTimeKtx.millisToIso(databaseValue)
    }

    override fun encode(value: String): Long {
        return DateTimeKtx.isoToMillis(value)
    }
}