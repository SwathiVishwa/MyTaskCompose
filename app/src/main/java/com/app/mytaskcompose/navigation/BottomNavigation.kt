package com.app.mytaskcompose.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.mytaskcompose.R
import com.app.mytaskcompose.navigation.ConstantBottom.BottomNavItems


@Composable
fun BottomNavigationBar(navController: NavHostController, bottomBarState: MutableState<Boolean>) {
    AnimatedVisibility(
        visible = bottomBarState.value,
        content = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.menuBg),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.menuBg),
                        shape = RectangleShape
                    )
//                    .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                BottomNavItems.forEach { navItem ->

                    if(navItem.label != "create") {
                        BottomNavigationItem(
                            selected = currentRoute == navItem.route,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    launchSingleTop = true
                                    popUpTo(navItem.route)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = navItem.icon),
                                    contentDescription = navItem.label,
                                )
                            },
                            label = {
                                Text(
                                    text = navItem.label,
                                    color = colorResource(id = R.color.yellow),
                                    fontSize = 9.sp
                                )
                            },
                            selectedContentColor = colorResource(id = R.color.yellow),
                            unselectedContentColor = colorResource(id = R.color.menuText),

                            alwaysShowLabel = false
                        )
                    }
                    else{
                        BottomNavigationItem(
                            selected = currentRoute == navItem.route,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    launchSingleTop = true
                                    popUpTo(navItem.route)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_box_24),
                                    contentDescription = navItem.label,
                                )
                            }
                        , selectedContentColor = colorResource(id = R.color.yellow),
                            unselectedContentColor = colorResource(id = R.color.yellow),
                        )
                    }
                }
            }
        })
}