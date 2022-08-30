//package temp
//
//import android.content.Context
//import android.graphics.Bitmap
//import android.net.Uri
//import android.os.Environment
//import androidx.core.net.toUri
//import java.io.File
//import java.io.FileOutputStream
//import java.util.UUID
//
//class ImageSaver(private val context: Context) {
//    private fun pictureDirectory(nameFile: String): String =
//        "${context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)}${File.separator}$nameFile.png"
//
//    fun saveToFile(bitmap: Bitmap?): Uri {
//        if (bitmap == null) return Uri.EMPTY
//        val name = UUID.randomUUID().toString()
//        val outStream: FileOutputStream
//        try {
//            outStream = FileOutputStream(pictureDirectory(name))
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream)
//            outStream.flush()
//            outStream.close()
//        } catch (e: Exception) {
//            return Uri.EMPTY
//        }
//        val filepath: String = pictureDirectory(name)
//        val file = File(filepath)
//        return if (file.exists()) file.toUri() else Uri.EMPTY
//    }
//}