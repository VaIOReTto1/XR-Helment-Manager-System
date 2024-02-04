import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicketsCard(ticket: Ticket) {
    Card(
        modifier = Modifier
            .padding(start = HomePageConfig.box_RLpadding, end = HomePageConfig.box_RLpadding, top = 6.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Theme.fourthColor)
                .padding(HomePageConfig.box_RLpadding).fillMaxWidth(),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
            ) {
                CommonText(ticket.title, 28.sp)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
                ) {
                    CommonText("专家：${ticket.name}", 20.sp)
                    CommonText("工单号：${ticket.id}", 20.sp, color = Color(0xff919191))
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding),
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TicketsStatusTag(ticket.status)
                    AppIcon(MyIcons.menu, modifier = Modifier.size(40.dp))
                }
                CommonText("上次更新时间：${ticket.date}", 20.sp, color = Color(0xff919191))
            }
        }
    }
}

@Composable
fun TicketsStatusTag(status: TicketStatus) {
    val (text, color) = when (status) {
        TicketStatus.Completed -> "已完成" to Theme.thirdColor
        TicketStatus.Completing -> "进行中" to Color(0xff52D3D8)
        TicketStatus.UnComplete -> "未开始" to Color.Gray
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color, shape = RoundedCornerShape(7.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.Black, fontSize = 20.sp)
    }
}