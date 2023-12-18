import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import data.Training

internal actual fun NativeContext.database(): AlienWorkoutDatabase {
    return AlienWorkoutDatabase.invoke(
        driver = AndroidSqliteDriver(
            schema = AlienWorkoutDatabase.Schema,
            context = this.context,
            name = DB_FILE_NAME,
            callback = object : AndroidSqliteDriver.Callback(AlienWorkoutDatabase.Schema) {
                override fun onConfigure(db: SupportSQLiteDatabase) {
                    super.onConfigure(db)
                    db.setForeignKeyConstraintsEnabled(true)
                }
            }
        ),
        TrainingAdapter = Training.Adapter(updatedAtAdapter = DateAdapter, createdAtAdapter = DateAdapter)
    )
}