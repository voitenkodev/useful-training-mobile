//package db
//
//import kotlinx.coroutines.flow.Flow
//import kotlinx.datetime.LocalDateTime
//
//interface AppDataSource {
//
//    fun setArt(
//        url: String,
//        title: String,
//        description: String,
//        price: String,
//        createdAt: LocalDateTime,
//        proprietors: List<String>
//    ): Flow<Long?>
//
//    fun updateArt(
//        id: Long,
//        url: String,
//        title: String,
//        description: String,
//        price: String,
//        createdAt: LocalDateTime,
//        proprietors: List<String>
//    ): Flow<Long?>
//
//    fun getArt(id: Long): Flow<Art?>
//
//    fun getArts(): Flow<List<Art>>
//}
