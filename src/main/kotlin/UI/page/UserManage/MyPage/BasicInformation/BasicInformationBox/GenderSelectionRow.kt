import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenderSelectionRow(
    gender: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
    ) {
        CommonText("                    性别：", 24.sp)
        GenderRadioButton(label = "男", isSelected = gender.value == "男") { gender.value = "男" }
        GenderRadioButton(label = "女", isSelected = gender.value == "女") { gender.value = "女" }
    }
}

@Composable
fun GenderRadioButton(label: String, isSelected: Boolean, onSelect: () -> Unit) {
    val size = 32.dp
    Canvas(modifier = Modifier
        .size(size)
        .clickable { onSelect() }
    ) {
        val circleSize = size.toPx()

        drawCircle(
            color = if (isSelected) Theme.thirdColor else Color.Gray,
            radius = circleSize / 2,
            center = center,
            style = Stroke(width = 1.dp.toPx())
        )

        if (isSelected) {
            drawCircle(
                color = Theme.thirdColor,
                radius = circleSize / 3,
                center = center
            )
        }
    }
    CommonText(label, 24.sp)
}