package UI.page.HomePage

import BorderedBox
import CommonText
import MyInformation
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileDetail(label: String, value: String) {
    CommonText("$label: $value", 20.sp)
}

@Composable
fun PersonMessage() {
    BorderedBox(
        Modifier
            .width(410.dp)
            .height(191.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(
                modifier = Modifier.padding(start = HomePageConfig.box_TBpadding, end = HomePageConfig.box_RLpadding)
                    .width(115.dp)
                    .height(158.dp)
                    .border(width = 1.dp, color = Color(0xFF000000)),
            )
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(28.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ProfileDetail("姓名", MyInformation.name)
                ProfileDetail("所属公司", MyInformation.department)
                ProfileDetail("职务", MyInformation.job)
            }
        }
    }
}