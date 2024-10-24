package cn.nyayurin.yutori.document

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cn.nyayurin.yutori.document.theme.LocalDarkMode
import cn.nyayurin.yutori.document.theme.Theme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.getFontResourceBytes
import org.jetbrains.compose.resources.getSystemResourceEnvironment
import yutori_docs.composeapp.generated.resources.MapleMono_NF_CN_Regular
import yutori_docs.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(viewModel: MainViewModel = viewModel { MainViewModel() }) {
    val navController = rememberNavController()
    var typography by remember { mutableStateOf<Typography?>(null) }
    val defaultTypography = MaterialTheme.typography
    val darkMode = viewModel.darkMode ?: isSystemInDarkTheme()
    val scrollbarStyle = if (darkMode) darkScrollbarStyle() else lightScrollbarStyle()
    CompositionLocalProvider(
        LocalDarkMode provides darkMode,
        LocalScrollbarStyle provides scrollbarStyle
    ) {
        Theme(typography = typography ?: defaultTypography) {
            NavHost(
                navController = navController,
                startDestination = ScreenDestination.Loading,
                modifier = Modifier.fillMaxSize()
            ) {
                composable<ScreenDestination.Loading> {
                    LoadingScreen()
                }
                composable<ScreenDestination.Home> {
                    HomeScreen(
                        onStart = {
                            navController.navigate(ScreenDestination.Document)
                        }
                    )
                }
                composable<ScreenDestination.Document> {
                    DocumentScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        val fontFamily = FontFamily(
            Font(
                identity = "MiSans-Regular",
                data = getFontResourceBytes(
                    environment = getSystemResourceEnvironment(),
                    resource = Res.font.MapleMono_NF_CN_Regular
                )
            )
        )
        typography = Typography(
            defaultTypography.displayLarge.copy(fontFamily = fontFamily),
            defaultTypography.displayMedium.copy(fontFamily = fontFamily),
            defaultTypography.displaySmall.copy(fontFamily = fontFamily),
            defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
            defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
            defaultTypography.headlineSmall.copy(fontFamily = fontFamily),
            defaultTypography.titleLarge.copy(fontFamily = fontFamily),
            defaultTypography.titleMedium.copy(fontFamily = fontFamily),
            defaultTypography.titleSmall.copy(fontFamily = fontFamily),
            defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
            defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
            defaultTypography.bodySmall.copy(fontFamily = fontFamily),
            defaultTypography.labelLarge.copy(fontFamily = fontFamily),
            defaultTypography.labelMedium.copy(fontFamily = fontFamily),
            defaultTypography.labelSmall.copy(fontFamily = fontFamily)
        )
        viewModel.fontLoaded = true
        navController.navigate(ScreenDestination.Home)
    }
}

class MainViewModel : ViewModel() {
    var darkMode by mutableStateOf<Boolean?>(null)
    var fontLoaded by mutableStateOf(false)
}