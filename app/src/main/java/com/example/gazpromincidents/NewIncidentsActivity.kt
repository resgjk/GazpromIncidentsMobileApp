package com.example.gazpromincidents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class NewIncidentsActivity : ComponentActivity() {

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
            Column {
                Text(
                    text = "Недавние происшествия", modifier = Modifier.padding(10.dp),
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.jetbrainsmono_extrabold)),
                    color = Color(0xFF252F52)
                )
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    itemsIndexed(
                        listOf(
                            eventListModel(
                                name = "Прорыв трубы",
                                place = "Сектор А1",
                                time = "18.11.2023, 13.25",
                                owner = "Иванов Иван Иванович",
                                knowWorkers = "Сварщики, Сантехники"
                            ),
                            eventListModel(
                                name = "Утечка газа",
                                place = "Сектор B3",
                                time = "19.11.2023, 23.17",
                                owner = "Александров Аркадий Сергеевич",
                                knowWorkers = "Инженеры, Сварщики"
                            ),
                            eventListModel(
                                name = "Поломка станка",
                                place = "Сектор С2",
                                time = "17.11.2023, 21.36",
                                owner = "Романов Виктор Владимирович",
                                knowWorkers = "Механики"
                            ),
                            eventListModel(
                                name = "Поломка станка",
                                place = "Сектор С2",
                                time = "17.11.2023, 21.36",
                                owner = "Романов Виктор Владимирович",
                                knowWorkers = "Механики"
                            )
                        )
                    ) { index, item ->
                        eventListItem(item = item)
                    }
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
                            IconButton(onClick = { /*TODO*/ }) {
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
private fun eventListItem(item: NewIncidentsActivity.eventListModel) {
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