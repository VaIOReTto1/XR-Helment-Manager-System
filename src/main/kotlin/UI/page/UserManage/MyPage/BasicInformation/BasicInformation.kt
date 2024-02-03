import UI.page.UserManage.MyPage.BasicInformation.BasicInformationTitle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicInformation() {
    BorderedBox(
        modifier = Modifier.width(960.dp)
            .height(640.dp)
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
            Row {
                InformationButton("基本资料", isShow.value) {
                    isShow.value = true
                }
                InformationButton("修改密码", !isShow.value) {
                    isShow.value = false
                }
            }
            if (isShow.value) BasicInformationList() else ChangePassword()
        }
    }
}