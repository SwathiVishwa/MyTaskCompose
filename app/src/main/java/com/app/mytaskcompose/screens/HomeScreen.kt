package com.app.mytaskcompose.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.app.mytaskcompose.LoadLocalData
import com.app.mytaskcompose.R
import com.app.mytaskcompose.model.ProjectList
import com.app.mytaskcompose.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var search by rememberSaveable { mutableStateOf("") }

            Column(
                modifier = Modifier
//            .verticalScroll(state = scrollState)
                    .background(color = colorResource(id = R.color.darkBlue))
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .padding(all = 25.dp)
                        .fillMaxWidth()
                ) {
                    val (image, txtTitle, userName, edtSearch, btnSetting, completedList, txtCompleted, txtSee, txtOngoing, ongoingSee, ongoingList) = createRefs()
                    Text(
                        text = stringResource(id = R.string.welcome_back),
                        color = colorResource(id = R.color.yellow),
                        fontSize = 12.sp, modifier = Modifier.constrainAs(txtTitle) {
                            top.linkTo(parent.top, margin = 20.dp)
                            start.linkTo(parent.start)
                        })
                    Image(
                        painter = painterResource(R.drawable.ic_girl_user),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, Color.Gray, CircleShape)
                            .constrainAs(image) {
                                top.linkTo(parent.top, margin = 20.dp)
                                end.linkTo(parent.end, margin = 10.dp)
                            }  // add a border (optional)
                    )
                    Text(
                        text = stringResource(id = R.string.userName),
                        color = colorResource(id = R.color.white),
                        fontSize = 22.sp, modifier = Modifier.constrainAs(userName) {
                            top.linkTo(txtTitle.bottom, margin = 10.dp)
                            start.linkTo(parent.start)
                        })
                    Column(
                        modifier = Modifier
                            .constrainAs(edtSearch) {
                                top.linkTo(userName.bottom, margin = 50.dp)
                                start.linkTo(parent.start)
                                end.linkTo(edtSearch.start, margin = 10.dp)
                            }) {

                        TextField(
                            value = search,
                            onValueChange = { search = it },
                            modifier = Modifier
                                .background(colorResource(id = R.color.editTxtBg))
                                .wrapContentWidth(align = Alignment.Start),
                            placeholder = {
                                Text(
                                    "Search",
                                    color = colorResource(id = R.color.white)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            textStyle = TextStyle(color = colorResource(id = R.color.white)),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_search),
                                    "",
                                    tint = Color.White
                                )
                            }, colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = colorResource(id = R.color.editTxtBg),
                                disabledIndicatorColor = Color.Transparent,
                                cursorColor = Color.White
                            )
                        )

                    }

                    Button(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .constrainAs(btnSetting) {
                                top.linkTo(userName.bottom, margin = 40.dp)
                                end.linkTo(parent.end)
                            }
                            .width(60.dp)
                            .height(60.dp),
                        onClick = { navController.navigate(Screens.HomeScreen.name) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow)),
                        border = BorderStroke(2.dp, color = colorResource(id = R.color.yellow))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_setting),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = stringResource(id = R.string.completed_task),
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp, modifier = Modifier.constrainAs(txtCompleted) {
                            top.linkTo(edtSearch.bottom, margin = 20.dp)
                            start.linkTo(parent.start)
                        })
                    Text(
                        text = stringResource(id = R.string.see_all),
                        color = colorResource(id = R.color.yellow),
                        fontSize = 16.sp, modifier = Modifier.constrainAs(txtSee) {
                            top.linkTo(edtSearch.bottom, margin = 20.dp)
                            end.linkTo(parent.end)
                        })
                    LazyRow(modifier = Modifier.constrainAs(completedList) {
                        top.linkTo(txtCompleted.bottom, margin = 10.dp)
                    }) {
                        items(LoadLocalData.projectList()) { item ->
                            ProjectCard(item)
                        }
                    }
                    Text(
                        text = stringResource(id = R.string.ongoing_project),
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp, modifier = Modifier.constrainAs(txtOngoing) {
                            top.linkTo(completedList.bottom, margin = 25.dp)
                            start.linkTo(parent.start)
                        })
                    Text(
                        text = stringResource(id = R.string.see_all),
                        color = colorResource(id = R.color.yellow),
                        fontSize = 16.sp, modifier = Modifier.constrainAs(ongoingSee) {
                            top.linkTo(completedList.bottom, margin = 25.dp)
                            end.linkTo(parent.end)
                        })
                    LazyColumn(modifier = Modifier.constrainAs(ongoingList) {
                        top.linkTo(txtOngoing.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                        items(LoadLocalData.ongoingProjects()) { item ->
                            OnGoingProject(item)
                        }
                    }
                }
            }
        }

@Composable
fun ProjectCard(item: ProjectList) {
    Row {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.yellow))
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(15.dp)
                .width(200.dp)
                .height(180.dp)


        ) {
            ConstraintLayout(modifier = Modifier.wrapContentWidth(align = Alignment.CenterHorizontally)) {

                val (txtTitle, txtTeam, rvImage, txtStatus, txtPercentage, progress) = createRefs()
                Text(
                    text = item.projectTitle,
                    fontSize = 21.sp,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.constrainAs(txtTitle) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                )
                Text(
                    text = stringResource(id = R.string.teamMembers),
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.textsecondary),
                    modifier = Modifier.constrainAs(txtTeam) {
                        top.linkTo(txtTitle.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                    }
                )
                LazyRow(modifier = Modifier.constrainAs(rvImage) {
                    top.linkTo(txtTitle.bottom, margin = 20.dp)
                    start.linkTo(txtTeam.end, margin = 10.dp)
                    end.linkTo(parent.end)
                }, horizontalArrangement = Arrangement.spacedBy((-10).dp)) {
                    items(item.members) {
                        Image(
                            painter = painterResource(it),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,           // crop the image if it's not a square
                            modifier = Modifier
                                .size(25.dp)
                                .clip(CircleShape)                       // clip to the circle shape
                                .border(1.dp, Color.Gray, CircleShape)
                            // add a border (optional)
                        )
                    }

                }
                Text(
                    text = item.status,
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.textsecondary),
                    modifier = Modifier.constrainAs(txtStatus) {
                        top.linkTo(txtTeam.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                    }
                )
                Text(
                    text = "100 %",
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.constrainAs(txtPercentage) {
                        top.linkTo(txtTeam.bottom, margin = 20.dp)
                        end.linkTo(parent.end)
                    }
                )
                LinearProgressIndicator(
                    progress = 1.0f,
                    modifier = Modifier
                        .height(2.dp)
                        .constrainAs(progress) {
                            top.linkTo(txtStatus.bottom, margin = 10.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        },
                    backgroundColor = Color.White,
                    color = colorResource(id = R.color.textsecondary)
                )
            }
        }
        Spacer(modifier = Modifier.width(30.dp))
    }
}

@Composable
fun OnGoingProject(item: ProjectList) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.editTxtBg))
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(15.dp)
                .fillMaxWidth()


        ) {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()){

                val (txtTitle, txtTeam, rvImage, txtStatus, txtPercentage, progress) = createRefs()
                Text(
                    text = item.projectTitle,
                    fontSize = 21.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.constrainAs(txtTitle) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                )
                Text(
                    text = stringResource(id = R.string.teamMembers),
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.constrainAs(txtTeam) {
                        top.linkTo(txtTitle.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                    }
                )
               LazyRow(modifier = Modifier.
                constrainAs(rvImage) {
                    top.linkTo(txtTeam.bottom, margin = 15.dp)
                    start.linkTo(parent.start)
                }, horizontalArrangement = Arrangement.spacedBy((-10).dp)) {
                    items(item.members) {
                        Image(
                            painter = painterResource(it),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,           // crop the image if it's not a square
                            modifier = Modifier
                                .size(25.dp)
                                .clip(CircleShape)                       // clip to the circle shape
                                .border(1.dp, Color.Gray, CircleShape)
                            // add a border (optional)
                        )
                    }

                }
                Text(
                    text = "Due on: 12 June",
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.constrainAs(txtStatus) {
                        top.linkTo(rvImage.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                    }
                )
                Text(
                    text = "100 %",
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.constrainAs(txtPercentage) {
                        top.linkTo(txtTeam.bottom, margin = 23.dp)
                        end.linkTo(parent.end, margin = 20.dp)
                    }
                )
                CircularProgressIndicator(
                    progress = 0.8f,
                    modifier = Modifier
                        .size(80.dp)
                        .height(1.dp)
                        .constrainAs(progress) {
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        },
                    color= colorResource(id = R.color.yellow), strokeWidth = 4.dp
                )
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

}