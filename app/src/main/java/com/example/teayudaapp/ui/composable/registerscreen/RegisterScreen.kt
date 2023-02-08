package com.example.teayudaapp.ui.composable.registerscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
){
    var emailText = remember { mutableStateOf("") }
    var passwordText = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            TittleView()
        }
        item {
            RegisterLoginButtons()
            Spacer(modifier = Modifier.height(11.dp))
        }

        item {
            EmailField(emailText)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            PasswordField(passwordText)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            AgreeRadioButton()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ContinueButton()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            Divider(Modifier.height(2.dp))
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            LoginGoogle()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            LoginFacebook()
            Spacer(modifier = Modifier.height(21.67.dp))
        }
    }
}

@Composable
private fun LoginFacebook() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
    ) {

        Text(
            text = "Iniciar sesion con ",
            style = MaterialTheme.typography.body1
        )
        Icon(imageVector = Icons.Default.Facebook, contentDescription = "Facebook login")
    }
}

@Composable
private fun LoginGoogle() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
    ) {
        Text(
            text = "Iniciar sesion con ",
            style = MaterialTheme.typography.body1
        )
        Icon(painterResource(id = R.drawable.google_icon), contentDescription = "Google login")
    }
}

@Composable
private fun ContinueButton() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFE5E0FF)
        )
    ) {
        Text(
            text = "Continuar",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
private fun AgreeRadioButton() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        RadioButton(
            selected = false,
            onClick = { },
            modifier = Modifier
                .size(24.dp)
        )

        Text(
            text = "Aceptar los terminos y condiciones",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun PasswordField(
    passwordText: MutableState<String>
) {
    var visibility = remember { mutableStateOf(true) }
    var visibilityIcon = if (visibility.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
    var transformation = if (visibility.value) PasswordVisualTransformation() else VisualTransformation.None
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Contraseña",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordText.value,
                onValueChange = { passwordText.value = it },
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = transformation,
                maxLines = 1,
                singleLine = true,
                keyboardActions = KeyboardActions( onDone = {keyboardController?.hide()}),
                placeholder = { Text(text = "contraseña", style = MaterialTheme.typography.body1)},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Lock icon"
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { visibility.value = !visibility.value }) {
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = "Password visibility"
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun EmailField(
    emailText: MutableState<String>,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Email",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailText.value,
                onValueChange = { emailText.value = it },
                shape = MaterialTheme.shapes.large,
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                keyboardActions = KeyboardActions( onDone = { keyboardController?.hide() }),
                placeholder = { Text(text = "email@example.com", style = MaterialTheme.typography.body1) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email entry"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
private fun RegisterLoginButtons() {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Registrar")
            }
            Divider(
                modifier = Modifier
                    .height(30.dp)
                    .width(1.dp)
                    .background(Color.White)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
private fun TittleView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(174.dp)
            .background(MaterialTheme.colors.primary),
        Alignment.CenterStart,
    ) {
        Text(
            text = stringResource(id = R.string.app_tittle),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    RegisterScreen()
}