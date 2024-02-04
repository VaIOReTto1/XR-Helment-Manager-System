package UI.page.LogManage.Log

data class Log(
    val should_arrive:String,
    val arrived:String,
    val absent:String,
    val ask_for_leave:String,
    val emergency:String,
    val completed_ticket:String,
    val time:String
)
