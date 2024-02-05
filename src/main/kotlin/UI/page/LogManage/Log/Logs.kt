import UI.page.LogManage.Log.Log
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

/**
 * @param
 * @description: 日志管理
 */
@Composable
fun Logs() {
    val scrollState = rememberScrollState()
    val logs = remember { mutableStateOf(listOf<Log>()) }

    LaunchedEffect(Unit) {
        logs.value = getLogsFromDatabase()
    }

    Column(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize().verticalScroll(scrollState)
            .padding(bottom = HomePageConfig.box_ContentPadding)
    ) {
        logs.value.forEach {
            LogCard(it)
        }
    }
}

/**
 * @param
 * @description: 获取日志列表
 * @return 日志列表
 */
fun getLogsFromDatabase(): List<Log> {
    val logs = mutableListOf<Log>()
    val url = "jdbc:sqlite:db.db"

    DriverManager.getConnection(url).use { conn ->
        val stmt = conn.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM logs ORDER BY time DESC") // 假设你想要按时间降序排序

        while (rs.next()) {
            logs.add(
                Log(
                    should_arrive = rs.getString("should_arrive"),
                    arrived = rs.getString("arrived"),
                    absent = rs.getString("absent"),
                    ask_for_leave = rs.getString("ask_for_leave"),
                    emergency = rs.getString("emergency"),
                    completed_ticket = rs.getString("completed_ticket"),
                    time = rs.getString("time")
                )
            )
        }
    }

    return logs
}