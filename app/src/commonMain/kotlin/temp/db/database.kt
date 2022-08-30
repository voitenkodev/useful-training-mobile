//package db
//
//import android.content.Context
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.squareup.sqldelight.ColumnAdapter
//import com.squareup.sqldelight.android.AndroidSqliteDriver
//import com.squareup.sqldelight.db.SqlDriver
//import kotlinx.datetime.LocalDateTime
//import kotlinx.datetime.toLocalDateTime
//
//internal fun database(context: Context): AppDataBaseQueries =
//    AppDataBase.invoke(DatabaseDriverFactory(context).createDriver(), Art.Adapter(dateAdapter, listOfStringsAdapter)).appDataBaseQueries
//
//private class DatabaseDriverFactory(private val context: Context) {
//    fun createDriver(): SqlDriver = AndroidSqliteDriver(
//        AppDataBase.Schema,
//        context,
//        "GallerySpace.db",
//        callback = object : AndroidSqliteDriver.Callback(AppDataBase.Schema) {
//            override fun onConfigure(db: SupportSQLiteDatabase) {
//                super.onConfigure(db)
//                db.setForeignKeyConstraintsEnabled(true)
//            }
//        }
//    )
//}
//
//private val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
//    override fun decode(databaseValue: String) =
//        if (databaseValue.isEmpty()) listOf() else databaseValue.split(",")
//
//    override fun encode(value: List<String>) = value.joinToString(separator = ",")
//}
//
//private val dateAdapter = object : ColumnAdapter<LocalDateTime, String> {
//    override fun decode(databaseValue: String): LocalDateTime =
//        databaseValue.toLocalDateTime()
//
//    override fun encode(value: LocalDateTime): String = value.toString()
//}