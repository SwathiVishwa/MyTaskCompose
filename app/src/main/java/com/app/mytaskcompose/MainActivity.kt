package com.app.mytaskcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.mytaskcompose.navigation.BottomNavigationBar
import com.app.mytaskcompose.navigation.ScreenNavigation
import com.app.mytaskcompose.navigation.Screens
import com.app.mytaskcompose.ui.theme.MyTaskComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTaskComposeTheme {
                val navController = rememberNavController()
                val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, bottomBarState)
                    }, content = { padding ->
                        Box(modifier = Modifier.padding(padding)) {
                            // Navhost: where screens are placed
                            ScreenNavigation(navController = navController, bottomBarState)
                        }
                    })
            }
        }
    }
}

/*@Preview
@Composable
fun SplashScreens() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.darkBlue))
            .fillMaxSize()
            .padding(all = 15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Row(
            Modifier
                .background(color = colorResource(id = R.color.white))
                .padding(all = 10.dp)
                .fillMaxWidth()
                .height(350.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(
                    text = "Manage \n your \nTask with ",
                    color = colorResource(id = R.color.white),
                    fontSize = 60.sp,
                    fontStyle = FontStyle(600)
                )
                Text(
                    text = " DayTask", color = colorResource(id = R.color.yellow), fontSize = 60.sp,
                    fontStyle = FontStyle(600)
                )
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { *//*TODO*//* },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow))
        ) {
            Text(
                text = stringResource(id = R.string.letsStart),
                color = colorResource(id = R.color.black)
            )
        }
    }
}*/
@Composable
fun SplashScreens(navController: NavController) {
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

            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .constrainAs(logo) {
                        top.linkTo(parent.top, margin = 10.dp)
                    }
            )
            Row(
                Modifier
                    .background(color = colorResource(id = R.color.white))
                    .padding(all = 10.dp)
                    .fillMaxWidth()
                    .height(320.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .constrainAs(image) {
                        top.linkTo(logo.bottom, margin = 20.dp)
                    }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_splash),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(txtTitle) {
                    top.linkTo(image.bottom)
                }) {
                Column {
                    Text(
                        text = "Manage \n your \nTask with ",
                        color = colorResource(id = R.color.white),
                        fontSize = 60.sp,
                        fontStyle = FontStyle(600)
                    )
                    Text(
                        text = " DayTask",
                        color = colorResource(id = R.color.yellow),
                        fontSize = 60.sp,
                        fontStyle = FontStyle(600)
                    )
                }
            }
            Button(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .constrainAs(button) {
                        top.linkTo(txtTitle.bottom, margin = 30.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                    }
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = { navController.navigate(Screens.LoginScreen.name) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow))
            ) {
                Text(
                    text = stringResource(id = R.string.letsStart),
                    color = colorResource(id = R.color.black), fontSize = 18.sp
                )
            }
        }
    }
}

