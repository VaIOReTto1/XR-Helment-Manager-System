import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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