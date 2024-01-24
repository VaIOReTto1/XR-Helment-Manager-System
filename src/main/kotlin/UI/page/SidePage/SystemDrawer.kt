package UI.page.SidePage

import Dimensions
import UI.AppPage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import config.DrawerContentButton
import config.MyIcons

@Composable
fun SystemDrawer(onPageSelect: (AppPage) -> Unit,selectedPage:AppPage) {
    Column(
        modifier = Modifier
            .background(ColorTheme.DefaultBgColor)
            .width(Dimensions.SidebarWidth),
    ) {
        val buttons = listOf("首页", "系统管理", "系统监控", "系统工具")
        buttons.forEach { buttonText ->
            val isSelected = selectedPage.title == buttonText
            Row {
                Box(modifier = Modifier.width(249.dp)) {
                    DrawerContentButton(
                        text = buttonText,
                        iconInfo = when (buttonText) {
                            "首页" -> MyIcons.home
                            "系统管理" -> MyIcons.setting
                            "系统监控" -> MyIcons.systemMonitor
                            "系统工具" -> MyIcons.systemTool
                            else -> MyIcons.home
                        },
                        isSelected = isSelected,
                    ) {
                        //selectedButton = buttonText
                        onPageSelect(
                            when (buttonText) {
                                "首页" -> AppPage.Home
                                "系统管理" -> AppPage.Home
                                "系统监控" -> AppPage.Home
                                "系统工具" -> AppPage.Home
                                else -> AppPage.Home
                            }
                        )
                    }
                }
            }
        }
    }
}