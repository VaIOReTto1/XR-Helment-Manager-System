import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun PasswordVerifyButton(
    new_password: MutableState<String>,
    verify_password: MutableState<String>,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = modifier.padding(start = 228.dp),
        horizontalArrangement = Arrangement.spacedBy(70.dp)
    ) {
        Button(
            onClick = {
                if (new_password.value == verify_password.value)
                    MyInformation.updateInformation(password = new_password.value)
                else {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            "密码不匹配，请重新输入！"
                        )
                    }
                }
            },
            modifier = Modifier.width(80.dp).height(40.dp),
            colors = ButtonDefaults.buttonColors(Theme.thirdColor)
        ) {
            Text("保存")
        }
        Button(
            onClick = {
                new_password.value = ""
                verify_password.value = ""
            },
            modifier = Modifier.width(80.dp).height(40.dp),
            colors = ButtonDefaults.buttonColors(Theme.redColor)
        ) {
            Text("取消")
        }
    }
}