package UI.page.SidePage

import AppPage
import Dimensions
import DrawerContentButton
import Page
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserManageDrawerContent() {
    Column(
        modifier = Modifier
            .background(ColorTheme.DefaultBgColor)
            .width(Dimensions.SidebarWidth),
    ) {
        val buttons = listOf("用户管理", "消息查看", "工单详情", "个人页面")
        buttons.forEach { buttonText ->
            val isSelected = Page.selectedPage.title == buttonText
            Row {
                Box(modifier = Modifier.width(249.dp)) {
                    DrawerContentButton(
                        text = buttonText,
                        iconInfo = when (buttonText) {
                            "用户管理" -> MyIcons.mulPeople
                            "消息查看" -> MyIcons.news
                            "工单详情" -> MyIcons.calendar
                            "个人页面" -> MyIcons.user
                            else -> MyIcons.home
                        },
                        isSelected = isSelected,
                    ) {
                       Page.UpdateSelectedPage(
                            when (buttonText) {
                                "用户管理" -> AppPage.User
                                "消息查看" -> AppPage.Message
                                "工单详情" -> AppPage.Tickets
                                "个人页面" -> AppPage.MyPage
                                else -> AppPage.Home
                            }
                        )
                    }
                }
            }
        }
    }
}