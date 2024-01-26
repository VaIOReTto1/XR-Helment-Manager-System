import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
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
import java.util.Comparator

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineChart(payload: List<List<LineData>>, modifier: Modifier) {
    var mSize by remember { mutableStateOf(Size(0f, 0f)) }
    val count = 300
    val paddingCount = 20
    val xUnit = mSize.width / count
    val yUnit = mSize.height / count
    val xList = Array(count) { xUnit * it }
    val yList = Array(count) { yUnit * it }
    val measure = rememberTextMeasurer()
    val xLineUnit = ((count - paddingCount * 2) / payload[0].size) - 5
    val yLineUnit = ((count - paddingCount * 2) / 5) - 5
    val totalList = mutableListOf<LineData>()
    payload.forEach {
        totalList.addAll(it)
    }
    val max = totalList.maxWith(Comparator.comparing { it.amount }).amount
    val subList = Array(100) {
        (it + 1) * 100
    }
    val topNum = subList.filter { it > max }.get(0)
    val plistX = Array(payload.size) {
        Array(payload[it].size) { yy ->
            paddingCount + xLineUnit * (yy + 1)
        }
    }
    val plistY = Array(payload.size) {
        Array(payload[it].size) { yy ->
            count - paddingCount - (5 * yLineUnit * payload[it][yy].amount / topNum).toInt()
        }
    }
    val totalPointList = mutableListOf<MutableList<LineModel>>()
    var loadPos by remember { mutableStateOf(0) }
    LaunchedEffect(payload.size) {
        loadPos = -2
    }

    LaunchedEffect(loadPos) {
        flow {
            if (loadPos < plistX[0].size) {
                delay(200)
                emit(1)
            }
        }.collect {
            loadPos += it
        }
    }
    for (innerIndex in plistX[0].indices) {
        val fragPointList = mutableListOf<LineModel>()
        for (outIndex in plistX.indices) {
            val endXValue by animateFloatAsState(
                if (loadPos < innerIndex) xList[plistX[outIndex][innerIndex]] else
                    if (innerIndex == plistX[0].lastIndex) xList[plistX[outIndex][innerIndex]]
                    else xList[plistX[outIndex][innerIndex + 1]],
                animationSpec = TweenSpec(500)
            )
            val endYValue by animateFloatAsState(
                if (loadPos < innerIndex) yList[plistY[outIndex][innerIndex]] else
                    if (innerIndex == plistX[0].lastIndex) yList[plistY[outIndex][innerIndex]]
                    else yList[plistY[outIndex][innerIndex + 1]],
                animationSpec = TweenSpec(500)
            )
            fragPointList.add(
                LineModel(
                    startX = xList[plistX[outIndex][innerIndex]],
                    startY = yList[plistY[outIndex][innerIndex]],
                    endX = endXValue,
                    endY = endYValue,
                    color = payload[outIndex][innerIndex].lineColor
                )
            )
        }
        totalPointList.add(innerIndex, fragPointList)
    }
    Box(modifier = modifier) {
        LazyRow(
            modifier = Modifier.wrapContentWidth().height(100.dp).align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            payload.forEach { dataList ->
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = dataList[0].groupName, fontSize = 12.sp)
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 8.dp)) {
                            Surface(
                                modifier = Modifier.size(10.dp),
                                shape = CircleShape,
                                color = Color(dataList[0].lineColor.toInt())
                            ) {}
                            Spacer(
                                modifier = Modifier.width(20.dp).height(3.dp)
                                    .background(Color(dataList[0].lineColor.toInt()))
                            )
                        }
                    }
                }
            }
        }

        Canvas(modifier = modifier) {
            mSize = size
            //y轴
            drawLine(
                color = Color(0xff212121),
                start = Offset(xList[paddingCount], yList[paddingCount]),
                end = Offset(xList[paddingCount], yList[count - paddingCount]),
                strokeWidth = 3f
            )
            //x轴
            drawLine(
                color = Color(0xff212121),
                start = Offset(xList[paddingCount], yList[count - paddingCount]),
                end = Offset(xList[count - paddingCount], yList[count - paddingCount]),
                strokeWidth = 3f
            )
            //x轴上绘制年份
            for (index in payload[0].indices) {
                drawText(
                    measure, text = payload[0][index].name,
                    topLeft = Offset(xList[paddingCount + xLineUnit * (index + 1)], yList[count - paddingCount + 2]),
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight(500),
                        fontSize = 10.sp,
                        color = Color.Black,
                        drawStyle = Stroke(
                            width = 5f,
                            cap = StrokeCap.Round,
                        ),
                    ),
                )
            }
            //x轴上绘制圆点
            for (index in payload[0].indices) {
                drawCircle(
                    color = Color.Black,
                    radius = 5f,
                    center = Offset(xList[paddingCount + xLineUnit * (index + 1)], yList[count - paddingCount])
                )
            }

            //绘制y轴上的圆点刻度和平行于x轴的直线
            repeat(payload[0].size) {
                drawCircle(
                    color = Color.Black,
                    radius = 5f,
                    center = Offset(xList[paddingCount], yList[count - paddingCount - yLineUnit * (it + 1)])
                )
                drawLine(
                    color = Color(0xff212121),
                    strokeWidth = 1f,
                    start = Offset(xList[paddingCount], yList[count - paddingCount - yLineUnit * (it + 1)]),
                    end = Offset(xList[count - paddingCount], yList[count - paddingCount - yLineUnit * (it + 1)])
                )
            }
            //绘制y轴上的刻度值
            repeat(payload[0].size) {
                drawText(
                    measure, text = ((topNum / 5) * (it + 1)).toString(),
                    topLeft = Offset(xList[3], yList[count - paddingCount - yLineUnit * (it + 1)]),
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight(500),
                        fontSize = 12.sp,
                        color = Color.Black,
                        drawStyle = Stroke(
                            width = 5f,
                            cap = StrokeCap.Round,
                        ),
                    ),
                )
            }
            //x,y轴上的描述
            drawText(
                textMeasurer = measure, text = "矿物数量（吨）",
                topLeft = Offset(xList[paddingCount - 7], yList[paddingCount - 12]),
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp,
                    color = Color.Black,
                    drawStyle = Stroke(
                        width = 5f,
                        cap = StrokeCap.Round,
                    ),
                ),
            )
            drawText(
                textMeasurer = measure, text = "年份",
                topLeft = Offset(xList[count - paddingCount + 3], yList[count - paddingCount - 3]),
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp,
                    color = Color.Black,
                    drawStyle = Stroke(
                        width = 5f,
                        cap = StrokeCap.Round,
                    ),
                ),
            )

            for (a in totalPointList.indices) {
                if (a < loadPos) {
                    for (b in totalPointList[a].indices) {
                        drawCircle(
                            color = Color(totalPointList[a][b].color.toInt()), radius = 10f,
                            center = Offset(totalPointList[a][b].startX, totalPointList[a][b].startY),
                        )
                        drawLine(
                            color = Color(totalPointList[a][b].color.toInt()),
                            start = Offset(totalPointList[a][b].startX, totalPointList[a][b].startY),
                            end = Offset(totalPointList[a][b].endX, totalPointList[a][b].endY),
                            strokeWidth = 5f
                        )
                    }
                }
            }
        }
    }
}