package com.example.gazpromincidents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CreateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Оформление происшествия",
                    modifier = Modifier.padding(top = 20.dp, bottom = 15.dp),
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                    color = Color(0xFF252F52)
                )
                txtField(text = "Что произошло")
                txtField(text = "Место происшествия")
                txtField(text = "Время происшествия")
                txtField(text = "Какие должности осведомить")
                txtField(text = "Кого осведомить")
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .padding(top = 45.dp, bottom = 15.dp)
                        .width(270.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                    content = {
                        Text(
                            text = "Отправить",
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF252F52),
                        contentColor = Color.White
                    )
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF252F52),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Box() {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                        ) {
                            IconButton(onClick = {
                                val intent = Intent(context, NewIncidentsActivity::class.java)
                                context.startActivity(intent)
                                finish()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.newinc),
                                    contentDescription = "NewInc"
                                )
                            }
                            IconButton(onClick = {
                                val intent = Intent(context, OnWorkActivity::class.java)
                                context.startActivity(intent)
                                finish()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.check),
                                    contentDescription = "NewInc"
                                )
                            }
                            IconButton(onClick = {
                                val intent = Intent(context, CreateActivity::class.java)
                                context.startActivity(intent)
                                finish()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.create),
                                    contentDescription = "NewInc"
                                )
                            }
                            IconButton(onClick = {
                                val intent = Intent(context, ProfileActivity::class.java)
                                context.startActivity(intent)
                                finish()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = "NewInc"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun txtField(text: String) {
    var value = remember {
        mutableStateOf("")
    }
    TextField(
        value = value.value,
        onValueChange = { value.value = it },
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
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