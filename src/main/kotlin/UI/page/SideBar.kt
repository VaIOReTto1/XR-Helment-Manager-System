import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MainContent() {
    // 状态来控制侧边栏的显示与隐藏
    val (isDrawerOpen, setDrawerOpen) = remember { mutableStateOf(true) }

    // 创建一个水平的布局
    Row {
        // 使用 AnimatedVisibility 来为侧边栏添加动画效果
        AnimatedVisibility(
            visible = isDrawerOpen,
            enter = slideInHorizontally() + fadeIn(), // 从左侧滑入并淡入
            exit = slideOutHorizontally() + fadeOut() // 向左侧滑出并淡出
        ) {
            SideBar(setDrawerOpen)
        }

        // 主内容
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // 这里是主内容，当侧边栏关闭时将占据整个屏幕
            Button(onClick = { setDrawerOpen(!isDrawerOpen) }) {
                Text(if (isDrawerOpen) "关闭侧边栏" else "打开侧边栏")
            }
            // 其他主内容组件
           MineralStatistics()
        }
    }
}

@Composable
fun SideBar(setDrawerOpen: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .fillMaxHeight()
            .background(Color.Gray)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { setDrawerOpen(false) }) {
            Text("关闭")
        }
        // 侧边栏的内容...
        SidebarButton("系统管理", Icons.Filled.Settings)
        DrawerButton("用户管理", Icons.Filled.Person)
        // 其他按钮可以继续添加在这里...
    }
}

@Composable
fun SidebarButton(text: String, icon: ImageVector) {
    Button(
        onClick = { /* TODO: Handle button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
    ) {
        Icon(icon, contentDescription = null) // 添加图标
        Spacer(Modifier.width(8.dp)) // 图标与文字之间的间距
        Text(text)
    }
}

@Composable
fun DrawerButton( text: String, icon: ImageVector) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
        ) {
            Icon(icon, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(text)
            Icon(
                if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null
            )
        }
        // 根据抽屉的展开状态显示内容
        if (expanded) {
            // 抽屉内容的伪代码，应该根据实际内容来定制
            Text("抽屉内的选项1")
            Text("抽屉内的选项2")
            // ...可以继续添加其他选项
        }
    }
}
