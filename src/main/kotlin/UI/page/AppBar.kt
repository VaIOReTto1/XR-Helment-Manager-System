package UI.page

import config.AppIcon
import config.MyIcons
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import config.Theme

@Composable
fun AppBar(onMenuClick: () -> Unit) {
    // 创建观察和响应状态变化的变量
    val isMenuOpen = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Theme.primaryColor)
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
                        isMenuOpen.value = !isMenuOpen.value
                        onMenuClick()
                    })// 点击时，调用onMenuClick函数
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
            AppIcon(MyIcons.notification, Modifier.size(22.dp), 0xffffffff)
            AppIcon(MyIcons.help, Modifier.size(23.dp), 0xffffffff)
            AppIcon(MyIcons.user, Modifier.size(24.dp), 0xffffffff)
        }
    }
}
