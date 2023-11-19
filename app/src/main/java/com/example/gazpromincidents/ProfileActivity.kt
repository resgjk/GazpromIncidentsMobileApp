package com.example.gazpromincidents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    data class eventListModel(
        val name: String,
        val place: String,
        val time: String,
        val owner: String,
        val knowWorkers: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var firstBtnColor = remember {
                mutableStateOf(Color(0xFF252F52))
            }
            var secondBtnColor = remember {
                mutableStateOf(Color.LightGray)
            }
            var various = remember {
                mutableStateOf(2)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        contentColor = Color(0xFF252F52),
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Box {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.avatar),
                                contentDescription = "avatar",
                                modifier = Modifier
                                    .padding(7.dp)
                                    .height(70.dp)
                                    .width(70.dp)
                            )
                            Column {
                                Text(
                                    text = "Иванов Иван Иванович",
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular))
                                )
                                Text(
                                    text = "Сварщик",
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular))
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(
                        onClick = {
                            secondBtnColor.value = Color(0xFF252F52)
                            firstBtnColor.value = Color.LightGray
                            various.value = 1
                        },
                        shape = RoundedCornerShape(0.dp),
                        content = {
                            Text(
                                text = "Отправленные",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = firstBtnColor.value,
                            contentColor = Color.White
                        ),
                    )
                    Button(
                        onClick = {
                            firstBtnColor.value = Color(0xFF252F52)
                            secondBtnColor.value = Color.LightGray
                            various.value = 2
                        },
                        shape = RoundedCornerShape(0.dp),
                        content = {
                            Text(
                                text = "Полученные",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondBtnColor.value,
                            contentColor = Color.White
                        )
                    )
                }
                if (various.value == 2) {
                    returnGetEvents()
                } else {
                    returnPostEvents()
                }
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
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


@Composable
private fun eventListItem(item: ProfileActivity.eventListModel) {
    Surface(
        color = Color.Transparent,
        tonalElevation = 5.dp
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, Color(0xFF252F52)),
        ) {
            Box() {
                Column() {
                    Text(
                        modifier = Modifier.padding(start = 7.dp, top = 2.dp),
                        text = item.name,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                        color = Color(0xFF252F52)
                    )
                    Text(
                        modifier = Modifier.padding(start = 7.dp),
                        text = "Место: ${item.place}",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                        color = Color(0xFF252F52)
                    )
                    Text(
                        modifier = Modifier.padding(start = 7.dp),
                        text = "Время: ${item.time}",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                        color = Color(0xFF252F52)
                    )
                    Text(
                        modifier = Modifier.padding(start = 7.dp),
                        text = "Сообщил: ${item.owner}",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                        color = Color(0xFF252F52)
                    )
                    Text(
                        modifier = Modifier.padding(start = 7.dp, bottom = 2.dp),
                        text = "Осведомлены: ${item.knowWorkers}",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                        color = Color(0xFF252F52)
                    )
                }
            }
        }
    }
}

@Composable
private fun returnGetEvents() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(
            listOf(
                ProfileActivity.eventListModel(
                    name = "Прорыв трубы",
                    place = "Сектор А1",
                    time = "18.11.2023, 13.25",
                    owner = "Ульянов Андрей Александрович",
                    knowWorkers = "Сварщики, Сантехники"
                ),
                ProfileActivity.eventListModel(
                    name = "Утечка газа",
                    place = "Сектор B3",
                    time = "19.11.2023, 23.17",
                    owner = "Александров Аркадий Сергеевич",
                    knowWorkers = "Инженеры, Сварщики"
                )
            )
        ) { index, item ->
            eventListItem(item = item)
        }
    }
}

@Composable
private fun returnPostEvents() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(
            listOf(
                ProfileActivity.eventListModel(
                    name = "Поломка станка",
                    place = "Сектор E1",
                    time = "16.11.2023, 11.49",
                    owner = "Иванов Иван Иванович",
                    knowWorkers = "Механики"
                ),
                ProfileActivity.eventListModel(
                    name = "Утечка топлива",
                    place = "Сектор A3",
                    time = "18.11.2023, 21.59",
                    owner = "Иванов Иван Иванович",
                    knowWorkers = "Инженеры, Механики"
                )
            )
        ) { index, item ->
            eventListItem(item = item)
        }
    }
}