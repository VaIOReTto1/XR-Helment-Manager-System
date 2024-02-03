import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 个人信息
@Composable
fun PersonalInformation() {
    BorderedBox(
        modifier = Modifier.width(520.dp)
            .height(750.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PersonalInformationTitle()
            Divider(
                Modifier
                    .fillMaxWidth(),
                color = Theme.divideColor,
                thickness = 2.dp
            )
            Box(
                modifier = Modifier.padding(bottom = HomePageConfig.box_TBpadding, top = HomePageConfig.box_RLpadding)
                    .width(105.dp)
                    .height(135.dp)
                    .border(width = 1.dp, color = Color(0xFF000000)),
            )
            PersonalInformationContent()
        }
    }
}