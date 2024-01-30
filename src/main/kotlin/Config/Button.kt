import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb

// 定义按钮的样式
@Composable
fun ButtonStyle(isSelected: Boolean): Pair<Color, Int> {
    val backgroundColor = if (isSelected) Theme.fourthColor else ColorTheme.DefaultBgColor // 选中状态的背景颜色
    val contentColor = if (isSelected) Theme.primaryColor else ColorTheme.DefaultContentColor // 选中状态的文字颜色
    return Pair(backgroundColor, contentColor.toArgb())
}

// 定义按钮的基类
@Composable
fun ButtonBase(
    text: String,
    iconInfo: IconInfo,
    backgroundColor: Color,
    contentColor: Int,
    isSelected: Boolean,
    isDrawerButton: Boolean = false,
    isExpanded: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.ButtonHeight)
            .clickable { onClick() },
        backgroundColor = backgroundColor,
        shape = RectangleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimensions.StartPadding)
        ) {
            // 按钮图标
            AppIcon(iconInfo, Modifier.size(Dimensions.IconSpacing), contentColor.toLong())
            Spacer(Modifier.width(Dimensions.IconSpacing))
            // 按钮文字
            Text(text, color = Color(contentColor), modifier = Modifier.weight(1f))
            // 展开或折叠按钮
            if (isDrawerButton) {
                Icon(
                    if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand or collapse button",
                    tint = Color.Black, // 设置图标的着色
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}


// 定义侧边栏按钮
@Composable
fun SidebarButton(
    text: String,
    iconInfo: IconInfo,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val (backgroundColor, contentColor) = ButtonStyle(isSelected)
    ButtonBase(text, iconInfo, backgroundColor, contentColor, isSelected, onClick = onClick)
}

// 定义抽屉按钮
@Composable
fun DrawerButton(
    text: String,
    iconInfo: IconInfo,
    isSelected: Boolean,
    expandedContent: @Composable () -> Unit = {},
    onClick: () -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    val (backgroundColor, contentColor) = ButtonStyle(isSelected)
    ButtonBase(text, iconInfo, backgroundColor, contentColor, isSelected, true, isExpanded) {
        isExpanded = !isExpanded
        onClick()
    }
    // 动画效果
    AnimatedVisibility(visible = isExpanded) {
        expandedContent()
    }
}

@Composable
fun DrawerContentButton(
    text: String,
    iconInfo: IconInfo,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val (backgroundColor, contentColor) = ButtonStyle(isSelected)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.ButtonHeight)
            .clickable { onClick() },
        backgroundColor = backgroundColor,
        shape = RectangleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // 按钮图标
            AppIcon(iconInfo, Modifier.size(Dimensions.IconSpacing), contentColor.toLong())
            // 按钮文字
            Text(text, color = Color(contentColor), modifier = Modifier.padding(start = Dimensions.IconSpacing))
        }
    }
}
