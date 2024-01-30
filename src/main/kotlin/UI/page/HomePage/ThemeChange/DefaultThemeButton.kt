package UI.page.HomePage.ThemeChange

import UI.page.HomePage.CommonText
import UI.page.HomePage.HomePageConfig
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 默认主题按钮
@Composable
fun DefaultThemeButton() {
    Row(
        modifier = Modifier.padding(start = HomePageConfig.box_TBpadding, bottom = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.padding(end = HomePageConfig.box_RLpadding)) {
            CommonText("主题颜色", 24.sp)
        }
        StyledBox(
            modifier = Modifier
                .size(HomePageConfig.box_TBpadding)
                .clickable {
                    Theme.activateDefaultTheme()
                }.background(
                    if (Theme.isDefaultThemeActivated) Color.White else Color(0xFF9EB8D9),
                    shape = RoundedCornerShape(size = 7.dp)
                ),
        ) {
            if (!Theme.isDefaultThemeActivated) {
                Icon(Icons.Filled.Check, contentDescription = "Activated")
            }
        }
    }
}