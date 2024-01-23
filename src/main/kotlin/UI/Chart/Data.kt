data class LineData(
    val name:String,
    val amount:Float,
    val color: Long = 0xffff0000,
    val lineColor: Long = 0xff000000,
    val groupName:String = ""
)

data class LineModel(
    val startX: Float,
    val startY: Float,
    val endX: Float,
    val endY: Float,
    val color: Long
)

data class PieData(
    val name:String,
    val amount:Float,
    val color:Long,
)