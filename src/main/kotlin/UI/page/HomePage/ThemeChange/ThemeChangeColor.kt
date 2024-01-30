package UI.page.HomePage.ThemeChange

import UI.page.HomePage.HomePageConfig
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 主题颜色枚举
enum class ThemeChangeColor(val color: Color) {
    MistyBlue(Color(0xff9EB8D9)),
    SkyBlue(Color(0xff7FC7D9)),
    DeepSapphire(Color(0xFF424769)),
    PaleGreen(Color(0xFFAAD9BB)),
    SlateGreen(Color(0xFF43766C)),
    DarkSienna(Color(0xFF503C3C)),
    PaleApricot(Color(0xFFFFF8E3)),
    PaleRose(Color(0xFFFFE2E2)),
}

// 公共样式框架
@Composable
fun StyledBox(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp)),
        contentAlignment = contentAlignment,
        content = content
    )
}

// 主题颜色选择框
@Composable
fun ThemeChangeColor.asColorBox(
    selectedTheme: ThemeChangeColor?,
    onThemeChange: (ThemeChangeColor) -> Unit
) {
    val themeColor = this
    StyledBox(
        modifier = Modifier
            .padding(end = HomePageConfig.box_TBpadding).shadow(elevation = 5.dp, shape = RoundedCornerShape(size = 7.dp))
            .size(HomePageConfig.box_TBpadding)
            .clickable {
                if (!Theme.isDefaultThemeActivated)
                    onThemeChange(themeColor)
            }.background(color = this.color, shape = RoundedCornerShape(size = 7.dp)),
    ) {
        if (selectedTheme == themeColor && !Theme.isDefaultThemeActivated) {
            Icon(Icons.Filled.Check, contentDescription = "Selected")
        }
    }
}
