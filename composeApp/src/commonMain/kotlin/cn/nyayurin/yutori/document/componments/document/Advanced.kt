package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import cn.nyayurin.yutori.document.DocumentDestination

@Composable
fun Advanced(
    destination: DocumentDestination.AdvancedDestination,
    padding: Dp,
) {
    when (destination) {
        DocumentDestination.AdvancedDestination.Multiplatform -> Multiplatform(padding)
        DocumentDestination.AdvancedDestination.Resource -> Resource(padding)
        DocumentDestination.AdvancedDestination.Admin -> Admin(padding)
    }
}

@Composable
private fun Multiplatform(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Resource(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Admin(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}