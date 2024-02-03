// 定义用户状态
enum class UserStatus {
    Working, NotWorking, InDanger
}

// 定义用户信息
data class User(
    val name: String,
    val phone: String,
    val department: String,
    val job: String,
    val gender: String,
    val id: String,
    val photo: String,
    val status: UserStatus,
)