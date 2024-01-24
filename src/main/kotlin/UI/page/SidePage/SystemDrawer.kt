package UI.page.SidePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import config.MyIcons
import config.SidebarButton

@Composable
fun SystemDrawer() {
    var selectedButton by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()
            .background(ColorTheme.DefaultBgColor)
            .width(Dimensions.SidebarWidth),
        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
        SidebarButton(
            text = "首页",
            iconInfo = MyIcons.home,
            isSelected = selectedButton == "首页"
        ) {
            selectedButton = "首页" // Update the selected button
        }
    }
}