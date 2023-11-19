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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class OnWorkActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.worker),
                    contentDescription = "worker"
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp, top = 100.dp, bottom = 125.dp),
                    colors = CardDefaults.cardColors(
                        contentColor = Color(0xFF252F52),
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(2.dp, Color(0xFF252F52)),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                        ) {
                            Text(
                                text = "Рабочий день",
                                fontSize = 30.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_bold)),
                                color = Color(0xFF252F52)
                            )
                            Text(
                                text = "8:00 - начало смены", fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                                color = Color(0xFF252F52)
                            )
                            Text(
                                text = "18:00 - конец смены", fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
                                color = Color(0xFF252F52),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                            Button(
                                onClick = { /*TODO*/ }, modifier = Modifier
                                    .padding(top = 7.dp, bottom = 7.dp)
                                    .width(270.dp)
                                    .height(40.dp),
                                shape = RoundedCornerShape(20.dp),
                                content = {
                                    Text(
                                        text = "Поступить на смену",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.jetbrainsmono_regular)),
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