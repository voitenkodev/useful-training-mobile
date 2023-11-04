import app.cash.sqldelight.driver.native.NativeSqliteDriver

internal actual fun NativeContext.database(): AlienWorkoutDatabase {
    val driver = NativeSqliteDriver(AlienWorkoutDatabase.Schema, DB_FILE_NAME)
    return AlienWorkoutDatabase(driver)
}