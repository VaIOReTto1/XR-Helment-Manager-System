package UI

import AppPage
import DeviceSecurity
import HomePage
import Logs
import Messages
import MyPage
import Page
import SideBar
import Theme
import Tickets
import UI.page.EmergencyCallForHelp
import UI.page.XRAppBar
import UsersFlow
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun App() {
    val (isDrawerOpen, setDrawerOpen) = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().background(Theme.thirdColor)
    ) {
        // 顶部栏
        XRAppBar(onMenuClick = { setDrawerOpen(!isDrawerOpen) })
        // 主内容
        Row {
            //动画效果
            AnimatedVisibility(
                visible = isDrawerOpen,
                enter = slideInHorizontally() + fadeIn(),
                exit = slideOutHorizontally() + fadeOut()
            ) {
                SideBar() // 侧边栏
            }
            // 根据当前选中的页面显示不同的内容
            when (Page.selectedPage) {
                AppPage.Home -> HomePage() //首页
                AppPage.Message -> Messages() //消息查看
                AppPage.MyPage -> MyPage() //我的页面
                AppPage.Tickets -> Tickets() //工单详情
                AppPage.User -> UsersFlow() //用户管理
                AppPage.DeviceSecurity -> DeviceSecurity() //设备管理
                AppPage.UserLog -> Logs() //用户日志
                AppPage.EmergencyCallForHelp -> EmergencyCallForHelp() //紧急呼救
            }
        }
    }
}
