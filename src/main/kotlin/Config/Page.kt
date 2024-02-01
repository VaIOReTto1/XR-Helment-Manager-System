import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class AppPage(val title: String) {
    Home("首页"),
    Message("消息查看"),
    MyPage("个人页面"),
    Tickets("工单详情"),
    User("用户管理"),
    EmergencyCallForHelp("紧急呼救"),
    DeviceSecurity("设备管理"),
    UserLog("用户日志")
}

object Page{
    var selectedPage by mutableStateOf(AppPage.Home)

    fun UpdateSelectedPage(appPage: AppPage){
        selectedPage=appPage
    }
}