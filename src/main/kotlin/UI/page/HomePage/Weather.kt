package UI.page.HomePage

import BorderedBox
import CommonText
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons

@Composable
fun Weather() {
    BorderedBox(
        modifier = Modifier.width(395.dp)
            .height(191.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.padding(start = 40.dp, top = 8.dp, end = 59.dp, bottom = 11.dp).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                AppIcon(
                    MyIcons.could_day, modifier = Modifier.padding(bottom = 8.dp)
                        .width(100.dp)
                        .height(100.dp)
                )
                CommonText("29 ℃", 44.sp)
            }
            Column(
                modifier = Modifier.padding(top = 22.dp, bottom = 24.dp).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CommonText("2024", 30.sp)
                CommonText("1月26日", 30.sp)
                CommonText("21 : 19 : 00", 30.sp)
            }
        }
    }
}