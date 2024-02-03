import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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