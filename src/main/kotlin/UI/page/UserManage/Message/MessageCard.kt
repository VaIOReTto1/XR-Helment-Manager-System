import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageCard(name:String,image:String,time:String){
    Card(
        modifier = Modifier.background(Theme.fifthColor)
            .width(290.dp).height(220.dp),
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(start = HomePageConfig.box_RLpadding, top = 10.dp).fillMaxHeight().background(Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
        ) {
            CommonText(name,28.sp)
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(90.dp).border(width = 0.5.dp, color = Color(0xFF000000))
            )
            CommonText(time,20.sp)
        }
    }
}