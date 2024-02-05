import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.sql.DriverManager
import java.text.SimpleDateFormat

/**
 * @param
 * @description: 工单流
 */
@Composable
fun Tickets() {
    // 状态和LaunchedEffect用于在后台加载数据
    val tickets = remember { mutableStateOf(listOf<Ticket>()) }

    // 使用LaunchedEffect在后台加载数据
    LaunchedEffect(Unit) {
        tickets.value = getTicketsFromDatabase()
    }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize().verticalScroll(scrollState)
            .padding(bottom = HomePageConfig.box_ContentPadding)
    ) {
        tickets.value.forEach {
            TicketsCard(it)
        }
    }
}

/**
 * @param
 * @description: 获取工单列表
 * @return 工单列表
 */
fun getTicketsFromDatabase(): List<Ticket> {
    val tickets = mutableListOf<Ticket>()
    val url = "jdbc:sqlite:db.db"

    DriverManager.getConnection(url).use { conn ->
        val stmt = conn.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM tickets")

        // 遍历结果集
        while (rs.next()) {
            tickets.add(
                Ticket(
                    title = rs.getString("title"),
                    name = rs.getString("name"),
                    id = rs.getString("id"),
                    status = TicketStatus.valueOf(rs.getString("status")),
                    date = rs.getString("date")
                )
            )
        }
    }

    // 自定义排序逻辑
    val sortedTickets = tickets.sortedWith(compareBy<Ticket> {
        when (it.status) {
            TicketStatus.UnComplete -> 1 // 未开始的在中间
            TicketStatus.Completing -> 0 // 进行中的在最前面
            TicketStatus.Completed -> 2 // 完成的在最后
        }
    }.thenBy { it.id.toInt() }) // 然后按照id从小到大排序

    return sortedTickets
}