package UI.page.HomePage

import BorderedBox
import CommonText
import HomePageConfig
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import config.AppIcon
import config.MyIcons
import config.Theme

@Composable
fun LogArea() {
    BorderedBox(
        Modifier.padding(top = HomePageConfig.box_TBpadding)
            .width(538.dp)
            .height(630.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 51.dp, end = 44.dp, top = 18.91.dp, bottom = 35.dp),
        ) {
            val scrollState = rememberScrollState()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                AppIcon(
                    MyIcons.news,
                    modifier = Modifier.padding(end = 28.78.dp).size(40.dp),
                    color = 0xFFA25772
                )
                CommonText("消息", 24.sp)
            }
            Column(
                modifier = Modifier.background(color = Theme.fifthColor).height(240.dp).width(450.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                repeat(10) {
                    LogList()
                }
            }
            Column(
                modifier = Modifier.padding(top = HomePageConfig.box_TBpadding)
                    .width(451.dp)
                    .height(240.dp).border(width = 0.5.dp, color = Color(0xFF000000))
            ) {}
        }
    }
}

// 日志列表
@Composable
fun LogList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(start = HomePageConfig.box_RLpadding)) {
            CommonText("2024年1月26日应到 4人实到 2人", 24.sp)
        }
        Divider(thickness = 0.5.dp, modifier = Modifier.padding(start = 2.dp, end = 2.dp), color = Theme.secondColor)
    }
}