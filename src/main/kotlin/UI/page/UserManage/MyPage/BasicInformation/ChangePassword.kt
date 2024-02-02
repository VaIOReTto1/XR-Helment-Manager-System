import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch

@Composable
fun ChangePassword() {
    val new_password = remember { mutableStateOf("") }
    val verify_password = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf(MyInformation.phone) }
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.background(Theme.fourthColor).padding(top = HomePageConfig.box_RLpadding).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_TBpadding),
        ) {
            UserInputField(label = "*新的密码：", value = new_password)
            UserInputField(label = "*确认密码：", value = verify_password)
            VerificationCodeRow(label = "   *验证码：", phone = phone, isNew = false)
            PasswordVerifyButton(new_password, verify_password, scaffoldState)
        }
    }
}

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