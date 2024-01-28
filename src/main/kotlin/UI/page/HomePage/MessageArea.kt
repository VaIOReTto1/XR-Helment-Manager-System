package UI.page.HomePage

import BorderedBox
import CommonText
import HomePageConfig
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons
import config.Theme

@Composable
fun MessageArea() {
    BorderedBox(
        modifier = Modifier.padding(top = HomePageConfig.box_TBpadding)
            .width(410.dp)
            .height(289.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 40.65.dp, top = 13.4.dp, bottom = 15.dp),
        ) {
            val scrollState = rememberScrollState()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                AppIcon(
                    MyIcons.news,
                    modifier = Modifier.padding(end = 28.78.dp).size(40.dp),
                    color = 0xFFA25772
                )
                CommonText("消息", 24.sp)
            }
            Column(
                modifier = Modifier.verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                repeat(8) {
                    MessageList()
                }
            }
        }
    }
}

// 消息列表
@Composable
fun MessageList() {
    Row(
        modifier = Modifier
            .width(328.dp)
            .height(60.dp)
            .background(color = Theme.fifthColor),
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
            CommonText("xxx", 12.sp)
            CommonText("hhhhhhhh", 16.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.padding(end = 10.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CommonText("今晚19：30", 8.sp)
            Box(
                modifier = Modifier.size(20.dp).clip(CircleShape).background(Theme.secondColor),
                contentAlignment = Alignment.Center
            ) {
                CommonText("1", 12.sp)
            }
        }
    }
}