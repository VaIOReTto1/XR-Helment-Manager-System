package UI

import MineralStatistics
import SideBar
import UI.page.AppBar
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun App() {
    val (isDrawerOpen, setDrawerOpen) = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(onMenuClick = { setDrawerOpen(!isDrawerOpen) }) // 传递setDrawerOpen到AppBar
        // 主内容
        Row {
            AnimatedVisibility(
                visible = isDrawerOpen,
                enter = slideInHorizontally() + fadeIn(),
                exit = slideOutHorizontally() + fadeOut()
            ) {
                SideBar()
            }
            MineralStatistics()
        }
    }
}
