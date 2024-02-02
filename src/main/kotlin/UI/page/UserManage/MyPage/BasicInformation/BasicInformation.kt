import UI.page.UserManage.MyPage.BasicInformation.BasicInformationTitle
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicInformation() {
    BorderedBox(
        modifier = Modifier.width(960.dp)
            .height(600.dp)
    ) {
        val isShow = remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BasicInformationTitle()
            Divider(
                Modifier
                    .fillMaxWidth(),
                color = Theme.divideColor,
                thickness = 2.dp
            )
            SidebarButton("基本资料", MyIcons.job, isShow.value) {
                isShow.value = !isShow.value
            }
            if (isShow.value) BasicInformationList() else ChangePassword()
        }
    }
}