package cn.nyayurin.yutori.document

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink

fun AnnotatedString.Builder.appendUrl(text: String, url: String) {
    withLink(
        LinkAnnotation.Url(
            url = url,
            styles = TextLinkStyles(
                SpanStyle(
                    color = Color(51, 102, 204),
                    textDecoration = TextDecoration.Underline
                )
            )
        )
    ) {
        append(text)
    }
}