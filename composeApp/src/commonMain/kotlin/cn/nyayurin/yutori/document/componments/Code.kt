package cn.nyayurin.yutori.document.componments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.SyntaxLanguage
import dev.snipme.highlights.model.SyntaxThemes
import dev.snipme.kodeview.view.CodeTextView

@Composable
fun Code(language: SyntaxLanguage = SyntaxLanguage.KOTLIN, code: () -> String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLowest
    ) {
        Text(
            text = code(),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
    // Waiting for kodeview 0.9.0
    /*CodeTextView(
        highlights = remember {
            Highlights.Builder(
                code = code(),
                language = language,
                theme = SyntaxThemes.monokai(true)
            ).build()
        }
    )*/
}