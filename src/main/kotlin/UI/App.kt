package UI

import AppPage
import HomePage
import MyPage
import Page
import SideBar
import UI.page.EmergencyCallForHelp
import UI.page.LogManage.DeviceSecurity
import UI.page.LogManage.UserLog
import UI.page.UserManage.Message
import UI.page.UserManage.Tickets
import UI.page.UserManage.UsersFlow
import UI.page.XRAppBar
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun App() {
    val (isDrawerOpen, setDrawerOpen) = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
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
                AppPage.Message -> Message() //消息查看
                AppPage.MyPage -> MyPage() //我的页面
                AppPage.Tickets -> Tickets() //工单详情
                AppPage.User -> UsersFlow() //用户管理
                AppPage.DeviceSecurity -> DeviceSecurity() //设备管理
                AppPage.UserLog -> UserLog() //用户日志
                AppPage.EmergencyCallForHelp -> EmergencyCallForHelp() //紧急呼救
            }
        }
    }
}
