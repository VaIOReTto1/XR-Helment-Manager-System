import UI.page.HomePage.ThemeChange.ThemeChangeColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.io.Serializable
import androidx.compose.ui.graphics.Color

object Theme {
    var primaryColor by mutableStateOf(Color(0xFFA25772)) // 主题色
    var secondColor by mutableStateOf(Color(0xFF7C93C3)) //
    var thirdColor by mutableStateOf(Color(0xFF9EB8D9)) // 背景
    var fourthColor by mutableStateOf(Color(0xFFEEF5FF)) // 卡片背景
    var fifthColor by mutableStateOf(Color(0xFFFFFFFB)) // 文字底色

    private var selectedTheme by mutableStateOf(ThemeChangeColor.MistyBlue) // 选中的主题
    var isDefaultThemeActivated by mutableStateOf(false) // 是否激活默认主题

    // 五彩主题
    data class Penta<out A, out B, out C, out D, out E>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E
    ) : Serializable {
        override fun toString(): String = "($first, $second, $third, $fourth, $fifth)"
    }

    // 转换为颜色列表
    fun Penta<Color, Color, Color, Color, Color>.toList(): List<Color> = listOf(first, second, third, fourth, fifth)

    // 激活默认主题
    fun activateDefaultTheme() {
        if (!isDefaultThemeActivated) {
            DefaultTheme() // 只有当已经激活时，才应用默认主题
        } else {
            changeTheme(selectedTheme)
        }
        isDefaultThemeActivated = !isDefaultThemeActivated
    }

    // 改变主题
    fun changeTheme(newTheme: ThemeChangeColor) {
        selectedTheme = newTheme
        when (newTheme) {
            ThemeChangeColor.MistyBlue -> MistyBlueTheme()
            ThemeChangeColor.SkyBlue -> SkyBlueTheme()
            ThemeChangeColor.DeepSapphire -> DeepSapphireTheme()
            ThemeChangeColor.PaleGreen -> PaleGreenTheme()
            ThemeChangeColor.SlateGreen -> SlateGreenTheme()
            ThemeChangeColor.DarkSienna -> DarkSiennaTheme()
            ThemeChangeColor.PaleApricot -> PaleApricotTheme()
            ThemeChangeColor.PaleRose -> PaleRoseTheme()
        }
    }

    // 更新主题
    private fun updateTheme(newColors: Penta<Color, Color, Color, Color, Color>) {
        primaryColor = newColors.first
        secondColor = newColors.second
        thirdColor = newColors.third
        fourthColor = newColors.fourth
        fifthColor = newColors.fifth
    }

    // 默认主题
    fun DefaultTheme() {
        val newColors = Penta(Color(0xff021039), Color(0xff365486), Color.White, Color(0xFFFFFFFB), Color(0xfffAffff))
        updateTheme(newColors)
    }

    // 淡蓝灰主题
    fun MistyBlueTheme() {
        val newColors =
            Penta(Color(0xFFA25772), Color(0xFF7C93C3), Color(0xFF9EB8D9), Color(0xFFEEF5FF), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 天空蓝主题
    fun SkyBlueTheme() {
        val newColors =
            Penta(Color(0xFF0F1035), Color(0xFF365486), Color(0xFF7FC7D9), Color(0xFFDCF2F1), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 深宝蓝主题
    fun DeepSapphireTheme() {
        val newColors =
            Penta(Color(0xFF2D3250), Color(0xFFF6B17A), Color(0xFF424769), Color(0xFFF6B17A), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 苍绿主题
    fun PaleGreenTheme() {
        val newColors =
            Penta(Color(0xFF80BCBD), Color(0xFFD5F0C1), Color(0xFFAAD9BB), Color(0xFFF9F7C9), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 灰绿主题
    fun SlateGreenTheme() {
        val newColors =
            Penta(Color(0xFF76453B), Color(0xFFB19470), Color(0xFF43766C), Color(0xFFF8FAE5), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 暗赭主题
    fun DarkSiennaTheme() {
        val newColors =
            Penta(Color(0xFF3E3232), Color(0xFF7E6363), Color(0xFF503C3C), Color(0xFFA87C7C), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 淡杏主题
    fun PaleApricotTheme() {
        val newColors =
            Penta(Color(0xFFE6A4B4), Color(0xFFF3D7CA), Color(0xFFFFF8E3), Color(0xFFF5EEE6), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }

    // 淡玫瑰主题
    fun PaleRoseTheme() {
        val newColors =
            Penta(Color(0xFF8785A2), Color(0xFFF6F6F6), Color(0xFFFFE2E2), Color(0xFFFFC7C7), Color(0xFFFFFFFB))
        updateTheme(newColors)
    }
}
