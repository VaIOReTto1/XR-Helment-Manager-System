package UI.page.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import AppIcon
import androidx.compose.ui.graphics.toArgb

@Composable
fun WorkerArea() {
    BorderedBox(
        Modifier.padding(top = HomePageConfig.box_TBpadding)
            .width(538.dp)
            .height(630.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 51.dp, end = 44.dp, bottom = 35.dp),
        ) {
            val scrollState = rememberScrollState()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 5.dp)
            ) {
                AppIcon(
                    MyIcons.mulPeople,
                    modifier = Modifier.padding(end = 28.78.dp).size(40.dp),
                    color = Theme.primaryColor.toArgb().toLong()
                )
                CommonText("工人工作情况", 24.sp)
                Spacer(modifier = Modifier.weight(1f))
                CommonText("应到 4人\n实到 2人", 20.sp)
            }
            Column(
                modifier = Modifier.width(450.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                repeat(10) {
                    WorkerList()
                }
            }
        }
    }
}

// 日志列表
@Composable
fun WorkerList() {
    Row(
        modifier = Modifier
            .width(458.dp)
            .height(112.dp)
            .background(color = Theme.fifthColor).padding(start = 6.dp, end = HomePageConfig.box_TBpadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(start = 11.dp, end = 11.dp)
                .width(70.dp)
                .height(90.dp).border(width = 0.5.dp, color = Color(0xFF000000))
        ) { }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            CommonText("xxx", 28.sp)
            CommonText("无状态", 28.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .width(80.dp)
                .height(40.dp)
                .background(color = Theme.secondColor, shape = RoundedCornerShape(size = 50.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonText("工作中", 24.sp)
        }
    }
}