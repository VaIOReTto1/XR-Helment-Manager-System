package UI

import MineralStatistics
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
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    Row {
        UsersFlow()
        Column {
            Row(
                modifier = Modifier.padding(16.dp), // 添加一些内边距
                horizontalArrangement = Arrangement.spacedBy(8.dp) // 为每个按钮添加间距
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
            MineralStatistics()
        }
        FunctionArea()
    }
}

@Composable
fun FunctionArea() {
    Row(
        modifier = Modifier.width(200.dp).padding(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Notifications,
            "Notifications",
            modifier = Modifier.size(32.dp)
        )
        Icon(
            imageVector = Icons.Rounded.Person,
            "Person",
            modifier = Modifier.size(35.dp)
        )
        Icon(
            imageVector = Icons.Rounded.Settings,
            "Settings",
            modifier = Modifier.size(30.dp)
        )
    }
}