import app.cash.sqldelight.driver.native.NativeSqliteDriver
import data.Training

internal actual fun NativeContext.database(): AlienWorkoutDatabase {
    val driver = NativeSqliteDriver(AlienWorkoutDatabase.Schema, DB_FILE_NAME)
    return AlienWorkoutDatabase(
        driver = driver,
        TrainingAdapter = Training.Adapter(updatedAtAdapter = DateAdapter, createdAtAdapter = DateAdapter)
    )
}