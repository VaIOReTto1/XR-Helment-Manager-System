// 定义用户状态
enum class UserStatus {
    Working, NotWorking, InDanger
}

// 定义用户信息
data class User(
    val name: String, //姓名
    val phone: String, //电话
    val department: String, //部门
    val job: String, //职务
    val gender: String, //性别
    val id: String, //工号
    val image: String, //头像
    val status: UserStatus, //状态
)