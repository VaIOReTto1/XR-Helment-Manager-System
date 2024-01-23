package config

import ColorTheme
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

// 定义按钮的样式
@Composable
fun ButtonStyle(isSelected: Boolean): Triple<Color, Int, Color> {
    val backgroundColor = if (isSelected) ColorTheme.SelectedBgColor else ColorTheme.DefaultBgColor // 选中状态的背景颜色
    val contentColor = if (isSelected) ColorTheme.SelectedContentColor else ColorTheme.DefaultContentColor // 选中状态的文字颜色
    val borderColor = if (isSelected) ColorTheme.BorderColor else ColorTheme.Transparent // 选中状态的边框颜色
    return Triple(backgroundColor, contentColor.toArgb(), borderColor)
}

// 定义按钮的基类
@Composable
fun ButtonBase(
    text: String,
    iconInfo: IconInfo,
    backgroundColor: Color,
    contentColor: Int,
    borderColor: Color,
    isSelected: Boolean,
    isDrawerButton: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.ButtonHeight)
            .border(BorderStroke(1.dp, borderColor)),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
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
                    if (isSelected) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand or collapse button",
                    tint = Color.Black, // 设置图标的着色
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            // 选中状态的按钮，添加一个宽度为5dp的灰色条纹
            if (isSelected && !isDrawerButton) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(5.dp)
                        .fillMaxHeight()
                        .background(Color(contentColor))
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
    val (backgroundColor, contentColor, borderColor) = ButtonStyle(isSelected)
    ButtonBase(text, iconInfo, backgroundColor, contentColor, borderColor, isSelected, onClick = onClick)
}

// 定义抽屉按钮
@Composable
fun DrawerButton(
    text: String,
    iconInfo: IconInfo,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val (backgroundColor, contentColor, borderColor) = ButtonStyle(isSelected)
    ButtonBase(text, iconInfo, backgroundColor, contentColor, borderColor, isSelected, true) {
        isExpanded=!isExpanded
        onClick()
    }
    // 动画效果
    AnimatedVisibility(visible = isExpanded) {
        DrawerContent()
    }
}

// 定义抽屉内容
@Composable
fun DrawerContent() {
    Column(modifier = Modifier.fillMaxWidth().padding(start = Dimensions.DrawerIndent)) {
        Text("抽屉内的选项1", color = ColorTheme.DefaultContentColor)
        Text("抽屉内的选项2", color = ColorTheme.DefaultContentColor)
    }
}
