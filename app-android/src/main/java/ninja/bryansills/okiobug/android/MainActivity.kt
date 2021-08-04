package ninja.bryansills.okiobug.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ninja.bryansills.okiobug.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import ninja.bryansills.okiobug.android.theme.OkioBugTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OkioBugTheme {
                Surface(modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()) {
                    Text(text = "WHADDUP I\'M HERE!")
                }
            }
        }
    }
}
