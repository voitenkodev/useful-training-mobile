import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import source.database.DB_FILE_NAME
import source.datastore.createDataStore
import source.datastore.dataStoreFileName

actual class NativeContext private actual constructor() {
    lateinit var context: Context
        private set

    constructor(context: Context) : this() {
        this.context = context
    }
}

internal actual fun NativeContext.driver(): HttpClient {
    return HttpClient(OkHttp)
}

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

internal actual fun NativeContext.preferences(): DataStore<Preferences> {
    return createDataStore(
        coroutineScope = CoroutineScope(Dispatchers.Default),
        producePath = { this.context.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}