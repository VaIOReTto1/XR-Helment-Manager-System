import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

// 定义用户卡片
@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .padding(start = HomePageConfig.box_RLpadding, end = HomePageConfig.box_RLpadding, top = 6.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Column(
            modifier = Modifier.background(Theme.fourthColor)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier.padding(start = 13.dp)
                        .width(35.dp)
                        .height(45.dp).border(width = 0.5.dp, color = Color(0xFF000000))
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    UserMessage("姓名", user.name)
                    UserMessage("工号", user.id)
                    UserMessage("所属公司", user.department)
                }
                Spacer(modifier = Modifier.weight(1f))
                AppIcon(MyIcons.call, modifier = Modifier.size(35.dp))
                AppIcon(MyIcons.menu, modifier = Modifier.size(40.dp))
                UserStatusTag(user.status)
            }
        }
    }
}

@Composable
fun UserMessage(label: String, value: String) {
    CommonText("$label: $value", 12.sp)
}

// 定义用户状态标签
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
            .background(color, shape = RoundedCornerShape(7.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}