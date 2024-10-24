package cn.nyayurin.yutori.document

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import cn.nyayurin.yutori.document.componments.Description
import cn.nyayurin.yutori.document.componments.Navigation
import cn.nyayurin.yutori.document.componments.Start
import cn.nyayurin.yutori.document.componments.Title
import cn.nyayurin.yutori.document.componments.document.Body
import kotlinx.coroutines.launch

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
fun HomeScreen(onStart: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectionContainer {
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Title()
                    Description()
                }
            }
            Start(onClick = onStart)
        }
    }
}

@Composable
fun DocumentScreen(
    onBack: () -> Unit,
    windowWidth: WindowWidthSizeClass = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
) {
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    var currentDestination: DocumentDestination by remember { mutableStateOf(DocumentDestination.Introduction) }
    when (windowWidth) {
        WindowWidthSizeClass.COMPACT -> {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet(drawerContainerColor = Color.Transparent) {
                        Surface(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(300.dp),
                            shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Navigation(
                                onBack = onBack,
                                destination = currentDestination,
                                onNavigation = { destination ->
                                    currentDestination = destination
                                },
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            ) {
                Box {
                    Column(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        )
                        Body(
                            state = scrollState,
                            destination = currentDestination,
                            ender = 16.dp,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    VerticalScrollbar(
                        adapter = rememberScrollbarAdapter(scrollState),
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
        }

        WindowWidthSizeClass.MEDIUM -> {
            Box {
                Row(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(300.dp),
                        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Navigation(
                            onBack = onBack,
                            destination = currentDestination,
                            onNavigation = { destination ->
                                currentDestination = destination
                            },
                            modifier = Modifier.padding(32.dp)
                        )
                    }
                    Body(
                        state = scrollState,
                        destination = currentDestination,
                        ender = 32.dp,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 32.dp, top = 32.dp, end = 32.dp)
                    )
                }
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }

        WindowWidthSizeClass.EXPANDED -> {
            Box {
                Row(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(300.dp),
                        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Navigation(
                            onBack = onBack,
                            destination = currentDestination,
                            onNavigation = { destination ->
                                currentDestination = destination
                            },
                            modifier = Modifier.padding(32.dp)
                        )
                    }
                    Body(
                        state = scrollState,
                        destination = currentDestination,
                        ender = 64.dp,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 64.dp, top = 64.dp, end = 64.dp)
                    )
                }
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}