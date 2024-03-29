package UI.page.HomePage

import AppIcon
import BorderedBox
import CommonText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicketsArea() {
    BorderedBox(
        modifier = Modifier.padding(top = 52.dp)
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
                    MyIcons.calendar,
                    modifier = Modifier.padding(end = 28.78.dp).size(45.dp),
                    color = Theme.primaryColor.toArgb().toLong()
                )
                CommonText("工单", 24.sp)
            }
            Column(
                modifier = Modifier.verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                repeat(8) {
                    TicketsList()
                }
            }
        }
    }
}

// 工单列表
@Composable
fun TicketsList() {
    Row(
        modifier = Modifier
            .width(328.dp)
            .height(60.dp)
            .background(color = Theme.fifthColor).padding(start = HomePageConfig.box_ContentPadding, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CommonText("工单", 28.sp)
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .width(66.dp)
                .height(27.dp)
                .background(color = Theme.secondColor, shape = RoundedCornerShape(size = 50.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonText("已完成", 14.sp)
        }
    }
}