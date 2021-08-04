package ninja.bryansills.okiobug

import okio.ExperimentalFileSystem
import okio.FileSystem

@ExperimentalFileSystem
actual class OkioFileManagerFactory(private val absoluteFilePath: String) {
    actual fun create(): OkioFileManager {
        return OkioFileManager(absoluteFilePath, FileSystem.SYSTEM)
    }
}
