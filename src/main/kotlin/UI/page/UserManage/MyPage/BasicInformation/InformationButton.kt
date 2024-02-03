import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InformationButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val (backgroundColor, contentColor) = ButtonStyle(isSelected)
    Column(
        modifier = Modifier
            .padding(
                start = HomePageConfig.box_RLpadding,
                end = HomePageConfig.box_RLpadding,
                top = HomePageConfig.box_RLpadding
            ).width(120.dp)
            .height(Dimensions.ButtonHeight).background(Color.Transparent)
            .clickable { onClick() },
    ) {
        Text(text, color = Color(contentColor), fontSize = 28.sp)
        Spacer(Modifier.weight(1f))
        if (isSelected) Divider(
            Modifier
                .fillMaxWidth(),
            color = Color(contentColor),
            thickness = 2.dp
        )
    }
}