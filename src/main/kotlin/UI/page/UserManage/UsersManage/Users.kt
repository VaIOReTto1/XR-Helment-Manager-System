import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.sql.DriverManager

/**
 * @param
 * @description: 用户流
 */

@Composable
fun UsersFlow() {
    val scrollState = rememberScrollState() //滚动状态
    val usersMap = remember { mutableStateOf(mapOf<String, List<User>>()) } //用户列表

    // 使用LaunchedEffect在后台加载数据
    LaunchedEffect(Unit) {
        usersMap.value = getUsersFromDatabase()
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Theme.thirdColor).verticalScroll(scrollState)
            .padding(top = HomePageConfig.box_ContentPadding)
    ) {
        UserDrawerButton("管理员") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                usersMap.value["manager"]?.forEach {
                    UserCard(user = it)
                }
            }
        }
        UserDrawerButton("专家") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                usersMap.value["specialist"]?.forEach {
                    UserCard(user = it)
                }
            }
        }
        UserDrawerButton("工人") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                usersMap.value["worker"]?.forEach {
                    UserCard(user = it)
                }
            }
        }
    }
}

/**
 * @param
 * @description: 获取用户列表
 * @return 用户列表
 */
fun getUsersFromDatabase(): Map<String, List<User>> {
    val url = "jdbc:sqlite:db.db" //数据库地址
    // 创建一个懒加载的Connection对象
    val connection by lazy { DriverManager.getConnection(url) }
    // 创建三个列表
    val manager = mutableListOf<User>()
    val specialist = mutableListOf<User>()
    val worker = mutableListOf<User>()

    connection.use { conn ->
        val stmt = conn.createStatement() //创建一个Statement对象
        val rs = stmt.executeQuery("SELECT * FROM users")

        // 遍历结果集
        while (rs.next()) {
            val user = User(
                name = rs.getString("name"),
                phone = rs.getString("phone"),
                department = rs.getString("department"),
                job = rs.getString("job"),
                gender = rs.getString("gender"),
                id = rs.getString("id"),
                image = rs.getString("photo"),
                status = UserStatus.valueOf(rs.getString("status"))
            )

            // 根据用户职务将用户添加到对应的列表中
            when (user.job) {
                "管理员" -> manager.add(user)
                "专家" -> specialist.add(user)
                "工人" -> worker.add(user)
            }
        }
    }

    // 返回数据
    return mapOf(
        "manager" to manager,
        "specialist" to specialist,
        "worker" to worker
    )
}


