package UI.page.SidePage

import Dimensions
import UI.AppPage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import config.MyIcons
import config.SidebarButton

@Composable
fun SystemDrawer(onPageSelect: (AppPage) -> Unit) {
    var selectedButton by remember { mutableStateOf("首页") }

    Column(
        modifier = Modifier
            .background(ColorTheme.DefaultBgColor)
            .width(Dimensions.SidebarWidth),
    ) {
        val buttons = listOf("首页", "系统管理", "系统监控", "系统工具")
        buttons.forEach { buttonText ->
            val isSelected = selectedButton == buttonText
            // Draw the SidebarButton or DrawerButton here
            Row {
                Box(modifier = Modifier.width(249.dp)) {
                    SidebarButton(
                        text = buttonText,
                        iconInfo = when (buttonText) {
                            "首页" -> MyIcons.home
                            "系统管理" -> MyIcons.setting
                            "系统监控" -> MyIcons.systemMonitor
                            "系统工具" -> MyIcons.systemTool
                            else -> MyIcons.home // Replace with your default icon
                        },
                        isSelected = isSelected,
                    ) {
                        selectedButton = buttonText // Update the selected button
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