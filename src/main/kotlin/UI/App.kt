package UI

import MineralStatistics
import SideBar
import UI.page.AppBar
import User
import UsersFlow
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

enum class AppPage {
    Home, SystemManagement, SystemMonitoring, SystemTools
}

@Composable
fun App() {
    val (isDrawerOpen, setDrawerOpen) = remember { mutableStateOf(true) }
    val (selectedPage, setSelectedPage) = remember { mutableStateOf(AppPage.Home) }

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
                SideBar { page ->
                    setSelectedPage(page) // 更新选中的页面
                }
            }
            when (selectedPage) {
                AppPage.Home -> MineralStatistics()
                AppPage.SystemManagement -> UsersFlow()
                AppPage.SystemMonitoring -> MineralStatistics()
                AppPage.SystemTools -> MineralStatistics()
            }
        }
    }
}
