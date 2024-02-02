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

    Column(modifier = Modifier.padding(top = HomePageConfig.box_RLpadding),
        verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_TBpadding)) {
        UserInputField(label = "*用户昵称：", value = name)
        UserInputField(label = "*手机号码：", value = phone)
        VerificationCodeRow(label = "*获取旧手机验证码：", phone = phone, isNew = false)
        VerificationCodeRow(label = "*获取新手机验证码：", phone = phone, isNew = true)
        GenderSelectionRow(gender = gender)
        ActionButtonsRow(name = name, phone = phone, gender = gender)
    }
}

@Composable
fun UserInputField(label: String, value: MutableState<String>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(start = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CommonText(label, 24.sp)
        BasicTextField(
            modifier = Modifier
                .height(40.dp)
                .width(680.dp)
                .border(1.dp, Color(0xFF000000), RoundedCornerShape(7.dp))
                .background(Color.White, RoundedCornerShape(7.dp))
                .padding(start = 5.dp, top = 3.dp),
            value = value.value,
            onValueChange = { value.value = it },
            textStyle = TextStyle(fontSize = 24.sp),
            singleLine = true
        )
    }
}

@Composable
fun VerificationCodeRow(
    label: String,
    phone: MutableState<String>,
    isNew: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(start = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val captcha = remember { mutableStateOf("") }
        CommonText(label, 24.sp)
        BasicTextField(
            modifier = Modifier
                .height(40.dp)
                .width(210.dp)
                .border(1.dp, Color(0xFF000000), RoundedCornerShape(7.dp))
                .background(Color.White, RoundedCornerShape(7.dp))
                .padding(start = 5.dp, top = 3.dp),
            value = captcha.value,
            onValueChange = { captcha.value = it },
            textStyle = TextStyle(fontSize = 24.sp),
            singleLine = true
        )
        Button(
            onClick = { /* TODO: 实现获取验证码的逻辑 */ },
            modifier = Modifier
                .padding(start = HomePageConfig.box_RLpadding)
                .width(120.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (isNew && phone.value == MyInformation.phone) Color.Gray else Theme.thirdColor
            )
        ) {
            Text("获取验证码")
        }
    }
}

@Composable
fun GenderSelectionRow(
    gender: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
    ) {
        CommonText("                    性别：", 24.sp)
        GenderRadioButton(label = "男", isSelected = gender.value == "男") { gender.value = "男" }
        GenderRadioButton(label = "女", isSelected = gender.value == "女") { gender.value = "女" }
    }
}

@Composable
fun GenderRadioButton(label: String, isSelected: Boolean, onSelect: () -> Unit) {
    val size = 32.dp
    Canvas(modifier = Modifier
        .size(size)
        .clickable { onSelect() }
    ) {
        val circleSize = size.toPx()

        drawCircle(
            color = if (isSelected) Theme.thirdColor else Color.Gray,
            radius = circleSize / 2,
            center = center,
            style = Stroke(width = 1.dp.toPx())
        )

        if (isSelected) {
            drawCircle(
                color = Theme.thirdColor,
                radius = circleSize / 3,
                center = center
            )
        }
    }
    CommonText(label, 24.sp)
}

@Composable
fun ActionButtonsRow(
    name: MutableState<String>,
    phone: MutableState<String>,
    gender: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(start = 228.dp),
        horizontalArrangement = Arrangement.spacedBy(70.dp)
    ) {
        Button(
            onClick = {
                MyInformation.updateInformation(name = name.value, phone = phone.value, gender = gender.value)
            },
            modifier = Modifier.width(80.dp).height(40.dp),
            colors = ButtonDefaults.buttonColors(Theme.thirdColor)
        ) {
            Text("保存")
        }
        Button(
            onClick = {
                name.value = MyInformation.name
                phone.value = MyInformation.phone
                gender.value = MyInformation.gender
            },
            modifier = Modifier.width(80.dp).height(40.dp),
            colors = ButtonDefaults.buttonColors(Theme.redColor)
        ) {
            Text("取消")
        }
    }
}