package com.app.mytaskcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.app.mytaskcompose.R
import com.app.mytaskcompose.navigation.Screens

@Composable
fun LoginScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

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
            val (logo, txtTitle, txtEmail, edtEmail, txtPassword, edtPassword, txtForgot, btnLogin) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .constrainAs(logo) {
                        top.linkTo(parent.top, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = stringResource(id = R.string.welcome_back),
                color = colorResource(id = R.color.white),
                fontSize = 26.sp, modifier = Modifier.constrainAs(txtTitle) {
                    top.linkTo(logo.bottom, margin = 25.dp)
                })

            Text(
                text = stringResource(id = R.string.email_address),
                color = colorResource(id = R.color.textPrimary),
                fontSize = 18.sp, modifier = Modifier.constrainAs(txtEmail) {
                    top.linkTo(txtTitle.bottom, margin = 25.dp)
                })

            Column(
                modifier = Modifier
                    .constrainAs(edtEmail) {
                        top.linkTo(txtEmail.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .background(colorResource(id = R.color.editTxtBg))
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Enter Email",
                            color = colorResource(id = R.color.white)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    textStyle = TextStyle(color = colorResource(id = R.color.white)),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user_edt),
                            "",
                            tint = Color.White
                        )
                    }, colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = colorResource(id = R.color.editTxtBg),
                        disabledIndicatorColor = Color.Transparent, cursorColor = Color.White
                    )
                )

            }

            Text(
                text = stringResource(id = R.string.password),
                color = colorResource(id = R.color.textPrimary),
                fontSize = 18.sp, modifier = Modifier.constrainAs(txtPassword) {
                    top.linkTo(edtEmail.bottom, margin = 25.dp)

                })

            Column(
                modifier = Modifier
                    .constrainAs(edtPassword) {
                        top.linkTo(txtPassword.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = {
                        Text(
                            "Enter Password",
                            color = colorResource(id = R.color.white)
                        )
                    },
                    modifier = Modifier
                        .background(colorResource(id = R.color.editTxtBg))
                        .fillMaxWidth(),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = TextStyle(color = colorResource(id = R.color.white)),

                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock),
                            "",
                            tint = Color.White
                        )
                    },
                    trailingIcon = {
                        // Toggle button to hide or display password
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            if (passwordVisibility) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_hide),
                                    "",
                                    tint = Color.White
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_show),
                                    "",
                                    tint = Color.White
                                )
                            }
                        }
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = colorResource(id = R.color.editTxtBg),
                        disabledIndicatorColor = Color.Transparent, cursorColor = Color.White
                    )
                )
            }

            Text(
                text = stringResource(id = R.string.forgot_password),
                color = colorResource(id = R.color.textPrimary),
                fontSize = 16.sp, modifier = Modifier.constrainAs(txtForgot) {
                    top.linkTo(edtPassword.bottom, margin = 15.dp)
                    end.linkTo(parent.end)

                })

            Button(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .constrainAs(btnLogin) {
                        top.linkTo(txtForgot.bottom, margin = 30.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                    }
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = { navController.navigate(Screens.HomeScreen.name) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow))
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = colorResource(id = R.color.black), fontSize = 18.sp
                )
            }
        }
    }
}