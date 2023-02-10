package com.example.teayudaapp.ui.composable.registerscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R
import com.example.teayudaapp.ui.composable.registerscreen.components.*


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
){
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    val loginScreen = remember { mutableStateOf(true) }
    val colorsBackground = if (loginScreen.value) MaterialTheme.colors.primary else MaterialTheme.colors.background
    val colorsButton = if (loginScreen.value) MaterialTheme.colors.background else MaterialTheme.colors.primary
    val padding = 6.dp
    val dataString = if (loginScreen.value) SharedStringsResources(
        emailId = R.string.login_email,
        passwordId = R.string.login_password,
        termsOrForgottenId = R.string.forgotten_password,
        registerButton = R.string.button_login)
    else SharedStringsResources(
        emailId = R.string.register_email,
        passwordId = R.string.register_password,
        termsOrForgottenId = R.string.app_terms,
        registerButton = R.string.button_register)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorsBackground),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            TittleView(loginScreen.value, colorsBackground)
        }
        item {
            RegisterLoginButtons(padding, loginScreen.value) { buttonClicked ->
                loginScreen.value = buttonClicked
            }
            Spacer(modifier = Modifier.height(11.dp))
        }

        item {
            EmailField(emailText, padding, dataString, colorsButton)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            PasswordField(passwordText, padding, dataString, colorsButton)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            if (!loginScreen.value){
                RadioButtonAgree(padding)
                Spacer(modifier = Modifier.height(21.67.dp))
            }
            else{
                //TODO: Forgotten password
            }
        }

        item {
            ButtonContinue()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            Divider(
                Modifier
                    .height(2.dp)
                    .padding(start = padding, end = padding))
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ButtonLoginGoogle(dataString, colorsButton)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ButtonLoginFacebook(dataString, colorsButton)
            Spacer(modifier = Modifier.height(21.67.dp))
        }
    }
}

















@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    RegisterScreen()
}