package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cn.nyayurin.yutori.document.DocumentDestination

@Composable
fun Advanced(destination: DocumentDestination.AdvancedDestination) {
    when (destination) {
        DocumentDestination.AdvancedDestination.Multiplatform -> Multiplatform()
        DocumentDestination.AdvancedDestination.Resource -> Resource()
        DocumentDestination.AdvancedDestination.Admin -> Admin()
    }
}

@Composable
private fun Multiplatform() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

    }
}

@Composable
private fun Resource() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

    }
}

@Composable
private fun Admin() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

    }
}