import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.driver.native.wrapConnection
import co.touchlab.sqliter.DatabaseConfiguration

internal actual fun NativeContext.database(): UsefulTrainingDatabase {
    val dbConfig = DatabaseConfiguration(
        name = DB_FILE_NAME,
        version = UsefulTrainingDatabase.Schema.version,
        extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true),
        create = { connection ->
            wrapConnection(connection) { UsefulTrainingDatabase.Schema.create(it) }
        }
    )
    return UsefulTrainingDatabase.invoke(NativeSqliteDriver(dbConfig))
}