import UI.AppPage
import UI.page.SidePage.SystemManagementDrawer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBar(selectedPage: AppPage, onPageSelect: (AppPage) -> Unit) {
    Row {
        Column(
            modifier = Modifier
                .background(ColorTheme.DefaultBgColor)
                .width(Dimensions.SidebarWidth)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // 首页键
            SidebarButton(
                text = "首页",
                iconInfo = MyIcons.home,
                isSelected = selectedPage.title == "首页"
            ) {
                onPageSelect(AppPage.SystemManagement)
            }
            // 系统管理键
            DrawerButton(
                text = "系统管理",
                iconInfo = MyIcons.setting,
                isSelected = selectedPage.title == "系统管理",
                { SystemManagementDrawer(onPageSelect, selectedPage) }
            ) {
                onPageSelect(AppPage.SystemManagement)
            }
            // 系统监控键
            DrawerButton(
                text = "系统监控",
                iconInfo = MyIcons.systemMonitor,
                isSelected = selectedPage.title == "系统监控"
            ) {
                onPageSelect(AppPage.SystemMonitoring)
            }
            // 系统工具键
            DrawerButton(
                text = "系统工具",
                iconInfo = MyIcons.systemTool,
                isSelected = selectedPage.title == "系统工具"
            ) {
                onPageSelect(AppPage.SystemTools)
            }
        }
        // 分割线
        Divider(
            color = Color(0xffcccccc),
            modifier = Modifier
                .fillMaxHeight()
                .width(Dimensions.DividerWidth)
        )
    }
}
