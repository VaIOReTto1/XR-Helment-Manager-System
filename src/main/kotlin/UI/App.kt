package UI

import MineralStatistics
import UsersFlow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun App(){
    Row {
        UsersFlow()
        MineralStatistics()
        FunctionArea()
    }
}

@Composable
fun FunctionArea(){

}