import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun BorderedBox(modifier: Modifier,content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = modifier
            .border(width = 0.5.dp, color = Color(0xFF000000), shape = RoundedCornerShape(size = 7.dp))
            .background(color = Theme.fourthColor, shape = RoundedCornerShape(size = 7.dp)),
        content=content
    )
}

@Composable
fun CommonText(text:String,fontsize:TextUnit){
    Text(
        text = text,
        style = TextStyle(
            fontSize = fontsize,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000)
        )
    )
}

object HomePageConfig{
    val box_RLpadding = 28.dp
    val box_TBpadding = 40.dp
}


