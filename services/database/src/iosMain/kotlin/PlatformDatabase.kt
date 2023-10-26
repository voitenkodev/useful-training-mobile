import app.cash.sqldelight.driver.native.NativeSqliteDriver

internal actual fun NativeContext.database(): UsefulTrainingDatabase {
    val driver = NativeSqliteDriver(UsefulTrainingDatabase.Schema, DB_FILE_NAME)
    return UsefulTrainingDatabase(driver)
}