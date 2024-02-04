import UI.page.LogManage.Log.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Logs(){
    val logs = listOf(
        Log("4", "2", "1", "1", "0", "1", "2024-02-04 08:00"),
        Log("5", "3", "2", "0", "1", "2", "2024-02-04 09:00"),
        Log("6", "4", "0", "1", "0", "3", "2024-02-04 10:00"),
        Log("3", "2", "1", "0", "0", "1", "2024-02-04 11:00"),
        Log("4", "3", "0", "1", "1", "2", "2024-02-04 12:00"),
        Log("5", "2", "1", "0", "0", "2", "2024-02-04 13:00"),
        Log("6", "5", "0", "1", "0", "3", "2024-02-04 14:00"),
        Log("4", "2", "2", "1", "1", "1", "2024-02-04 15:00"),
        Log("3", "1", "1", "0", "0", "1", "2024-02-04 16:00"),
        Log("4", "3", "0", "1", "1", "2", "2024-02-04 17:00"),
        Log("5", "4", "1", "0", "0", "3", "2024-02-04 18:00"),
        Log("6", "2", "2", "1", "0", "2", "2024-02-04 19:00"),
        Log("4", "3", "1", "0", "1", "1", "2024-02-04 20:00"),
        Log("3", "2", "0", "1", "0", "2", "2024-02-04 21:00"),
        Log("4", "1", "1", "0", "0", "3", "2024-02-04 22:00"),
        Log("5", "3", "0", "1", "1", "1", "2024-02-04 23:00"),
        Log("6", "4", "1", "0", "0", "2", "2024-02-05 08:00"),
        Log("4", "2", "0", "1", "1", "3", "2024-02-05 09:00"),
        Log("3", "3", "1", "0", "0", "1", "2024-02-05 10:00"),
        Log("4", "2", "2", "1", "0", "2", "2024-02-05 11:00")
    )
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.background(Theme.thirdColor).fillMaxSize().verticalScroll(scrollState).padding(bottom = HomePageConfig.box_ContentPadding)){
        logs.forEach {
            LogCard(it)
        }
    }
}