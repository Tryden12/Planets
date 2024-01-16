package com.tryden.planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.compose.PlanetsTheme
import com.tryden.planets.ui.PlanetsApp
import com.tryden.planets.ui.screens.list.PlanetsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Create ViewModel instance to run init block during splash screen
        val viewModel: PlanetsListViewModel by viewModels()

        // Handle the splash screen transition
        // Only load the app once planets list is not empty
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.uiState.value.planets.isEmpty()
            }
        }

        // Create the app
        super.onCreate(savedInstanceState)
        setContent {
            PlanetsTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    PlanetsApp(
                        viewModel = viewModel,
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = { finish() }
                    )
                }
            }
        }
    }
}
