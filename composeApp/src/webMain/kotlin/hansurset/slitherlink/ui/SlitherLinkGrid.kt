package hansurset.slitherlink.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hansurset.slitherlink.ui.model.EdgeAxis

@Composable
fun SlitherLinkGrid(viewModel: GridViewModel = GridViewModel(), modifier: Modifier = Modifier) {
    val uiState = viewModel.uiState.collectAsState()

    val gridSize: Int = uiState.value.n*2+1
    //val grid: List<List<Int>> = List(uiState.value.n) { List(uiState.value.n) { 0 } }
    val grid: List<List<Int?>> =
        listOf(
            listOf(null, 3, 3, 3, null),
            listOf(1, 2, 0, 2, 1),
            listOf(null, null, 2, null, null),
            listOf(2, null, 2, null, null),
            listOf(null, null, 3, 2, null),
        )


    Box(contentAlignment = Alignment.Center) {
        Column() {
            for (i in 1..gridSize) {
                when (i % 2) {
                    1 -> HorizontalRow(gridSize)
                    0 -> VerticalRow(grid, gridSize, i)
                }
            }
        }
    }
}



@Composable
fun HorizontalRow(gridSize: Int) {
    Row() {
        for (i in 1..gridSize) {
            when (i % 2) {
                1 -> Spacer(modifier = Modifier.size(10.dp))
                0 -> SlitherLinkEdge(EdgeAxis.Horizontal)
            }
        }
    }
}

@Composable
fun VerticalRow(grid: List<List<Int?>>, gridSize: Int, i: Int) {
    Row() {
        for (j in 1..gridSize) {
            when (j % 2) {
                1 -> SlitherLinkEdge(EdgeAxis.Vertical)
                0 -> Numbers(grid[(i/2-1)][(j/2-1)]) // Spacer(modifier = Modifier.size(40.dp))
            }
        }
    }
}



@Composable
fun Numbers(num: Int?) {
    Box(
        modifier = Modifier.size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        when (num) {
            is Int -> Text(text = num.toString())
            null -> Text(text = "")
        }
    }
}

