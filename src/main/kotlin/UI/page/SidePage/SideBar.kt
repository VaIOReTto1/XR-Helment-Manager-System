import UI.page.SidePage.SystemDrawer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import config.DrawerButton
import config.MyIcons
import config.SidebarButton

@Composable
fun SideBar() {
    // 跟踪当前选中的按钮
    var selectedButton by remember { mutableStateOf("首页") }

    Row {
        Column(
            modifier = Modifier
                .background(ColorTheme.DefaultBgColor)
                .width(Dimensions.SidebarWidth)
                .fillMaxHeight(),
            //verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // 首页键
            SidebarButton(
                text = "首页",
                iconInfo = MyIcons.home,
                isSelected = selectedButton == "首页"
            ) {
                selectedButton = "首页" // Update the selected button
            }
            // 系统管理键
            DrawerButton(
                text = "系统管理",
                iconInfo = MyIcons.setting,
                isSelected = selectedButton == "系统管理",
                { SystemDrawer() }
            ) {
                selectedButton = "系统管理"
            }
            // 系统监控键
            DrawerButton(
                text = "系统监控",
                iconInfo = MyIcons.systemMonitor,
                isSelected = selectedButton == "系统监控"
            ) {
                selectedButton = "系统监控"
            }
            // 系统工具键
            DrawerButton(
                text = "系统工具",
                iconInfo = MyIcons.systemTool,
                isSelected = selectedButton == "系统工具"
            ) {
                selectedButton = "系统工具"
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
