package widget

import PieData
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.math.cos
import kotlin.math.sin

enum class ChartType {
    Ring, Full
}

enum class DescriptionDirection {
    LEFT,//左侧
    TOP,//顶部
    RIGHT,//右侧
    BOTTOM,//底部
    CIRCLE,//圆周
}


@Composable
fun PieChart(payload: List<List<PieData>>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 50.dp, vertical = 50.dp), // 添加内容内边距
        horizontalArrangement = Arrangement.spacedBy(50.dp) // 在水平方向上为项目添加间距
    ) {
        items(payload) {
            Pie(
                it,
                modifier = Modifier.size(600.dp / 2),
                chartTye = if (it.size == 6) ChartType.Full else ChartType.Full,
                gap = 60f,
                desDirection = DescriptionDirection.CIRCLE
            )
        }
    }
}

@OptIn(ExperimentalStdlibApi::class, ExperimentalTextApi::class)
@Composable
fun Pie(
    dataList: List<PieData>,
    modifier: Modifier,
    gap: Float = 100f,
    chartTye: ChartType = ChartType.Full,
    desDirection: DescriptionDirection = DescriptionDirection.LEFT
) {
    var mSize by remember { mutableStateOf(Size(0f, 0f)) }
    val centerX = mSize.center.x
    val centerY = mSize.center.y
    val radius = centerX.coerceAtLeast(centerY) / 2//饼图半径
    val total = dataList.map { it.amount }.reduce { t, u -> t + u }
    val rateList = Array(dataList.size) {
        (dataList[it].amount / total) * 360f
    }
    val diffAngleList = Array(dataList.size) { 0f }
    var pieState by remember { mutableStateOf(false) }
    var textstate by remember { mutableStateOf(false) }
    LaunchedEffect(true) {
        flow {
            delay(1000)
            emit(0)
        }.collect {
            pieState = !pieState
        }
    }
    for (index in rateList.indices) {
        val diff by animateFloatAsState(
            if (pieState) rateList[index] else 0f, animationSpec = TweenSpec(
                200, easing = LinearEasing, delay = 200 * index
            )
        ) {
            if (index == dataList.lastIndex) {
                textstate = !textstate
            }
        }
        diffAngleList[index] = diff
    }
    val measure = rememberTextMeasurer()
//    val textSize by animateFloatAsState(
//        if (textstate) 12f else 0f, animationSpec = TweenSpec(500)
//    )
    val textSize = 12f
    var prefixAngle = 0f

    val mGap = if (chartTye == ChartType.Full) {
        0f
    } else {
        gap
    }
    Canvas(modifier = modifier) {
        mSize = size
        rateList.indices.forEach {
            drawArc(
                color = Color(dataList[it].color.toInt()),
                useCenter = chartTye == ChartType.Full,
                startAngle = -90f + prefixAngle,
                sweepAngle = diffAngleList[it],
                topLeft = Offset(centerX - radius, centerY - radius),
                size = Size(radius * 2, radius * 2),
                style = if (chartTye == ChartType.Full) Fill else Stroke(mGap)
            )

            drawRect(
                color = Color(dataList[it].color.toInt()), topLeft =
                when (desDirection) {
                    DescriptionDirection.CIRCLE -> {
                        Offset(
                            pointX(
                                radius + mGap / 2 + radius / 2,
                                centerX,
                                90f + (rateList[it] / 2) + prefixAngle
                            ) - 30f,
                            pointY(
                                radius + mGap / 2 + radius / 2,
                                centerY,
                                90f + (rateList[it] / 2) + prefixAngle
                            ) + 10f
                        )
                    }

                    DescriptionDirection.LEFT -> {
                        Offset(
                            centerX - radius - mGap / 2 - 100f - textSize * 2,
                            centerY - radius + it * (radius * 2) / dataList.size + textSize
                        )
                    }

                    DescriptionDirection.RIGHT -> {
                        Offset(
                            centerX + radius + mGap / 2,
                            centerY - radius + it * (radius * 2) / dataList.size
                        )
                    }

                    DescriptionDirection.TOP -> {
                        Offset(
                            centerX - radius - mGap / 2 + (2 * textSize + 200f) * it,
                            textSize + (centerY - radius - mGap / 2) / 2
                        )
                    }

                    else -> {
                        Offset(
                            centerX - radius - mGap / 2 + (2 * textSize + 200f) * it,
                            textSize + centerY + radius + mGap / 2 + 30f
                        )
                    }
                },
                size = Size(textSize, textSize)
            )


            drawText(
                measure,
                text = dataList[it].name + "\n" + dataList[it].amount,
                topLeft = when (desDirection) {
                    DescriptionDirection.CIRCLE -> {
                        Offset(
                            pointX(radius + mGap / 2 + radius / 2, centerX, 90f + (rateList[it] / 2) + prefixAngle),
                            pointY(radius + mGap / 2 + radius / 2, centerY, 90f + (rateList[it] / 2) + prefixAngle)
                        )
                    }

                    DescriptionDirection.LEFT -> {
                        Offset(
                            centerX - radius - mGap / 2 - 100f,
                            centerY - radius + it * (radius * 2) / dataList.size
                        )
                    }

                    DescriptionDirection.RIGHT -> {
                        Offset(
                            centerX + radius + mGap / 2 + 30f,
                            centerY - radius + it * (radius * 2) / dataList.size
                        )
                    }

                    DescriptionDirection.TOP -> {
                        Offset(
                            centerX - radius - mGap / 2 + (2 * textSize + 200f) * it + 2 * textSize,
                            (centerY - radius - mGap / 2) / 2
                        )
                    }

                    else -> {
                        Offset(
                            centerX - radius - mGap / 2 + (2 * textSize + 200f) * it + 2 * textSize,
                            centerY + radius + mGap / 2 + 30f
                        )
                    }
                },
                size = Size(200f, 200f),
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight(500),
                    fontSize = textSize.sp,
                    color = Color.Black,
                    drawStyle = Stroke(
                        width = 5f,
                        cap = StrokeCap.Round,
                    ),
                ),
            )
            prefixAngle += rateList[it]
        }
    }
}

private fun pointX(width: Float, centerX: Float, fl: Float): Float {
    val angle = Math.toRadians(fl.toDouble())
    return centerX - cos(angle).toFloat() * (width)
}

private fun pointY(width: Float, centerY: Float, fl: Float): Float {
    val angle = Math.toRadians(fl.toDouble())
    return centerY - sin(angle).toFloat() * (width)
}