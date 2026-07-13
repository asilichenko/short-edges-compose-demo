package ua.`in`.asilichenko.shortedgescomposedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import ua.`in`.asilichenko.shortedgescomposedemo.ui.theme.ShortEdgesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ShortEdgesTheme {
                ShortEdgesDemoApp()
            }
        }
    }
}

@Composable
fun ShortEdgesDemoApp() {
    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { innerPadding ->
        MainScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 851)
@Composable
fun MainScreenPreview() {
    ShortEdgesTheme {
        ShortEdgesDemoApp()
    }
}

@Composable
fun MainScreen(modifier: Modifier) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Top clicked", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(Alignment.TopCenter)
        ) { Text("Top") }
        Button(
            onClick = {
                Toast.makeText(context, "Bottom clicked", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.align(Alignment.BottomCenter)
        ) { Text("Bottom") }
    }
}