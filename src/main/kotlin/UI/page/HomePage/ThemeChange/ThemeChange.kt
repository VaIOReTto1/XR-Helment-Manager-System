package UI.page.HomePage.ThemeChange

import UI.page.HomePage.BorderedBox
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 主题切换组件
@Composable
fun ThemeChange() {
    BorderedBox(
        modifier = Modifier
            .width(680.dp)
            .height(191.dp)
    ) {

        Column {
            ThemeChangeTitle() // 标题
            ThemeChangeList() // 主题列表
            DefaultThemeButton() // 默认主题按钮
        }
    }
}