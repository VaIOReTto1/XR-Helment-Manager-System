import UI.config.AppIcon
import UI.config.IconInfo
import UI.config.MyIcons
import UI.page.AppBar
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBar(setDrawerOpen: (Boolean) -> Unit) {
    // 使用 Row 组件来包裹 Column 和 Divider
    Row {
        Column(
            modifier = Modifier.background(Color(0xffeeeeeee))
                .width(250.dp)
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // 侧边栏的内容...
            SidebarButton("首页", MyIcons.home, modifier = Modifier.size(19.dp), 0xff000000)
            DrawerButton("系统管理", MyIcons.setting, modifier = Modifier.size(24.dp), 0xff000000)
            DrawerButton("系统监控", MyIcons.systemMonitor, modifier = Modifier.size(22.dp), 0xff000000)
            DrawerButton("系统工具", MyIcons.systemTool, modifier = Modifier.size(19.dp), 0xff000000)
            // 其他按钮可以继续添加在这里...
        }
        // 添加分割线
        Divider(
            color = Color(0xffcccccc), // 分割线的颜色
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp) // 分割线的宽度
        )
    }
}

@Composable
fun SidebarButton(text: String, iconInfo: IconInfo, modifier: Modifier, color: Long) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ) {
            AppIcon(iconInfo, modifier, color)
            Spacer(Modifier.width(18.dp)) // 图标与文字之间的间距
            Text(text, modifier = Modifier.weight(1f)) // Text occupies the space left
            // Spacer has been removed here as it's no longer needed
        }
    }
}

@Composable
fun DrawerButton(text: String, iconInfo: IconInfo, modifier: Modifier, color: Long) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
            ) {
                AppIcon(iconInfo, modifier, color)
                Spacer(Modifier.width(8.dp))
                Text(text, modifier = Modifier.weight(1f)) // Text occupies the space left
                Icon(
                    if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand or collapse button",
                    modifier = Modifier.align(Alignment.CenterVertically) // Align icon vertically
                )
            }
        }
        // Content of the drawer when expanded
        AnimatedVisibility(visible = expanded) {
            Column(modifier = Modifier.fillMaxWidth().padding(start = 48.dp)) {
                // Drawer contents
                Text("抽屉内的选项1")
                Text("抽屉内的选项2")
                // ...可以继续添加其他选项
            }
        }
    }
}
