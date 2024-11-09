import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cn.nyayurin.yutori.document.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("Yutori") {
        App()
    }
}
