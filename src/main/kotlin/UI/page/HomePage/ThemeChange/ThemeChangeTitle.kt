package UI.page.HomePage.ThemeChange

import AppIcon
import CommonText
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 主题切换标题
@Composable
fun ThemeChangeTitle() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(
            start = HomePageConfig.box_TBpadding,
            end = HomePageConfig.box_TBpadding,
            top = 12.dp,
            bottom = 26.5.dp
        )
    ) {
        AppIcon(
            MyIcons.notes, modifier = Modifier.padding(end = 22.dp)
                .width(31.73.dp)
                .height(30.86.dp), color = Theme.primaryColor.toArgb().toLong()
        )
        CommonText("主题切换", 24.sp)
    }
}
