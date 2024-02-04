import Ticket
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Tickets() {
    val tickets = listOf(
        Ticket("紧急指挥", "张辉", "100001", TicketStatus.Completed, "2024.2.3 19:35"),
        Ticket("紧急指挥", "李娜", "100002", TicketStatus.Completing, "2024.2.4 08:20"),
        Ticket("紧急指挥", "王强", "100003", TicketStatus.UnComplete, "2024.2.5 13:50"),
        Ticket("紧急指挥", "赵敏", "100004", TicketStatus.Completed, "2024.2.6 16:15"),
        Ticket("紧急指挥", "孙悟空", "100005", TicketStatus.Completing, "2024.2.7 09:30"),
        Ticket("紧急指挥", "猪八戒", "100006", TicketStatus.UnComplete, "2024.2.8 11:45"),
        Ticket("紧急指挥", "沙僧", "100007", TicketStatus.Completed, "2024.2.9 14:05"),
        Ticket("紧急指挥", "唐僧", "100008", TicketStatus.Completing, "2024.2.10 17:25"),
        Ticket("紧急指挥", "白骨精", "100009", TicketStatus.UnComplete, "2024.2.11 20:40"),
        Ticket("紧急指挥", "牛魔王", "100010", TicketStatus.Completed, "2024.2.12 06:55"),
        Ticket("紧急指挥", "铁扇公主", "100011", TicketStatus.Completing, "2024.2.13 12:10"),
        Ticket("紧急指挥", "红孩儿", "100012", TicketStatus.UnComplete, "2024.2.14 15:20"),
        Ticket("紧急指挥", "观音菩萨", "100013", TicketStatus.Completed, "2024.2.15 18:35"),
        Ticket("紧急指挥", "如来佛祖", "100014", TicketStatus.Completing, "2024.2.16 21:50"),
        Ticket("紧急指挥", "太上老君", "100015", TicketStatus.UnComplete, "2024.2.17 07:00"),
        Ticket("紧急指挥", "二郎神", "100016", TicketStatus.Completed, "2024.2.18 10:15"),
        Ticket("紧急指挥", "哪吒", "100017", TicketStatus.Completing, "2024.2.19 13:30"),
        Ticket("紧急指挥", "杨戬", "100018", TicketStatus.UnComplete, "2024.2.20 16:45"),
        Ticket("紧急指挥", "雷震子", "100019", TicketStatus.Completed, "2024.2.21 19:55"),
        Ticket("紧急指挥", "托塔天王", "100020", TicketStatus.Completing, "2024.2.22 22:10")
    )
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.background(Theme.thirdColor).fillMaxSize().verticalScroll(scrollState).padding(bottom = HomePageConfig.box_ContentPadding)) {
        tickets.forEach {
            TicketsCard(it)
        }
    }
}