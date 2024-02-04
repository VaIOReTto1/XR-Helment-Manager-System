import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun UserDrawerButton(
    text: String,
    expandedContent: @Composable () -> Unit = {},
) {
    var isExpanded by remember { mutableStateOf(false) }
    val (backgroundColor, contentColor) = ButtonStyle(isExpanded)
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.ButtonHeight).background(Theme.fifthColor)
            .clickable {
                isExpanded = !isExpanded
            }.padding(horizontal = HomePageConfig.box_RLpadding),
    ) {
        Text(text, color = Color(contentColor), modifier = Modifier.weight(1f), fontSize = 24.sp)
        // 展开或折叠按钮
        Icon(
            if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = "Expand or collapse button",
            tint = Color.Black, // 设置图标的着色
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
    // 动画效果
    AnimatedVisibility(
        visible = isExpanded,
        enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(), // 从上方滑入
    ) {
        expandedContent()
    }
}