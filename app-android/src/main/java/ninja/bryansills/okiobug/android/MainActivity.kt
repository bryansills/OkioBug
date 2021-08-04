package ninja.bryansills.okiobug.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ninja.bryansills.okiobug.Greeting
import ninja.bryansills.okiobug.OkioFileManagerFactory
import ninja.bryansills.okiobug.android.theme.OkioBugTheme
import java.util.Date

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var buttonTitle by remember { mutableStateOf("EMPTY") }
            val fileManager = OkioFileManagerFactory(LocalContext.current).create()

            OkioBugTheme {
                Surface(modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()) {
                    Button(onClick = {
                        val timeStamp = Date().toString()
                        fileManager.append(timeStamp)
                        buttonTitle = fileManager.read()
                    }) {
                        Text(text = buttonTitle)
                    }
                }
            }
        }
    }
}
