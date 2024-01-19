package UI.config

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.res.loadImageBitmap
import java.io.InputStream

// 定义一个包含所有图标引用的对象
object Icons {
    val system_tool = "icon/a-10-xitonggongju.png"
    val help = "icon/bangzhu.png"
    val notes = "icon/biji_notes.png"
    val department = "icon/bumenguanli.png"
    val open_menu = "icon/caidandakai.png"
    val menu_settings = "icon/caidanlanshezhi.png"
    val menu_close = "icon/cebianlanguanbi.png"
    val cpu = "icon/cpu.png"
    val computer = "icon/diannao_o.png"
    val on_time_work = "icon/dingshirenwu.png"
    val service_control = "icon/fuwujiankong.png"
    val job = "icon/gangwei.png"
    val cache_list = "icon/huancunliebiao.png"
    val enlargement = "icon/kuoda.png"
    val mul_people = "icon/ren-duoren.png"
    val calendar = "icon/rili.png"
    val log = "icon/rizhiguanli.png"
    val phone = "icon/shouji.png"
    val home = "icon/shouye.png"
    val news = "icon/xiaoxi.png"
    val system_monitor = "icon/xitongjiankong.png"
    val cache_monitor = "icon/xitongjiankong-huancunjiankong.png"
    val edit = "icon/xiugai.png"
    val user = "icon/yonghu-yuan.png"
    val mul_user = "icon/zaixianyonghu.png"
}

@Composable
fun AppIcon(iconPath: String, contentDescription: String? = null) {
    val image: ImageBitmap
    val inputStream: InputStream? = Thread.currentThread().contextClassLoader.getResourceAsStream(iconPath)
    if (inputStream != null) {
        image = loadImageBitmap(inputStream)
        inputStream.close()
    } else {
        throw IllegalStateException("Could not load image from path: $iconPath")
    }

    Image(bitmap = image, contentDescription = contentDescription)
}

class MyIcon {
    val system_tool=AppIcon(Icons.system_tool, "系统工具")
    val help=AppIcon(Icons.help, "帮助")
    val notes=AppIcon(Icons.notes, "笔记")
    val department=AppIcon(Icons.department, "部门")
    val open_menu=AppIcon(Icons.open_menu, "打开菜单")
    val menu_settings=AppIcon(Icons.menu_settings, "菜单设置")
    val menu_close=AppIcon(Icons.menu_close, "关闭菜单")
    val cpu=AppIcon(Icons.cpu, "CPU")
    val computer=AppIcon(Icons.computer, "电脑")
    val on_time_work=AppIcon(Icons.on_time_work, "定时任务")
    val service_control=AppIcon(Icons.service_control, "服务控制")
    val job=AppIcon(Icons.job, "岗位")
    val cache_list=AppIcon(Icons.cache_list, "缓存列表")
    val enlargement=AppIcon(Icons.enlargement, "放大")
    val mul_people=AppIcon(Icons.mul_people, "多人")
    val calendar=AppIcon(Icons.calendar, "日历")
    val log=AppIcon(Icons.log, "日志")
    val phone=AppIcon(Icons.phone, "手机")
    val home=AppIcon(Icons.home, "首页")
    val news=AppIcon(Icons.news, "消息")
    val system_monitor=AppIcon(Icons.system_monitor, "系统监控")
    val cache_monitor=AppIcon(Icons.cache_monitor, "缓存监控")
    val edit=AppIcon(Icons.edit, "编辑")
    val user=AppIcon(Icons.user, "用户")
    val mul_user=AppIcon(Icons.mul_user, "多用户")
}