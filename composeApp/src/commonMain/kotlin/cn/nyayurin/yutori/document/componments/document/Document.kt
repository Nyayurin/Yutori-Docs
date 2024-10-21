package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import cn.nyayurin.yutori.document.DocumentDestination

@Composable
fun Body(
    destination: DocumentDestination,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        when (destination) {
            DocumentDestination.Introduction -> Introduction()
            is DocumentDestination.Resource -> Resource(destination.destination)
            is DocumentDestination.Advanced -> Advanced(destination.destination)
        }
    }
}

@Composable
private fun Introduction() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "介绍", style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = buildAnnotatedString {
                append("Yutori 是一个支持多聊天平台的 ")
                withLink(
                    LinkAnnotation.Url(
                        url = "https://www.jetbrains.com/zh-cn/kotlin-multiplatform/",
                        styles = TextLinkStyles(
                            SpanStyle(
                                color = Color(51, 102, 204),
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    )
                ) {
                    append("Kotlin Multiplatform")
                }
                append(" 通讯软件开发框架")
            }, style = MaterialTheme.typography.bodyLarge
        )
        HorizontalDivider()
        Text(
            text = "快速开始", style = MaterialTheme.typography.headlineLarge
        )
    }
}