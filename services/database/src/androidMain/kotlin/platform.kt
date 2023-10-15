import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

internal actual fun NativeContext.database(): UsefulTrainingDatabase {
    return UsefulTrainingDatabase.invoke(AndroidSqliteDriver(
        schema = UsefulTrainingDatabase.Schema,
        context = this.context,
        name = DB_FILE_NAME,
        callback = object : AndroidSqliteDriver.Callback(UsefulTrainingDatabase.Schema) {
            override fun onConfigure(db: SupportSQLiteDatabase) {
                super.onConfigure(db)
                db.setForeignKeyConstraintsEnabled(true)
            }
        }
    ))
}