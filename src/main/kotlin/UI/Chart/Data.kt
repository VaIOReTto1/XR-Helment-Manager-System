data class LineData(
    val name:String,
    val amount:Float,
    val color: Long = 0xffff0000,
    val lineColor: Long = 0xff000000,
    val groupName:String = ""
)

data class PieData(
    val name:String,
    val amount:Float,
    val color:Long,
)