package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordField(
    passwordText: MutableState<String>,
    paddingValues: Dp
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = "Contraseña",
                style = MaterialTheme.typography.h3,
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
                placeholder = { Text(
                    text = "contraseña",
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSecondary) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Lock icon",
                        tint = MaterialTheme.colors.onSecondary
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { visibility.value = !visibility.value }) {
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = "Password visibility",
                            tint = MaterialTheme.colors.onSecondary
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