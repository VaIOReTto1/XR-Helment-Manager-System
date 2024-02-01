package UI.page.SidePage

import DrawerContentButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogManageDrawerContent() {
    Column(
        modifier = Modifier
            .background(ColorTheme.DefaultBgColor)
            .width(Dimensions.SidebarWidth),
    ) {
        val buttons = listOf("用户日志", "设备管理")
        buttons.forEach { buttonText ->
            val isSelected = Page.selectedPage.title == buttonText
            Row {
                Box(modifier = Modifier.width(249.dp)) {
                    DrawerContentButton(
                        text = buttonText,
                        iconInfo = when (buttonText) {
                            "设备管理" -> MyIcons.serviceControl
                            "用户日志" -> MyIcons.log
                            else -> MyIcons.home
                        },
                        isSelected = isSelected,
                    ) {
                        Page.UpdateSelectedPage(
                            when (buttonText) {
                                "设备管理" -> AppPage.DeviceSecurity
                                "用户日志" -> AppPage.UserLog
                                else -> AppPage.Home
                            }
                        )
                    }
                }
            }
        }
    }
}