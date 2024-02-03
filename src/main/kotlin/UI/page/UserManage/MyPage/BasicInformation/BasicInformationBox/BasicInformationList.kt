import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicInformationList() {
    val name = remember { mutableStateOf(MyInformation.name) }
    val phone = remember { mutableStateOf(MyInformation.phone) }
    val gender = remember { mutableStateOf(MyInformation.gender) }

    Column(
        modifier = Modifier.padding(top = HomePageConfig.box_RLpadding),
        verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_TBpadding)
    ) {
        UserInputField(label = "*用户昵称：", value = name)
        UserInputField(label = "*手机号码：", value = phone)
        VerificationCodeRow(label = "*获取旧手机验证码：", phone = phone, isNew = false)
        VerificationCodeRow(label = "*获取新手机验证码：", phone = phone, isNew = true)
        GenderSelectionRow(gender = gender)
        ActionButtonsRow(name = name, phone = phone, gender = gender)
    }
}