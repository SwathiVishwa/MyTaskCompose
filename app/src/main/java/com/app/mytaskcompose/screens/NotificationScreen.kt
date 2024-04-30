package com.app.mytaskcompose.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.app.mytaskcompose.LoadLocalData
import com.app.mytaskcompose.R
import com.app.mytaskcompose.model.NotificationList

@Composable
fun NotificationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.darkBlue))
            .fillMaxSize()
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "")
            Text("Notification", color = Color.White)
        }
        Text("New", color = Color.White)
        LazyColumn {
            items(LoadLocalData.notificationList()) { item ->
                ItemNotification(item = item)
            }
        }
        Text("Earlier", color = Color.White)
        LazyColumn {
            items(LoadLocalData.notificationList()) { item ->
                ItemNotification(item = item)
            }
        }
    }
}

@Composable
fun ItemNotification(item: NotificationList) {
    Row(modifier = Modifier.padding(vertical = 20.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_girl_user),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Gray, CircleShape)
        )
        ConstraintLayout {
            val (username, msg, projectName) = createRefs()


            Text(item.user, color = Color.White, modifier = Modifier.constrainAs(username) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }, fontSize = 14.sp)
            Text(
                item.msg,
                color = colorResource(id = R.color.textPrimary),
                modifier = Modifier.constrainAs(msg) {
                    top.linkTo(parent.top)
                    start.linkTo(username.end, margin = 15.dp)
                }, fontSize = 14.sp)
            Text(
                item.projectName,
                color = colorResource(id = R.color.yellow),
                modifier = Modifier.constrainAs(projectName) {
                    top.linkTo(username.bottom)
                    start.linkTo(parent.start)
                }, fontSize = 14.sp)
        }
        Text("31 min", color = Color.White)

    }
}