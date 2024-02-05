package UI.page.LogManage.DeviceSecurity

data class Device(
    val id: String, //设备id
    val last_uesd_time: String, //设备最近使用时间
    val integrity: String, //设备完整性
    val image: String, //设备图片
    val status: DeviceStatus //设备状态
)

enum class DeviceStatus {
    Normal, //正常
    Damaged, //损坏
    Lost, //丢失
    Repair //维修
}