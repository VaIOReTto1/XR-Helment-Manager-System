
import androidx.compose.runtime.Composable

@Composable
fun PieChartDemo(){
    val dataList = listOf(
        PieData("item1",1065.33f,0xffF2C371),
        PieData("item2",844.18f,0xffEF5E47),
        PieData("item3",241.96f,0xff4E6FD7),
        PieData("item4",451.16f,0xff43B988),
        PieData("item5",641.96f,0xffFF2BE7)
    )
    val dataList1 = listOf(
        PieData("item1",765.33f,0xffF2C371),
        PieData("item2",944.18f,0xffEF5E47),
        PieData("item3",341.96f,0xff4E6FD7),
        PieData("item4",1051.16f,0xff43B988),
        PieData("item5",441.96f,0xffC0C0C0),
        PieData("item6",141.96f,0xffFF2BE7)
    )
    val dataList2 = listOf(
        PieData("item1",365.33f,0xffF2C371),
        PieData("item2",244.18f,0xffEF5E47),
        PieData("item3",541.96f,0xff4E6FD7),
        PieData("item4",952.16f,0xff43B988),
        PieData("item5",1141.96f,0xffFF2BE7),
        PieData("item6",441.96f,0xffC0C0C0)

    )
    val dataList3 = listOf(
        PieData("item1",1065.33f,0xffF2C371),
        PieData("item2",1844.18f,0xffEF5E47),
        PieData("item3",541.96f,0xff4E6FD7),
        PieData("item4",752.16f,0xff43B988),
        PieData("item5",241.96f,0xffFF2BE7)
    )

    PieChart(listOf(dataList,dataList1))
}