package UI

import MineralStatistics
import UI.page.AppBar
import UsersFlow
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    Column {
        AppBar()
        Row {
            Column (
                modifier = Modifier.padding(16.dp), // 添加一些内边距
                verticalArrangement = Arrangement.spacedBy(8.dp) // 为每个按钮添加间距
            ) {
                repeat(6) {
                    Button(
                        onClick = {}, modifier = Modifier.width(170.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffFFFBF0))
                    ) {
                        Text("按钮")
                    }
                }
            }
            UsersFlow()
            Column {
                MineralStatistics()
            }
        }
    }
}
