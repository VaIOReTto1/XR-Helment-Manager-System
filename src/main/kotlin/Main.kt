import UI.App
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    val isOpen = rememberSaveable { mutableStateOf(true) }
    if (isOpen.value) {
        Window(
            onCloseRequest = {
                isOpen.value = false
            },
            title = "XR智能头盔管理系统",
            state = rememberWindowState(width = 1600.dp, height = 956.dp),
        ) {
            App()
        }
    }
}
