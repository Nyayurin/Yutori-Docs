package cn.nyayurin.yutori.document.componments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cn.nyayurin.yutori.document.DocumentDestination
import org.jetbrains.compose.resources.painterResource
import yutori_docs.composeapp.generated.resources.Res
import yutori_docs.composeapp.generated.resources.dark_mode_24px
import yutori_docs.composeapp.generated.resources.github
import yutori_docs.composeapp.generated.resources.light_mode_24px
import yutori_docs.composeapp.generated.resources.translate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    darkMode: Boolean,
    onChangeDarkMode: (Boolean) -> Unit,
    onBack: () -> Unit,
    destination: DocumentDestination,
    onNavigation: (DocumentDestination) -> Unit,
    modifier: Modifier = Modifier.width(300.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier,
    ) {
        ClickableText(
            text = "Yutori",
            isFocused = false,
            onClick = onBack,
            style = MaterialTheme.typography.headlineSmall,
        )
        HorizontalDivider(color = LocalContentColor.current)
        ClickableText(
            text = "介绍",
            isFocused = destination == DocumentDestination.Introduction,
            onClick = { onNavigation(DocumentDestination.Introduction) },
            style = MaterialTheme.typography.titleLarge,
        )
        HorizontalDivider(color = LocalContentColor.current)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "资源",
                style = MaterialTheme.typography.titleLarge,
            )
            ClickableText(
                text = "频道 (Channel)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Channel),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Channel))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "群组 (Guild)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Guild),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Guild))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "群组成员 (GuildMember)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildMember),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildMember))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "群组角色 (GuildRole)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildRole),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.GuildRole))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "交互 (Interaction)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Interaction),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Interaction))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "登录信息 (Login)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Login),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Login))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "消息 (Message)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Message),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Message))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "表态 (Reaction)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.Reaction),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.Reaction))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "用户 (User)",
                isFocused = destination == DocumentDestination.Resource(DocumentDestination.ResourceDestination.User),
                onClick = {
                    onNavigation(DocumentDestination.Resource(DocumentDestination.ResourceDestination.User))
                },
                style = MaterialTheme.typography.titleMedium,
            )
        }
        HorizontalDivider(color = LocalContentColor.current)
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "进阶",
                style = MaterialTheme.typography.titleLarge,
            )
            ClickableText(
                text = "多平台",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Multiplatform),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Multiplatform))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "资源链接",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Resource),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Resource))
                },
                style = MaterialTheme.typography.titleMedium,
            )
            ClickableText(
                text = "管理接口",
                isFocused = destination == DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Admin),
                onClick = {
                    onNavigation(DocumentDestination.Advanced(DocumentDestination.AdvancedDestination.Admin))
                },
                style = MaterialTheme.typography.titleMedium,
            )
        }
        Spacer(
            modifier = Modifier.weight(1F),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val uriHandler = LocalUriHandler.current
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = "语言")
                    }
                },
                state = rememberTooltipState(),
            ) {
                var expanded by remember { mutableStateOf(false) }
                IconButton(
                    onClick = { expanded = true },
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.translate),
                        contentDescription = null,
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "简体中文")
                        },
                        onClick = {
                            expanded = false
                        },
                    )
                }
            }
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = "深色主题")
                    }
                },
                state = rememberTooltipState(),
            ) {
                Switch(
                    checked = darkMode,
                    onCheckedChange = onChangeDarkMode,
                    thumbContent = {
                        when {
                            darkMode ->
                                Icon(
                                    painter = painterResource(Res.drawable.dark_mode_24px),
                                    contentDescription = null,
                                )

                            else ->
                                Icon(
                                    painter = painterResource(Res.drawable.light_mode_24px),
                                    contentDescription = null,
                                )
                        }
                    },
                )
            }
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = "Github")
                    }
                },
                state = rememberTooltipState(),
            ) {
                IconButton(
                    onClick = {
                        uriHandler.openUri("https://github.com/Nyayurin/Yutori-Docs")
                    },
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.github),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}
