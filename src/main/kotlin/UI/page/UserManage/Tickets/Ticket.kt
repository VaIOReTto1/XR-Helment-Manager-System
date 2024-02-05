data class Ticket(
    val title: String, //标题
    val name: String, //姓名
    val id: String, //工号
    val status: TicketStatus, //状态
    val date: String, //日期
)

enum class TicketStatus {
    Completed, Completing, UnComplete
}