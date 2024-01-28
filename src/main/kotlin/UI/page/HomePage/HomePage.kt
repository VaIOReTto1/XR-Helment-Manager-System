package UI.page.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import config.Theme

@Composable
fun HomePage() {
    Column(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
        ) {
            PersonMessage() // 个人信息
            ThemeChange() // 主题切换
            Weather() // 天气
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
        ){
            Column {
                MessageArea() // 消息
                TicketsArea() // 工单
            }
            LogArea()
        }
    }
}