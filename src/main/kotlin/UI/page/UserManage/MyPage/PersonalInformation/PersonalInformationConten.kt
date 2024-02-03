import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 个人信息内容
@Composable
fun PersonalInformationContent() {
    // 使用数据类创建个人信息的列表
    val list = listOf(
        PersonalInfoItem(MyIcons.user, "用户名称", MyInformation.name),
        PersonalInfoItem(MyIcons.id, "童虎工号", MyInformation.id),
        PersonalInfoItem(MyIcons.phone, "手机号码", MyInformation.phone),
        PersonalInfoItem(MyIcons.department, "所属部门", MyInformation.department),
        PersonalInfoItem(MyIcons.mulPeople, "所属角色", MyInformation.job),
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        list.forEach { item ->
            // 对每个列表项添加分隔线
            Divider(
                Modifier
                    .width(440.dp),
                color = Theme.divideColor,
                thickness = 0.5.dp
            )
            // 创建并显示个人信息列表项
            PersonalInformationListItem(item)
        }
        Divider(
            Modifier
                .width(440.dp),
            color = Theme.divideColor,
            thickness = 0.5.dp
        )
    }
}