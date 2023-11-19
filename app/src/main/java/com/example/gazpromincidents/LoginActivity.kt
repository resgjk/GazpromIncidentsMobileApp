package com.example.gazpromincidents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LoginActivity : ComponentActivity() {
    private var login = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val (login, setLogin) = remember { mutableStateOf("") }
            val (password, setPassword) = remember { mutableStateOf("") }
            val isLoading = remember { mutableStateOf(false) }
            if (isLoading.value) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        color = Color.LightGray
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.padding(top = 35.dp)
                )
                Text(
                    text = "Авторизируйтесь",
                    modifier = Modifier.padding(top = 30.dp),
                    fontSize = 35.sp,
                    fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                    color = Color(0xFF252F52)
                )
                Column(
                    modifier = Modifier.padding(top = 45.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    loginField(login, setLogin)
                    passwordField(password, setPassword)
                    Button(
                        onClick = {
                            isLoading.value = true
                            val intent = Intent(context, NewIncidentsActivity::class.java)
                            context.startActivity(intent)
                            finish()
                        },
                        modifier = Modifier
                            .padding(45.dp)
                            .width(180.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(20.dp),
                        content = {
                            Text(
                                text = "Войти",
                                fontSize = 25.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF252F52),
                            contentColor = Color.White
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun loginField(text: String, onTextChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(
                text = "Введите логин",
                fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .height(65.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFF252F52),
            textColor = Color.White,
            cursorColor = Color.White,
            placeholderColor = Color.LightGray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        ),
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold))
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun passwordField(text: String, onTextChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(
                text = "Введите пароль",
                fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .height(65.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFF252F52),
            textColor = Color.White,
            cursorColor = Color.White,
            placeholderColor = Color.LightGray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        ),
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold))
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}
