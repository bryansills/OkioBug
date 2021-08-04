package ninja.bryansills.okiobug

import android.content.Context
import okio.ExperimentalFileSystem
import okio.FileSystem
import java.io.File

@ExperimentalFileSystem
actual class OkioFileManagerFactory(private val context: Context) {
    actual fun create(): OkioFileManager {
        val absoluteFilePath = "${fileOutputDirectory.absolutePath}${File.separator}temp.txt"
        return OkioFileManager(absoluteFilePath, FileSystem.SYSTEM)
    }

    // Outputs to /sdcard/Android/media/<PACKAGE_NAME>
    private val fileOutputDirectory: File
        get() {
            val mediaDir = context.applicationContext.externalMediaDirs.firstOrNull()?.let {
                File(it, "CLASH").apply { mkdirs() } }
            return if (mediaDir != null && mediaDir.exists())
                mediaDir else context.applicationContext.filesDir
        }
}
