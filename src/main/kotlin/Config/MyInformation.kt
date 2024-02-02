import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object MyInformation {
    var name by mutableStateOf("xxx")
    var phone by mutableStateOf("12312341234")
    var department by mutableStateOf("xxxx")
    var job by mutableStateOf("管理员")
    var creat_time by mutableStateOf("2024-02-01")
    var gender by mutableStateOf("男")
    var id by mutableStateOf("123456789")
    var photo by mutableStateOf("")
    var password by mutableStateOf("123456")

    fun updateInformation(
        name: String = this.name,
        phone: String = this.phone,
        department: String = this.department,
        job: String = this.job,
        creat_time: String = this.creat_time,
        gender: String = this.gender,
        id: String = this.id,
        photo: String = this.photo,
        password: String = this.password
    ) {
        this.name = name
        this.phone = phone
        this.department = department
        this.job = job
        this.creat_time = creat_time
        this.gender = gender
        this.id = id
        this.photo = photo
        this.password = password
    }
}