package hansurset.slitherlink.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hansurset.slitherlink.ui.model.EdgeAxis


@Composable
fun SlitherLinkEdge(
    axis: EdgeAxis = EdgeAxis.Vertical,
    backColor: Color = MaterialTheme.colorScheme.primaryContainer
) {
    val color = remember { mutableStateOf(Color.LightGray) }

    Box(
        modifier = Modifier
            .requiredSize(axis.x, axis.y)
            .clickable {
                color.value = when (color.value) {
                    Color.LightGray -> Color.Black
                    Color.Black -> backColor
                    else -> Color.LightGray
                }
            }
            .background(color.value)
    )
}