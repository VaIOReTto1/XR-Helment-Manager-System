package UI.page.HomePage


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons


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
                    lineHeight = 35.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(start = 22.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 28.dp)) {
            repeat(8) {
                Box(
                    modifier = Modifier.padding(end = 40.dp)
                        .width(40.dp)
                        .height(40.dp)
                        .background(color = Color(0xFF7C93C3), shape = RoundedCornerShape(size = 3.dp))
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, bottom = 18.dp)) {
            Text(
                text = "主题颜色",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 35.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp).padding(start = 28.dp, end = 40.dp)
                    .background(color = Color(0xFF7C93C3), shape = RoundedCornerShape(size = 3.dp))
            )
        }
    }
}