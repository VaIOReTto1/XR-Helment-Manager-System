import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object MyInformation {
    var name by mutableStateOf("xxx")
    var phone by mutableStateOf("12312341234")
    var department by mutableStateOf("xxxx")
    var job by mutableStateOf("xxxx")
    var creat_time by mutableStateOf("2024-02-01")

    fun updateInformation(name: String=this.name, phone: String=this.phone, department: String=this.department, job: String=this.job, creat_time: String=this.creat_time) {
        this.name = name
        this.phone = phone
        this.department = department
        this.job = job
        this.creat_time = creat_time
    }
}