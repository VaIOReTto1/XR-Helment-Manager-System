package UI.page.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import config.Theme

@Composable
fun HomePage() {
    Column(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize()
            .padding(start = 29.dp, top = 22.dp, end = 30.dp, bottom = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            PersonMessage() // 个人信息
            ThemeChange() // 主题切换
            Weather() // 天气
        }
        Row {
            Column {
                MessageArea() // 消息
            }
        }
    }
}