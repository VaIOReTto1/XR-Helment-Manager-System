package UI.page

import UI.config.AppIcon
import UI.config.MyIcons
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(onMenuClick: () -> Unit) {
    // 注意，我们使用mutableStateOf来创建一个可以观察和响应状态变化的变量
    val isMenuOpen = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xff021039))
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Text("XR指南头盔管理系统", color = Color.White)
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .clickable(onClick = {
                        // 在点击时反转状态，并调用onMenuClick函数
                        isMenuOpen.value = !isMenuOpen.value
                        onMenuClick()
                    })
                    .size(22.dp)
            ) {
                // 根据isMenuOpen的状态决定使用哪个图标
                AppIcon(if (isMenuOpen.value) MyIcons.menuClose else MyIcons.openMenu, Modifier.size(22.dp), 0xffffffff)
            }
            Text("首页", color = Color.White)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AppIcon(MyIcons.enlargement, Modifier.size(20.dp),0xffffffff)
            AppIcon(MyIcons.notification, Modifier.size(22.dp),0xffffffff)
            AppIcon(MyIcons.help, Modifier.size(23.dp),0xffffffff)
            AppIcon(MyIcons.user, Modifier.size(24.dp),0xffffffff)
        }
    }
}
