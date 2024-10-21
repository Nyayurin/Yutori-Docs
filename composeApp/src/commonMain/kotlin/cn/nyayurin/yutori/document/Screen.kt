package cn.nyayurin.yutori.document

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import cn.nyayurin.yutori.document.componments.Description
import cn.nyayurin.yutori.document.componments.Navigation
import cn.nyayurin.yutori.document.componments.Start
import cn.nyayurin.yutori.document.componments.Title
import cn.nyayurin.yutori.document.componments.document.Body

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
    var currentDestination: DocumentDestination by remember { mutableStateOf(DocumentDestination.Introduction) }
    when (windowWidth) {
        WindowWidthSizeClass.COMPACT -> {
            Navigation(
                onBack = onBack,
                destination = currentDestination,
                onNavigation = { destination ->
                    currentDestination = destination
                }
            )
            Body(
                destination = currentDestination,
                modifier = Modifier.fillMaxSize()
            )
        }

        WindowWidthSizeClass.MEDIUM -> {
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
                    destination = currentDestination,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(64.dp)
                )
            }
        }

        WindowWidthSizeClass.EXPANDED -> {
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
                    destination = currentDestination,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(64.dp)
                )
            }
        }
    }
}