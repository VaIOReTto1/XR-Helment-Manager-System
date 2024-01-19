package UI.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xff021039)).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // 使用SpaceBetween来分隔左右两侧的组件
    ) {
        // 左边的组件
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp) // 设置间距为10dp
        ) {
            Text("XR指南头盔管理系统", color = Color.White)
            Icon(Icons.Rounded.Menu, "Menu", tint = Color.White)
            Text("首页", color = Color.White)
        }

        // 右边的组件
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp) // 设置间距为10dp
        ) {
            Icon(Icons.Rounded.ArrowForward, "ArrowForward", tint = Color.White)
            Icon(Icons.Rounded.Notifications, "Notifications", tint = Color.White)
            Icon(Icons.Rounded.Warning, "Warning", tint = Color.White)
            Icon(Icons.Rounded.Person, "Person", tint = Color.White)
        }
    }
}

