package UI

import MainContent
import MineralStatistics
import SideBar
import UI.page.AppBar
import UsersFlow
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
                SideBar(setDrawerOpen)
            }
            MineralStatistics()
        }
    }
}
