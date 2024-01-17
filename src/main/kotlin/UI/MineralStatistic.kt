import UI.Chart.PieChartDemo
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MineralStatistics() {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState).width(1000.dp).padding(10.dp).height(2000.dp)) {

        PieChartDemo()

        Box(modifier = Modifier.height(100.dp))

        LineChartDemo()
    }
}

