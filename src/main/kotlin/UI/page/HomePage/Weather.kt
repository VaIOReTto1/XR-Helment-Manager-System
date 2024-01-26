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

@Composable
fun Weather() {
    Row(
        modifier = Modifier
            .width(395.dp)
            .height(191.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Color(0xFFEEF5FF), shape = RoundedCornerShape(size = 7.dp))
    ) {
        Column(
            modifier = Modifier.padding(start = 40.dp, top = 8.dp, end = 59.dp, bottom = 11.dp).fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            AppIcon(
                MyIcons.could_day, modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = "29 ℃",
                style = TextStyle(
                    fontSize = 44.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Column(
            modifier = Modifier.padding(top = 17.dp, bottom = 24.dp).fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "2024年",
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 43.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
            Text(
                text = "1月26日",
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 43.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
            Text(
                text = "21 : 19 : 00",
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 43.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
        }
    }
}