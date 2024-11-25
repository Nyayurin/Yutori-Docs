package cn.nyayurin.yutori.document.componments.document

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cn.nyayurin.yutori.document.DocumentDestination
import cn.nyayurin.yutori.document.appendUrl
import cn.nyayurin.yutori.document.componments.Code

@Composable
fun Body(
    state: ScrollState,
    destination: DocumentDestination,
    padding: Dp,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        AnimatedContent(
            targetState = destination,
        ) {
            SelectionContainer {
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(state)
                            .padding(horizontal = padding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    when (it) {
                        DocumentDestination.Introduction -> Introduction(padding)
                        is DocumentDestination.Resource -> Resource(it.destination, padding)
                        is DocumentDestination.Advanced -> Advanced(it.destination, padding)
                    }
                }
            }
        }
        VerticalScrollbar(
            adapter = rememberScrollbarAdapter(state),
            modifier = Modifier.align(Alignment.CenterEnd),
        )
    }
}

@Composable
private fun Introduction(padding: Dp) {
    Text(
        text = "介绍",
        modifier = Modifier.padding(top = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
    Text(
        text =
            buildAnnotatedString {
                append("Yutori 是一个支持多聊天平台的 ")
                appendUrl(
                    text = "Kotlin Multiplatform",
                    url = "https://www.jetbrains.com/zh-cn/kotlin-multiplatform",
                )
                append(" 通讯软件开发框架")
            },
        style = MaterialTheme.typography.bodyLarge,
    )
    HorizontalDivider()
    Text(
        text = "快速开始",
        style = MaterialTheme.typography.headlineLarge,
    )
    Text(
        text = "添加仓库",
        style = MaterialTheme.typography.bodyLarge,
    )
    Text(
        text =
            buildAnnotatedString {
                append("通过 ")
                appendUrl(
                    text = "点击这里",
                    url = "https://github.com/settings/tokens/new",
                )
                appendLine(" 创建一个属于你的 Github 个人访问 token")
                appendLine("根据需求选择适合自己的生效期(Expiration)")
                appendLine("请确保至少包含一个 read:packages 权限")
                appendLine("请勿将此 token 公开给其他人")
                append("如果你已经有一个了, 可以跳过该步骤")
            },
        style = MaterialTheme.typography.bodyLarge,
    )
    Code {
        """
        maven {
            url = uri("https://maven.pkg.github.com/Nyayurin/yutori")
            credentials { 
                // 填入你的 Github 用户名及刚刚申请的 token
                username = "actor"
                password = "token"
            }
        }
        """.trimIndent()
    }
    Text(
        text = "引入依赖",
        style = MaterialTheme.typography.bodyLarge,
    )
    Code {
        "implementation(\"cn.yurin.yutori:yutori:\$version\")"
    }
    Text(
        text =
            buildAnnotatedString {
                append("请从 ")
                appendUrl(
                    text = "Github Packages",
                    url = "https://github.com/Nyayurin?tab=packages&repo_name=yutori",
                )
                appendLine(" 获取版本")
                appendLine("对于稳定版, 它的版本号应该和 Release 中的 tag 一致")
                appendLine("对于开发板, 它的版本号应该和 Commit 的完整 SHA 值一致")
                append("要获取一个 Commit 的完整 SHA 值, 请在 Commits 页面对应 Commit 处点击 Commit ID 右侧的复制按钮(Copy full SHA for *******)")
            },
        style = MaterialTheme.typography.bodyLarge,
    )
    Text(
        text =
            buildAnnotatedString {
                append("引入扩展模块, 如 ")
                appendUrl(
                    text = "Yutorix-Satori",
                    url = "https://github.com/Nyayurin/yutorix-satori",
                )
            },
        style = MaterialTheme.typography.bodyLarge,
    )
    Text(
        text = "编写代码",
        style = MaterialTheme.typography.bodyLarge,
    )
    Code {
        """
        suspend fun app() {
            // 通过 builder 使用 DSL 构造一个 Yutori 对象
            yutori {
                // 安装你需要的模块
                install(Adapter.Xxx(
                    // 配置模块
                    key = value
                ))
                // 通用适配器设置
                adapter {
                    // 设置监听器
                    listening {
                        // 监听消息发送
                        message.created {
                            // event.message.content 是一个 List<MessageElement> 对象, 通过调用 textContent 函数获取所有纯文本拼接成的字符串
                            if (event.message.content.textContent() == "test") {
                                // 调用 actions.message.create 来发送一条消息
                                actions.message.create(
                                    channelId = event.channel.id,
                                    // 通过消息 builder 使用 DSL 构造一条消息
                                    content = {
                                        // 添加一个纯文本
                                        text("test done!")
                                    }
                                )
                            }
                        }
                    }
                }
                // 通用服务器设置
                server {
                    // 设置路由器
                    routing {
                        // 路由消息发送
                        message.create {
                            // 找到对应 actions
                            val forwardActions = yutori.actionsList.first {
                                it.platform == request.properties["platform"] && it.selfId == request.properties["selfId"]
                            }
                            // 转发, 并获取响应
                            val forwardResponse = forwardActions.message.create(
                                channelId = request.channelId,
                                content = request.content
                            )
                            // 响应纯文本
                            // 由于 Server 部分还处于早期, 因此还不具备 Adapter 那样的通用性
                            response.respond(
                                // 序列化响应实体类
                                Json.encodeToString(
                                    forwardResponse.map { SerializableMessage.fromUniverse(it) }
                                )
                            )
                        }
                    }
                }
            }.start()
        }
        """.trimIndent()
    }
    Code {
        """
        fun main() {
            runBlocking {
                val scope = CoroutineScope(Dispatchers.IO)
                scope.launch {
                    bot()
                }.join()
            }
        }
        """.trimIndent()
    }
    Text(
        text = "至此, 你已经学会了 Yutori 的基本使用, 接下来请慢慢探索 Yutori 的无限可能吧!",
        modifier = Modifier.padding(bottom = padding),
        style = MaterialTheme.typography.bodyLarge,
    )
}