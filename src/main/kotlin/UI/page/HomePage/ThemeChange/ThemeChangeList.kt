package UI.page.HomePage.ThemeChange

import UI.page.HomePage.HomePageConfig
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

// 主题切换列表
@Composable
fun ThemeChangeList() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = HomePageConfig.box_TBpadding, bottom = HomePageConfig.box_RLpadding)
    ) {
        val selectedTheme = remember { mutableStateOf(ThemeChangeColor.MistyBlue) }
        ThemeChangeColor.values().forEach { themeColor ->
            themeColor.asColorBox(
                selectedTheme = selectedTheme.value,
                onThemeChange = { selected ->
                    Theme.changeTheme(selected)
                    selectedTheme.value = selected
                }
            )
        }
    }
}