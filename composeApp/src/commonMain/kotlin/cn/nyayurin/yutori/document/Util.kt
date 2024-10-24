package cn.nyayurin.yutori.document

import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp

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

fun lightScrollbarStyle() = ScrollbarStyle(
    minimalHeight = 16.dp,
    thickness = 8.dp,
    shape = RoundedCornerShape(4.dp),
    hoverDurationMillis = 300,
    unhoverColor = Color.Black.copy(alpha = 0.125f),
    hoverColor = Color.Black.copy(alpha = 0.50f)
)

fun darkScrollbarStyle() = ScrollbarStyle(
    minimalHeight = 16.dp,
    thickness = 8.dp,
    shape = RoundedCornerShape(4.dp),
    hoverDurationMillis = 300,
    unhoverColor = Color.White.copy(alpha = 0.25f),
    hoverColor = Color.White.copy(alpha = 0.75f)
)