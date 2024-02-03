import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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