package cn.nyayurin.yutori.document.componments

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        text = "Yutori",
        style = MaterialTheme.typography.displayLarge,
        modifier = modifier
    )
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    Text(
        text = "一个支持多聊天平台的 Kotlin Multiplatform 通讯软件开发框架",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}


@Composable
fun Start(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 48.dp, vertical = 12.dp)
    ) {
        Text(
            text = "即刻起步",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}