package UI.page.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons

enum class ThemeChangeColor(val color: Color) {
    firstColor(Color(0xff9EB8D9)),
    secondColor(Color(0xff818FB4)),
    thirdColor(Color(0xff9BBEC8)),
    fourthColor(Color(0xff80B3FF)),
    fifthColor(Color(0xff35A29F)),
    sixthColor(Color(0xff97FFF4)),
    seventhColor(Color(0xffB958A5)),
    eighthColor(Color(0xff424642)),
};

@Composable
fun ThemeChange() {
    Column(
        modifier = Modifier
            .width(680.dp)
            .height(191.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Color(0xFFEEF5FF), shape = RoundedCornerShape(size = 7.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp, top = 12.dp, bottom = 26.5.dp)) {
            AppIcon(
                MyIcons.notes, modifier = Modifier
                    .width(31.73.dp)
                    .height(30.86.dp), color = 0xFFA25772
            )
            Text(
                text = "主题设置",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(start = 22.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 28.dp)) {
            ThemeChangeColor.values().forEach { themeColor ->
                Box(
                    modifier = Modifier.padding(end = 40.dp)
                        .width(40.dp)
                        .height(40.dp)
                        .background(color = themeColor.color, shape = RoundedCornerShape(size = 3.dp))
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "主题颜色",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp).padding(start = 28.dp)
                    .background(color = Color(0xFF7C93C3), shape = RoundedCornerShape(size = 3.dp))
            )
        }
    }
}