package UI.page.HomePage

import CommonText
import HomePageConfig
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    Row(
        Modifier
            .width(410.dp)
            .height(191.dp)
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Color(0xFFEEF5FF), shape = RoundedCornerShape(size = 7.dp)),
        verticalAlignment = Alignment.CenterVertically
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileDetail("姓名", "xxx")
            ProfileDetail("所属公司", "xxxx")
            ProfileDetail("职务", "管理员")
        }
    }
}