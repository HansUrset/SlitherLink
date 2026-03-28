package hansurset.slitherlink.ui.model

import androidx.annotation.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class EdgeAxis(val x: Dp, val y: Dp) {
    Horizontal(x = 40.dp, y = 10.dp),
    Vertical(x = 10.dp, y = 40.dp)
}
