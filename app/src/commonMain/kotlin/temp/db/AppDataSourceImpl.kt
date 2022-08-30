//package db
//
//import android.content.Context
//import com.squareup.sqldelight.runtime.coroutines.asFlow
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.flow.*
//import kotlinx.datetime.LocalDateTime
//
//class AppDataSourceImpl(
//    context: Context,
//    private val io: CoroutineDispatcher
//) : AppDataSource {
//
//    private val database: AppDataBaseQueries = database(context = context)
//
//    override fun setArt(
//        url: String,
//        title: String,
//        description: String,
//        price: String,
//        createdAt: LocalDateTime,
//        proprietors: List<String>
//    ): Flow<Long?> =
//        flowOf(database.setArt(url, title, description, price, createdAt, proprietors))
//            .flatMapConcat { lastId() }
//            .flowOn(io)
//
//    override fun updateArt(
//        id: Long,
//        url: String,
//        title: String,
//        description: String,
//        price: String,
//        createdAt: LocalDateTime,
//        proprietors: List<String>
//    ): Flow<Long?> =
//        flowOf(database.updateArt(id, url, title, description, price, createdAt, proprietors))
//            .flatMapConcat { lastId() }
//            .flowOn(io)
//
//    override fun getArt(id: Long): Flow<Art?> =
//        flowOf(database.getArtById(id))
//            .map { it.executeAsOneOrNull() }
//            .flowOn(io)
//
//    override fun getArts(): Flow<List<Art>> =
//        flowOf(database.getArts())
//            .map { it.executeAsList() }
//            .flowOn(io)
//
//    private fun lastId(): Flow<Long?> =
//        database.getLastId()
//            .asFlow()
//            .map { it.executeAsOneOrNull() }
//            .flowOn(io)
//}
