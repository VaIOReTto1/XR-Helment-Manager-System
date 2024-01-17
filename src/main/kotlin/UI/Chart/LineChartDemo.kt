import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val screenWidth = 600.dp
val screenHeight = 600.dp

@Composable
fun LineChartDemo(){
    val dataList = listOf(
        LineData("2019",1065.33f, lineColor = 0xffF2C371, groupName = "矿物A"),
        LineData("2020",844.18f, lineColor = 0xffF2C371, groupName = "矿物A"),
        LineData("2021",241.96f, lineColor = 0xffF2C371, groupName = "矿物A"),
        LineData("2022",451.16f, lineColor = 0xffF2C371, groupName = "矿物A"),
        LineData("2023",641.96f, lineColor = 0xffF2C371, groupName = "矿物A")
    )
    val dataList1 = listOf(
        LineData("2019",765.33f, lineColor = 0xff4E6FD7, groupName = "矿物B"),
        LineData("2020",944.18f, lineColor = 0xff4E6FD7, groupName = "矿物B"),
        LineData("2021",441.96f, lineColor = 0xff4E6FD7, groupName = "矿物B"),
        LineData("2022",1051.16f, lineColor = 0xff4E6FD7, groupName = "矿物B"),
        LineData("2023",441.96f, lineColor = 0xff4E6FD7, groupName = "矿物B"),
    )
    val dataList2 = listOf(
        LineData("2019",365.33f, lineColor = 0xffFF2BE7, groupName = "矿物C"),
        LineData("2020",244.18f, lineColor = 0xffFF2BE7, groupName = "矿物C"),
        LineData("2021",541.96f, lineColor = 0xffFF2BE7, groupName = "矿物C"),
        LineData("2022",952.16f, lineColor = 0xffFF2BE7, groupName = "矿物C"),
        LineData("2023",1141.96f, lineColor = 0xffFF2BE7, groupName = "矿物C"),

        )
    val dataList3 = listOf(
        LineData("2019",1455.33f, lineColor = 0xff43B988, groupName = "矿物D"),
        LineData("2020",1844.18f, lineColor = 0xff43B988, groupName = "矿物D"),
        LineData("2021",941.96f, lineColor = 0xff43B988, groupName = "矿物D"),
        LineData("2022",752.16f, lineColor = 0xff43B988, groupName = "矿物D"),
        LineData("2023",241.96f, lineColor = 0xff43B988, groupName = "矿物D")
    )

    var checkState2 by remember { mutableStateOf(false) }
    var checkState3 by remember { mutableStateOf(false) }
    var checkState4 by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(0.6f).height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text="矿物B")
                Checkbox(checked = checkState2, onCheckedChange = {
                    checkState2 = it
                }, modifier = Modifier.padding(5.dp).size(30.dp),colors = CheckboxDefaults.colors())
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text="矿物C")
                Checkbox(checked = checkState3, onCheckedChange = {
                    checkState3 = it
                }, modifier = Modifier.padding(5.dp).size(30.dp),colors = CheckboxDefaults.colors())
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text="矿物D")
                Checkbox(checked = checkState4, onCheckedChange = {
                    checkState4 = it
                }, modifier = Modifier.padding(5.dp).size(30.dp),colors = CheckboxDefaults.colors())
            }

        }
        val payloads = mutableListOf( dataList)
        if(checkState2)payloads.add(dataList1)
        if(checkState3)payloads.add(dataList2)
        if(checkState4)payloads.add(dataList3)
        LineChart(payloads, modifier = Modifier.height(500.dp).width(700.dp))
    }
}
