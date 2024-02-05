package UI.page.LogManage.Log

data class Log(
    val should_arrive:String, //应到
    val arrived:String, //实到
    val absent:String, //缺勤
    val ask_for_leave:String, //请假
    val emergency:String, //紧急事件
    val completed_ticket:String, //完成工单
    val time:String //时间
)
