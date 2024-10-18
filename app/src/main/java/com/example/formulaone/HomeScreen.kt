package com.example.formulaone

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column {
                    Text("Menu", modifier = Modifier.padding(8.dp), )
                  Row {
                      IconButton(onClick = { navController.navigate(BottomNavItem.Profile.route) }) {
                          Icon(imageVector = Icons.Default.Person , contentDescription = "profile")
                      }
                      Text("Profile", modifier = Modifier.padding(8.dp), )
                  }
                    Row {
                        IconButton(onClick = { navController.navigate(BottomNavItem.About.route) }) {
                            Icon(imageVector = Icons.Default.Info , contentDescription = "About")
                        }
                        Text("About", modifier = Modifier.padding(8.dp), )
                    }
                    Row {
                        IconButton(onClick = { navController.navigate(BottomNavItem.Profile.route) }) {
                            Icon(imageVector = Icons.Default.Settings , contentDescription = "settings")
                        }
                        Text("Settings", modifier = Modifier.padding(8.dp), )
                    }


                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NasCar") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.LightGray
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }

                    },
                    actions = {

                        IconButton(onClick = { navController.navigate(BottomNavItem.News.route) }) {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "News")
                        }




                        ExitAppButton()
                    }
                )
            },
            bottomBar = {
                NavigationBar {

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Star, contentDescription = "Events") },
                        label = { Text("Events") },
                        selected = false,
                        onClick = { navController.navigate("Events") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Standing") },
                        label = { Text("Standing") },
                        selected = false,
                        onClick = { navController.navigate("Standing") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Notifications, contentDescription = "News") },
                        label = { Text("News") },
                        selected = false,
                        onClick = { navController.navigate("News") }
                    )

                }

            },


        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = BottomNavItem.News.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(BottomNavItem.News.route) { NewsScreen(navController) }
                    composable(BottomNavItem.Events.route) { ImageList(navController) }
                    composable(BottomNavItem.Profile.route) { ProfileScreen(navController) }
                   // composable(BottomNavItem.About.route) { StaggeredImageGrid(navController) }
                    composable(BottomNavItem.Standing.route) {  StickyHeaderList(navController) }

                }
            }
        }
    }

}



@Composable
fun ExitAppButton() {
    val activity = (LocalContext.current as? Activity) // Get the current activity
    IconButton(onClick = {
        activity?.finish() // Exit the app
    }) {
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Exit")
    }
}
