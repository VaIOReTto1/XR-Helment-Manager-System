import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun UsersFlow() {
    val users = listOf(
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.NotWorking),
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.NotWorking),
        User("xxxx", UserStatus.InDanger),
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.NotWorking),
        User("xxxx", UserStatus.InDanger),
        User("xxxx", UserStatus.InDanger),
        User("xxxx", UserStatus.NotWorking),
        User("xxxx", UserStatus.InDanger),
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.NotWorking),
        User("xxxx", UserStatus.Working),
        User("xxxx", UserStatus.InDanger),
        User("xxxx", UserStatus.NotWorking),
    )

    LazyColumn {
        items(users.size) { index ->
            UserCard(user = users[index])
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(250.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
                UserStatusTag(status = user.status)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "这里是用户 ${user.name} 的详细信息。",
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun UserStatusTag(status: UserStatus) {
    val (text, color) = when (status) {
        UserStatus.Working -> "工作中" to Color.Green
        UserStatus.NotWorking -> "未工作" to Color.Gray
        UserStatus.InDanger -> "危险中" to Color.Red
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}

enum class UserStatus {
    Working, NotWorking, InDanger
}

data class User(
    val name: String,
    val status: UserStatus
)
