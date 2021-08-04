package ninja.bryansills.okiobug

import okio.ExperimentalFileSystem
import okio.FileSystem
import okio.Path.Companion.toPath

@OptIn(ExperimentalFileSystem::class)
class OkioFileManager(
    private val absoluteFilePath: String,
    private val fileSystem: FileSystem
) {
    fun append(newText: String) {
        fileSystem.write(absoluteFilePath.toPath()) {
            writeUtf8(newText)
        }
    }

    fun read(): String {
        return fileSystem.read(absoluteFilePath.toPath()) {
            readUtf8()
        }
    }
}
