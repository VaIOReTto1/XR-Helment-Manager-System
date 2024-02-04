package UI.page.LogManage.DeviceSecurity

data class Device(
    val id:String,
    val last_uesd_time:String,
    val Integrity:String,
    val image:String,
    val status: DeviceStatus
)

enum class DeviceStatus {
    Normal,
    Damaged,
    lost,
    repair
}