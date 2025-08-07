package com.cutech.importantcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cutech.importantcomponents.components.ComponentAppToolBar
import com.cutech.importantcomponents.navigation.NavGraph
import com.cutech.importantcomponents.ui.theme.ImportantComponentsTheme
import com.cutech.importantcomponents.utils.ComponentCustomSnackBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImportantComponentsTheme {
                val navController = rememberNavController()
                val snackBarState = remember { SnackbarHostState() }
                val coroutineScope: CoroutineScope = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        ComponentAppToolBar(
                            title = "ConnectU EducTech",
                            onBackClick = {},
                            isBackButton = true
                        )
                    }) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        NavGraph(
                            navController, innerPadding,
                            showCustomSnackBar = { status, message ->
                                if (status){
                                    coroutineScope.launch {
                                        snackBarState.showSnackbar(message = message)
                                    }
                                }
                            }
                        )

                        SnackbarHost(
                            modifier = Modifier.align(Alignment.BottomStart), hostState = snackBarState
                        ) { data: SnackbarData ->
                            ComponentCustomSnackBar(
                                icon = R.drawable.ic_notification_icon_24,
                                data.visuals.message
                            )
                        }
                    }
                }
            }
        }
    }
}
