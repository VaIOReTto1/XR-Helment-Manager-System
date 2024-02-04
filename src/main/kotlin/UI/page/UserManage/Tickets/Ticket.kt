data class Ticket(
    val title: String,
    val name: String,
    val id: String,
    val status: TicketStatus,
    val date: String,
)

enum class TicketStatus {
    Completed, Completing, UnComplete
}