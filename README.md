# Android Edge-to-Edge Demo App (Jetpack Compose)

Default layout MainActivity.kt:

```
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()

    setContent {
      ShortEdgesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MainScreen(modifier = Modifier.padding(innerPadding))
        }
      }
    }

  } // onCreate
} // MainActivity
```

<img width="300" alt="vertical" src="https://github.com/user-attachments/assets/cddbbc2e-033c-42dd-9864-eba056ad6539" />

<img height="300" alt="horisontal" src="https://github.com/user-attachments/assets/49b99472-15c9-4368-8f57-212f6a8fc229" />

## Setup color scheme

You may leave themes.xml as is by default.

Add custom color into "ui.theme/Color.kt": `val Emerald = Color(0xFF50C878)`

Set our color as app background for light and dark themes in the "ui.theme/Theme.kt":

```
private val DarkColorScheme = darkColorScheme(
    ...
    background = Emerald,
)

private val LightColorScheme = lightColorScheme(
    ...
    background = Emerald,
)
```

Set "dynamicColor" to false, not to override our themes colors:

```
@Composable
fun ShortEdgesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) { ...
```

## Make background fullscreen

Modify paddings and insets in the MainActivity.kt:

```
Scaffold(
    contentWindowInsets = WindowInsets.safeDrawing,
) { innerPadding ->
    MainScreen(modifier = Modifier.padding(innerPadding))
}
```

<img width="300" alt="vertical" src="https://github.com/user-attachments/assets/cf88a5ac-aadb-4124-b199-e6cea636f51a" />

<img height="300" alt="horisontal" src="https://github.com/user-attachments/assets/fb95abd6-951a-4e89-af63-65e451a6ec53" />

# References
- [Article: Android edge-to-edge layout](https://www.linkedin.com/pulse/android-edge-to-edge-layout-oleksii-sylichenko-foe8f/)
- [Java+XML Demo App Repository](https://github.com/asilichenko/android-short-edges)
- [Display content edge-to-edge in your app](https://developer.android.com/develop/ui/views/layout/edge-to-edge)
- [Support display cutouts](https://developer.android.com/develop/ui/views/layout/display-cutout)
- [Enable edge-to-edge in Compose](https://developer.android.com/develop/ui/compose/layouts/insets)
- [`enableEdgeToEdge()` API](https://developer.android.com/reference/kotlin/androidx/activity/package-summary#enableEdgeToEdge)
- [Support display cutouts](https://developer.android.com/develop/ui/views/layout/display-cutout)
