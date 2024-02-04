import UI.page.UserManage.Message.Message
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Messages() {
    val scrollState = rememberScrollState()
    val messages = listOf(
        Message("Alice", "https://example.com/image1.jpg", "2024-02-04 08:00"),
        Message("Bob", "https://example.com/image2.jpg", "2024-02-04 08:15"),
        Message("Charlie", "https://example.com/image3.jpg", "2024-02-04 08:30"),
        Message("David", "https://example.com/image4.jpg", "2024-02-04 08:45"),
        Message("Eva", "https://example.com/image5.jpg", "2024-02-04 09:00"),
        Message("Frank", "https://example.com/image6.jpg", "2024-02-04 09:15"),
        Message("Grace", "https://example.com/image7.jpg", "2024-02-04 09:30"),
        Message("Henry", "https://example.com/image8.jpg", "2024-02-04 09:45"),
        Message("Ivy", "https://example.com/image9.jpg", "2024-02-04 10:00"),
        Message("Jack", "https://example.com/image10.jpg", "2024-02-04 10:15"),
        Message("Karen", "https://example.com/image11.jpg", "2024-02-04 10:30"),
        Message("Leo", "https://example.com/image12.jpg", "2024-02-04 10:45"),
        Message("Mia", "https://example.com/image13.jpg", "2024-02-04 11:00"),
        Message("Nathan", "https://example.com/image14.jpg", "2024-02-04 11:15"),
        Message("Olivia", "https://example.com/image15.jpg", "2024-02-04 11:30"),
        Message("Peter", "https://example.com/image16.jpg", "2024-02-04 11:45"),
        Message("Quincy", "https://example.com/image17.jpg", "2024-02-04 12:00"),
        Message("Rachel", "https://example.com/image18.jpg", "2024-02-04 12:15"),
        Message("Steve", "https://example.com/image19.jpg", "2024-02-04 12:30"),
        Message("Tina", "https://example.com/image20.jpg", "2024-02-04 12:45")
    )
    LazyVerticalGrid(
        modifier = Modifier.background(Theme.thirdColor).fillMaxSize().padding(HomePageConfig.box_ContentPadding),
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding),
        horizontalArrangement = Arrangement.spacedBy(HomePageConfig.box_RLpadding)
    ) {
        items(messages.size) { index ->
            MessageCard(messages[index])
        }
    }
}