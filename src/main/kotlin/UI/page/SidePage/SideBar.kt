import UI.page.SidePage.LogManageDrawerContent
import UI.page.SidePage.UserManageDrawerContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBar() {
    Row {
        Column(
            modifier = Modifier
                .background(Theme.fifthColor)
                .width(Dimensions.SidebarWidth)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // 首页键
            SidebarButton(
                text = "首页",
                iconInfo = MyIcons.home,
                isSelected = Page.selectedPage.title == "首页"
            ) {
                Page.UpdateSelectedPage(AppPage.Home)
            }
            // 系统监控键
            SidebarButton(
                text = "紧急呼救",
                iconInfo = MyIcons.mulUser,
                isSelected = Page.selectedPage.title == "紧急呼救"
            ) {
                Page.UpdateSelectedPage(AppPage.EmergencyCallForHelp)
            }
            // 系统管理键
            DrawerButton(
                text = "用户管理",
                iconInfo = MyIcons.mulPeople,
                expandedContent = { UserManageDrawerContent() }
            ) {
                Page.UpdateSelectedPage(AppPage.User)
            }
            // 系统工具键
            DrawerButton(
                text = "日志管理",
                iconInfo = MyIcons.log,
                expandedContent = { LogManageDrawerContent() }
            ) {
                Page.UpdateSelectedPage(AppPage.UserLog)
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
