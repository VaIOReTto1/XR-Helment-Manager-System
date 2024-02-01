import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 个人页面
@Composable
fun MyPage() {
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(top = HomePageConfig.box_TBpadding, start = HomePageConfig.box_TBpadding),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        PersonalInformation()
    }
}