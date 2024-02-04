import UI.page.LogManage.Log.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogCard(log: Log) {
    Card(
        modifier = Modifier
            .padding(start = HomePageConfig.box_RLpadding, end = HomePageConfig.box_RLpadding, top = HomePageConfig.box_ContentPadding)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_ContentPadding),
            modifier = Modifier.background(Theme.fourthColor).padding(
                start = HomePageConfig.box_RLpadding,
                end = HomePageConfig.box_RLpadding,
                top = HomePageConfig.box_ContentPadding,
                bottom = HomePageConfig.box_ContentPadding
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
            ) {
                CommonText("应到到：${log.should_arrive}人", 28.sp)
                CommonText("已到：${log.arrived}人", 28.sp)
                CommonText("请假：${log.absent}人", 28.sp)
                CommonText("请假：${log.ask_for_leave}人", 28.sp)
                CommonText("紧急事件：${log.emergency}起", 28.sp)
                CommonText("今日完成工单：${log.completed_ticket}件", 28.sp)
            }
            Row {
                Spacer(modifier = Modifier.weight(1f))
                CommonText(log.time, 20.sp, color = Color(0xff919191))
            }
        }
    }
}