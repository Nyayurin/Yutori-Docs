package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    ender: Dp,
    modifier: Modifier = Modifier
) {
    SelectionContainer(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (destination) {
                DocumentDestination.Introduction -> Introduction(ender = ender)
                is DocumentDestination.Resource -> Resource(destination.destination)
                is DocumentDestination.Advanced -> Advanced(destination.destination)
            }
        }
    }
}

@Composable
private fun Introduction(ender: Dp) {
    Text(
        text = "介绍",
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = buildAnnotatedString {
            append("Yutori 是一个支持多聊天平台的 ")
            appendUrl(
                text = "Kotlin Multiplatform",
                url = "https://www.jetbrains.com/zh-cn/kotlin-multiplatform"
            )
            append(" 通讯软件开发框架")
        },
        style = MaterialTheme.typography.bodyLarge
    )
    HorizontalDivider()
    Text(
        text = "快速开始",
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = "添加仓库",
        style = MaterialTheme.typography.bodyLarge
    )
    Text(
        text = buildAnnotatedString {
            append("通过 ")
            appendUrl(
                text = "点击这里",
                url = "https://github.com/settings/tokens/new"
            )
            appendLine(" 创建一个属于你的 Github 个人访问 token")
            appendLine("根据需求选择适合自己的生效期(Expiration)")
            appendLine("请确保至少包含一个 read:packages 权限")
            appendLine("请勿将此 token 公开给其他人")
            appendLine("如果你已经有一个了, 可以跳过该步骤")
        },
        style = MaterialTheme.typography.bodyLarge
    )
    // Package Manager
    var pmSelected by remember { mutableIntStateOf(0) }
    TabRow(pmSelected) {
        for ((index, selection) in Selection.entries.withIndex()) {
            Tab(
                selected = pmSelected == index,
                onClick = { pmSelected = index },
            ) {
                Text(
                    text = selection.text,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
    when (pmSelected) {
        Selection.GradleKotlinDSL.ordinal, Selection.GradleGroovyDSL.ordinal -> {
            var fileSelected by remember { mutableIntStateOf(0) }
            TabRow(fileSelected) {
                for ((index, selection) in GradleFile.entries.withIndex()) {
                    Tab(
                        selected = fileSelected == index,
                        onClick = { fileSelected = index },
                    ) {
                        Text(
                            text = when (pmSelected) {
                                Selection.GradleKotlinDSL.ordinal -> selection.kotlinName
                                Selection.GradleGroovyDSL.ordinal -> selection.groovyName
                                else -> throw RuntimeException()
                            },
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            when (pmSelected) {
                Selection.GradleKotlinDSL.ordinal -> {
                    when (fileSelected) {
                        GradleFile.Build.ordinal -> Code {
                            """
                                maven {
                                    url = uri("https://maven.pkg.github.com/Nyayurin/yutori")
                                    credentials { 
                                        username = project.findProperty("gpr.actor") as String? ?: System.getenv("GITHUB_ACTOR")
                                        password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
                                    }
                                }
                            """.trimIndent()
                        }

                        GradleFile.Settings.ordinal -> Code {
                            """
                                maven {
                                    url = uri("https://maven.pkg.github.com/Nyayurin/yutori")
                                    credentials {
                                        username = providers.gradleProperty("gpr.actor").orNull ?: System.getenv("GITHUB_ACTOR")
                                        password = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
                                    }
                                }
                            """.trimIndent()
                        }
                    }
                }

                Selection.GradleGroovyDSL.ordinal -> {
                    when (fileSelected) {
                        GradleFile.Build.ordinal -> {

                        }

                        GradleFile.Settings.ordinal -> {
                        }
                    }
                }
            }
            Text(
                text = "修改 gradle.properties, 将你 Github 账号的 username 及刚刚创建的 token 填进去",
                style = MaterialTheme.typography.bodyLarge
            )
            Code {
                """
                    gpr.actor = actor
                    gpr.token = token
                """.trimIndent()
            }
            Text(
                text = "或是通过环境变量提供",
                style = MaterialTheme.typography.bodyLarge
            )
            Code {
                """
                    GITHUB_ACTOR = actor
                    GITHUB_TOKEN = token
                """.trimIndent()
            }
        }

        Selection.Maven.ordinal -> {

        }

        Selection.Amper.ordinal -> {

        }
    }
    Text(
        text = "引入依赖",
        style = MaterialTheme.typography.bodyLarge
    )
    when (pmSelected) {
        Selection.GradleKotlinDSL.ordinal, Selection.GradleGroovyDSL.ordinal -> {
            var implementationSelected by remember { mutableIntStateOf(0) }
            TabRow(implementationSelected) {
                for ((index, selection) in GradleImplementation.entries.withIndex()) {
                    Tab(
                        selected = implementationSelected == index,
                        onClick = { implementationSelected = index },
                    ) {
                        Text(
                            text = selection.text,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            var multiplatformSelected by remember { mutableIntStateOf(0) }
            TabRow(multiplatformSelected) {
                for ((index, selection) in Multiplatform.entries.withIndex()) {
                    Tab(
                        selected = multiplatformSelected == index,
                        onClick = { multiplatformSelected = index },
                    ) {
                        Text(
                            text = selection.text,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            when (pmSelected) {
                Selection.GradleKotlinDSL.ordinal -> {
                    val artifact = when (multiplatformSelected) {
                        Multiplatform.KotlinMultiplatform.ordinal -> "yutori"
                        Multiplatform.JVM.ordinal -> "yutori-jvm"
                        Multiplatform.Android.ordinal -> "yutori-android"
                        else -> throw RuntimeException()
                    }
                    when (implementationSelected) {
                        GradleImplementation.VersionCatalog.ordinal -> {
                            Code { "implementation(libs.yutori)" }
                            Code {
                                """
                                    [versions]
                                    yutori = "version"
                                    
                                    [libraries]
                                    yutori = { module = "cn.yurin.yutori:$artifact", version.ref = "yutori" }
                                """.trimIndent()
                            }
                        }

                        GradleImplementation.Inline.ordinal -> Code {
                            "implementation(\"cn.yurin.yutori:$artifact:\$version\")"
                        }
                    }
                }

                Selection.GradleGroovyDSL.ordinal -> {
                    when (implementationSelected) {
                        GradleImplementation.VersionCatalog.ordinal -> {

                        }

                        GradleImplementation.Inline.ordinal -> {

                        }
                    }
                }
            }
        }

        Selection.Maven.ordinal -> {

        }

        Selection.Amper.ordinal -> {

        }
    }
    Text(
        text = buildAnnotatedString {
            append("请从 ")
            appendUrl(
                text = "Github Packages",
                url = "https://github.com/Nyayurin?tab=packages&repo_name=yutori"
            )
            appendLine(" 获取版本")
            appendLine("对于稳定版, 它的版本号应该和 Release 中的 tag 一致")
            appendLine("对于开发板, 它的版本号应该和 Commit 的完整 SHA 值一致")
            appendLine("要获取一个 Commit 的完整 SHA 值, 请在 Commits 页面对应 Commit 处点击 Commit ID 右侧的复制按钮(Copy full SHA for *******)")
        },
        style = MaterialTheme.typography.bodyLarge
    )
    Text(
        text = buildAnnotatedString {
            append("引入扩展模块, 如 ")
            appendUrl(
                text = "Yutorix-Satori",
                url = "https://github.com/Nyayurin/yutorix-satori"
            )
        },
        style = MaterialTheme.typography.bodyLarge
    )
    Text(
        text = "编写代码",
        style = MaterialTheme.typography.bodyLarge
    )
    Code {
        """
            suspend fun app() = coroutineScope {
                // 通过 builder 使用 DSL 构造一个 Yutori 对象
                val yutori = yutori {
                    // 安装你需要的适配器
                    install(Adapter.Xxx) {
                        // 在代码块内配置适配器
                        key = value
                    }
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
                }
                // 启动 Yutori
                yutori.start()
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
        modifier = Modifier.padding(bottom = ender),
        style = MaterialTheme.typography.bodyLarge
    )
}

private enum class Selection(val text: String) {
    GradleKotlinDSL("Gradle Kotlin DSL"),
    GradleGroovyDSL("Gradle Groovy DSL"),
    Maven("Maven"),
    Amper("Amper")
}

private enum class GradleFile(val kotlinName: String, val groovyName: String) {
    Build("build.gradle.kts", "build.gradle"),
    Settings("settings.gradle.kts", "settings.gradle")
}

private enum class GradleImplementation(val text: String) {
    VersionCatalog("Version Catalog"),
    Inline("内嵌")
}

private enum class Multiplatform(val text: String) {
    KotlinMultiplatform("Kotlin Multiplatform"),
    JVM("JVM"),
    Android("Android")
}