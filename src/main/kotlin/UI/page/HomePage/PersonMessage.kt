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

@Composable
fun PersonMessage() {
    Row(
        Modifier
            .width(410.dp)
            .height(191.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Color(0xFFEEF5FF), shape = RoundedCornerShape(size = 7.dp))
    ) {
        Box(
            modifier = Modifier.padding(start = 40.dp, top = 17.dp, bottom = 16.dp, end = 28.dp)
                .width(115.dp)
                .height(158.dp)
                .border(width = 1.dp, color = Color(0xFF000000)),
        )
        Column(
            Modifier.padding(top = 26.dp, bottom = 25.dp)
        ) {
            Text(
                text = "姓名：xxx",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 29.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(bottom = 28.dp)
            )
            Text(
                text = "所属公司：xxxx",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 29.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(bottom = 28.dp)
            )
            Text(
                text = "职务：管理员",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 29.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
        }
    }
}