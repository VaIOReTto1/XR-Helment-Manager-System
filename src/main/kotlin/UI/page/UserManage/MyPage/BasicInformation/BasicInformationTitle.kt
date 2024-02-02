package UI.page.UserManage.MyPage.BasicInformation

import AppIcon
import CommonText
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicInformationTitle() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(start = HomePageConfig.box_TBpadding, bottom = HomePageConfig.box_RLpadding)
    ) {
        AppIcon(
            MyIcons.job,
            modifier = Modifier.padding(end = 28.78.dp).size(40.dp),
            color = Theme.primaryColor.toArgb().toLong()
        )
        CommonText("基本资料", 24.sp)
    }
}