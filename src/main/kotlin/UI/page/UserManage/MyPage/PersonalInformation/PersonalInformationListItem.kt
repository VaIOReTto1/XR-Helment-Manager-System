import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonalInformationListItem(item: PersonalInfoItem) {
    Row(
        modifier = Modifier.width(440.dp).height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 显示条目图标
        AppIcon(
            item.icon,
            modifier = Modifier.padding(end = HomePageConfig.box_RLpadding).size(40.dp),
            color = Theme.primaryColor.toArgb().toLong()
        )
        // 显示条目标题
        CommonText(item.title, 28.sp)
        Spacer(modifier = Modifier.weight(1f))
        // 显示条目内容
        CommonText(item.content, 24.sp)
    }
}