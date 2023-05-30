package com.app.mytaskcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.app.mytaskcompose.R

@Composable
fun ScheduleScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.darkBlue))
            .fillMaxSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .padding(all = 25.dp)
        ) {
            val (logo, image, txtTitle, button) = createRefs()
        }
    }
}