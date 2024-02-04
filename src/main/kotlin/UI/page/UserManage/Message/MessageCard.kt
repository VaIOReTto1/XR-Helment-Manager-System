import UI.page.UserManage.Message.Message
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageCard(message: Message) {
    Card(
        modifier = Modifier.background(Theme.fourthColor, shape = RoundedCornerShape(7.dp))
            .width(290.dp).height(220.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Column(
            modifier = Modifier.background(Theme.fourthColor).padding(start = HomePageConfig.box_RLpadding, top = 10.dp).fillMaxHeight()
                ,
            verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
        ) {
            CommonText(message.name, 28.sp)
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(90.dp).border(width = 0.5.dp, color = Color(0xFF000000))
            )
            CommonText(message.time, 20.sp, color = Color(0xff919191))
        }
    }
}