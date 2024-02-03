import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Message() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize().verticalScroll(scrollState)
            .padding(top = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
    ) {
        repeat(10) {
            Row(
                modifier = Modifier.background(Theme.thirdColor),
                horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
            ) {
                repeat(4) {
                    MessageCard("张伟", "", "2021-01-01 12:00:00")
                }
            }
        }
    }
}