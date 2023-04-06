package com.triankyy.jetgrocery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.airbnb.lottie.compose.*
import com.triankyy.jetgrocery.ui.theme.Green
import com.triankyy.jetgrocery.ui.theme.GreenAccent
import com.triankyy.jetgrocery.ui.theme.JetGroceryTheme
import com.triankyy.jetgrocery.ui.theme.lighten

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetGroceryTheme {
                HomePage()
            }
        }
    }
}

@Composable
fun HomePage() {
    val paperBag by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.paperbag))

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(25.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.rocket_outline),
                    contentDescription = null
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "Jet",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Grocery",
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.search_outline),
                    contentDescription = null
                )
            }
        }
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier.padding(scaffoldPadding)
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(GreenAccent)
                    .height(100.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Shopping list",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Row {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Green)
                                    .width(35.dp)
                                    .height(35.dp)
                            ) {
                                Text(
                                    text = "4",
                                    color =  Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.height(35.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = MaterialTheme.colors.onBackground,
                                    contentColor = MaterialTheme.colors.background
                                )
                            ) {
                                Text(text = "+")
                            }
                        }
                    }
                    LottieAnimation(
                        composition = paperBag,
                        iterations = LottieConstants.IterateForever,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "Categories",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = ">",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row {
                Box(modifier = Modifier.background(Green.lighten(1f)))
            }
        }
    }
}