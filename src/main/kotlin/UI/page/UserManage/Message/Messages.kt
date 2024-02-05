import UI.page.UserManage.Message.Message
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.sql.DriverManager

/**
 * @param
 * @description: 消息流
 */
@Composable
fun Messages() {
    val scrollState = rememberScrollState()
    // 创建一个mutableStateOf对象
    val messages = remember { mutableStateOf(listOf<Message>()) }

    // 使用LaunchedEffect在后台加载数据
    LaunchedEffect(Unit) {
        messages.value = getMessagesFromDatabase()
    }

    // 使用LazyVerticalGrid显示消息
    LazyVerticalGrid(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize().padding(HomePageConfig.box_ContentPadding),
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding),
        horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
    ) {
        items(messages.value.size) { index ->
            MessageCard(messages.value[index])
        }
    }
}

/**
 * @param
 * @description: 获取消息列表
 * @return 消息列表
 */
fun getMessagesFromDatabase(): List<Message> {
    val messages = mutableListOf<Message>()
    val url = "jdbc:sqlite:db.db"

    DriverManager.getConnection(url).use { conn ->
        val stmt = conn.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM messages ORDER BY time DESC")

        while (rs.next()) {
            messages.add(
                Message(
                    name = rs.getString("name"),
                    image = rs.getString("image"),
                    time = rs.getString("time")
                )
            )
        }
    }

    return messages
}