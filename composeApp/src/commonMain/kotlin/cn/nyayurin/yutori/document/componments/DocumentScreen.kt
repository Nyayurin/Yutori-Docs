package cn.nyayurin.yutori.document.componments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
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
fun Navigation(
    onBack: () -> Unit,
    destination: DocumentDestination,
    onNavigation: (DocumentDestination) -> Unit,
    modifier: Modifier = Modifier.width(300.dp)
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        ClickableText(
            text = "Yutori",
            isFocused = false,
            onClick = onBack,
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalDivider(color = LocalContentColor.current)
        ClickableText(
            text = "介绍",
            isFocused = destination == DocumentDestination.Introduction,
            onClick = { onNavigation(DocumentDestination.Introduction) },
            style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(color = LocalContentColor.current)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "资源",
                style = MaterialTheme.typography.titleLarge
            )
            ClickableText(
                text = "频道 (Channel)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Channel),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Channel))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "群组 (Guild)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Guild),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Guild))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "群组成员 (GuildMember)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildMember),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildMember))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "群组角色 (GuildRole)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildRole),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildRole))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "交互 (Interaction)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Interaction),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Interaction))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "登录信息 (Login)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Login),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Login))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "消息 (Message)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Message),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Message))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "表态 (Reaction)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Reaction),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Reaction))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "用户 (User)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.User),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.User))
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
        HorizontalDivider(color = LocalContentColor.current)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "进阶",
                style = MaterialTheme.typography.titleLarge
            )
            ClickableText(
                text = "多平台",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Multiplatform),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Multiplatform))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "资源链接",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Resource),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Resource))
                },
                style = MaterialTheme.typography.titleMedium
            )
            ClickableText(
                text = "管理接口",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Admin),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Admin))
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}