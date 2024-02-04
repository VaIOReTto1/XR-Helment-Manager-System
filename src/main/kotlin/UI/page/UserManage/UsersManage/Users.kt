import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 定义用户列表
@Composable
fun UsersFlow() {
    val scrollState = rememberScrollState()
    val users = listOf(
        User("张伟", "13800138000", "市场部", "管理员", "男", "100001", "", UserStatus.Working),
        User("李娜", "13800138001", "财务部", "管理员", "女", "100002", "", UserStatus.NotWorking),
        User("王浩", "13800138002", "人事部", "管理员", "男", "100003", "", UserStatus.InDanger),
        User("刘敏", "13800138003", "技术部", "管理员", "女", "100004", "", UserStatus.Working),
        User("陈晨", "13800138004", "销售部", "管理员", "男", "100005", "", UserStatus.NotWorking),
        User("杨帆", "13800138005", "后勤部", "管理员", "男", "100006", "", UserStatus.InDanger),
        User("赵婷", "13800138006", "行政部", "管理员", "女", "100007", "", UserStatus.Working),
        User("周杰", "13800138007", "客服部", "管理员", "男", "100008", "", UserStatus.NotWorking),
        User("吴雪", "13800138008", "采购部", "管理员", "女", "100009", "", UserStatus.InDanger),
        User("郑晓", "13800138009", "研发部", "管理员", "女", "100010", "", UserStatus.Working),
        User("孙宇", "13800138010", "设计部", "管理员", "男", "100011", "", UserStatus.NotWorking),
        User("周怡", "13800138011", "生产部", "管理员", "女", "100012", "", UserStatus.InDanger),
        User("方大", "13800138012", "物流部", "管理员", "男", "100013", "", UserStatus.Working),
        User("林峰", "13800138013", "维修部", "管理员", "男", "100014", "", UserStatus.NotWorking),
        User("徐梅", "13800138014", "人力资源部", "管理员", "女", "100015", "", UserStatus.InDanger),
        User("何磊", "13800138015", "安全部", "管理员", "男", "100016", "", UserStatus.Working),
        User("高山", "13800138016", "法务部", "管理员", "男", "100017", "", UserStatus.NotWorking),
        User("罗晓", "13800138017", "策划部", "管理员", "女", "100018", "", UserStatus.InDanger),
        User("黄丽", "13800138018", "运营部", "管理员", "女", "100019", "", UserStatus.Working),
        User("韩晨", "13800138019", "市场推广部", "管理员", "男", "100020", "", UserStatus.NotWorking)
    )
    Column(
        modifier = Modifier.fillMaxSize().background(Theme.thirdColor).verticalScroll(scrollState)
            .padding(top = HomePageConfig.box_ContentPadding)
    ) {
        UserDrawerButton("管理员") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                users.forEach {
                    UserCard(user = it)
                }
            }
        }
        UserDrawerButton("专家") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                users.forEach {
                    UserCard(user = it)
                }
            }
        }
        UserDrawerButton("工人") {
            Column(
                modifier = Modifier.background(Theme.thirdColor).padding(bottom = HomePageConfig.box_ContentPadding)
            ) {
                users.forEach {
                    UserCard(user = it)
                }
            }
        }
    }
}


