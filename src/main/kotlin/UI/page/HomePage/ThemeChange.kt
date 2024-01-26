package UI.page.HomePage

import BorderedBox
import CommonText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons

// 主题切换
enum class ThemeChangeColor(val color: Color) {
    FirstColor(Color(0xff9EB8D9)),
    SecondColor(Color(0xff818FB4)),
    ThirdColor(Color(0xff9BBEC8)),
    FourthColor(Color(0xff80B3FF)),
    FifthColor(Color(0xff35A29F)),
    SixthColor(Color(0xff97FFF4)),
    SeventhColor(Color(0xffB958A5)),
    EighthColor(Color(0xff424642)),
}

// 主题切换
@Composable
fun ThemeChangeColor.asColorBox() {
    Box(
        modifier = Modifier
            .padding(end = 40.dp)
            .size(40.dp)
            .background(color = this.color, shape = RoundedCornerShape(size = 3.dp))
    )
}

@Composable
fun ThemeChange() {
    BorderedBox(
        modifier = Modifier
            .width(680.dp)
            .height(191.dp)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp, top = 12.dp, bottom = 26.5.dp)) {
                AppIcon(
                    MyIcons.notes, modifier = Modifier.padding(end = 22.dp)
                        .width(31.73.dp)
                        .height(30.86.dp), color = 0xFFA25772
                )
                CommonText("主题切换", 24.sp)
            }
            Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 28.dp)) {
                ThemeChangeColor.values().forEach { themeColor ->
                    themeColor.asColorBox()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CommonText("主题颜色", 24.sp)
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp).padding(start = 28.dp)
                        .background(color = Color(0xFF7C93C3), shape = RoundedCornerShape(size = 3.dp))
                )
            }
        }
    }
}