package UI.page.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons
import config.Theme

@Composable
fun MessageArea() {
    Column(
        modifier = Modifier.padding(top = 41.dp)
            .width(410.dp)
            .height(289.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Color(0xFFEEF5FF), shape = RoundedCornerShape(size = 7.dp))
            .padding(start = 40.65.dp, top = 13.4.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppIcon(
                MyIcons.news,
                modifier = Modifier.padding(end = 28.78.dp).size(40.dp),
                color = 0xFFA25772
            )
            Text(
                text = "消息",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )
        }
        repeat(3) {
            Row(
                modifier = Modifier
                    .width(328.dp)
                    .height(60.dp)
                    .background(color = Color(0xFFFFFFFB)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.padding(start = 13.dp, end = 20.dp)
                        .width(35.dp)
                        .height(45.dp).border(width = 0.5.dp, color = Color(0xFF000000))
                ) { }
                Column(
                    modifier = Modifier.padding(top = 6.dp, end = 16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "xxx",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000)
                        )
                    )
                    Text(
                        text = "hhhhhhh",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000)
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 10.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "今天19：30",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000)
                        )
                    )
                    Box(
                        modifier = Modifier.size(20.dp).clip(CircleShape).background(Theme.secondColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight(200),
                                color = Color(0xFFFFFFFF)
                            )
                        )
                    }
                }
            }
        }
    }
}