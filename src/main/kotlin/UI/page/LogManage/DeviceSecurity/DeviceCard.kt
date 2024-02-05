import UI.page.LogManage.DeviceSecurity.Device
import UI.page.LogManage.DeviceSecurity.DeviceStatus
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeviceCard(device: Device) {
    Card(
        modifier = Modifier
            .padding(
                start = HomePageConfig.box_RLpadding,
                end = HomePageConfig.box_RLpadding,
                top = HomePageConfig.box_ContentPadding
            )
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Theme.fourthColor).padding(
                start = HomePageConfig.box_RLpadding,
                end = HomePageConfig.box_RLpadding,
                top = HomePageConfig.box_ContentPadding,
                bottom = HomePageConfig.box_ContentPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
        ) {
            Box(
                modifier = Modifier.padding(start = 13.dp)
                    .width(45.dp)
                    .height(45.dp).border(width = 0.5.dp, color = Color(0xFF000000))
            )
            CommonText("设备号：${device.id}", 28.sp)
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End
            ) {
                DeviceStatusTag(device.status)
                CommonText("上次使用时间：${device.last_uesd_time}", 20.sp, color = Color(0xff919191))
            }
        }
    }
}

@Composable
fun DeviceStatusTag(status: DeviceStatus) {
    val (text, color) = when (status) {
        DeviceStatus.Normal -> "无异常" to Theme.thirdColor
        DeviceStatus.Repair -> "维修中" to Color(0xff52D3D8)
        DeviceStatus.Lost -> "已丢失" to Color.Gray
        DeviceStatus.Damaged -> "已损坏" to Theme.redColor
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color, shape = RoundedCornerShape(7.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.Black, fontSize = 20.sp)
    }
}