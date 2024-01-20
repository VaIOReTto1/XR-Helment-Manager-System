package UI.config

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import java.io.InputStream

// 定义一个包含所有图标引用的对象
data class IconInfo(val iconPath: String, val contentDescription: String)

object MyIcons {
    val systemTool = IconInfo("icon/a-10-xitonggongju.png", "系统工具")
    val help = IconInfo("icon/bangzhu.png", "帮助")
    val notes = IconInfo("icon/biji_notes.png", "笔记")
    val department = IconInfo("icon/bumenguanli.png", "部门")
    val openMenu = IconInfo("icon/caidandakai.png", "打开菜单")
    val menuSettings = IconInfo("icon/caidanlanshezhi.png", "菜单设置")
    val menuClose = IconInfo("icon/cebianlanguanbi.png", "关闭菜单")
    val cpu = IconInfo("icon/cpu.png", "CPU")
    val computer = IconInfo("icon/diannao_o.png", "电脑")
    val onTimeWork = IconInfo("icon/dingshirenwu.png", "定时任务")
    val serviceControl = IconInfo("icon/fuwujiankong.png", "服务控制")
    val job = IconInfo("icon/gangwei.png", "岗位")
    val cacheList = IconInfo("icon/huancunliebiao.png", "缓存列表")
    val enlargement = IconInfo("icon/kuoda.png", "放大")
    val mulPeople = IconInfo("icon/ren-duoren.png", "多人")
    val calendar = IconInfo("icon/rili.png", "日历")
    val log = IconInfo("icon/rizhiguanli.png", "日志")
    val phone = IconInfo("icon/shouji.png", "手机")
    val home = IconInfo("icon/shouye.png", "首页")
    val news = IconInfo("icon/xiaoxi.png", "消息")
    val systemMonitor = IconInfo("icon/xitongjiankong.png", "系统监控")
    val cacheMonitor = IconInfo("icon/xitongjiankong-huancunjiankong.png", "缓存监控")
    val edit = IconInfo("icon/xiugai.png", "编辑")
    val user = IconInfo("icon/yonghu-yuan.png", "用户")
    val mulUser = IconInfo("icon/zaixianyonghu.png", "多用户")
    val setting = IconInfo("icon/shezhi.png", "设置")
    val notification = IconInfo("icon/tongzhi.png", "设置")
}

@Composable
fun AppIcon(iconInfo: IconInfo, modifier: Modifier, color: Long) {
    val image: ImageBitmap
    val inputStream: InputStream? = Thread.currentThread().contextClassLoader.getResourceAsStream(iconInfo.iconPath)
    if (inputStream != null) {
        image = loadImageBitmap(inputStream)
        inputStream.close()
    } else {
        throw IllegalStateException("Could not load image from path: ${iconInfo.iconPath}")
    }

    Image(
        bitmap = image,
        contentDescription = iconInfo.contentDescription,
        modifier = modifier,
        colorFilter = ColorFilter.tint(
            Color(color)
        )
    )
}

