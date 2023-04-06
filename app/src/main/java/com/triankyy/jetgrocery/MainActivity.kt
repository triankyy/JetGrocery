package com.triankyy.jetgrocery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.airbnb.lottie.compose.*
import com.triankyy.jetgrocery.ui.theme.*

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
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.search_outline),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.search_outline),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.search_outline),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.search_outline),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.search_outline),
                            contentDescription = null
                        )
                    }
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
                    .background(AppGreenAccent)
                    .height(100.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(2f)
                            .padding(10.dp)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Shopping list",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy((-5).dp)
                        ) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(AppGreen)
                                        .width(36.dp)
                                        .height(36.dp)
                                ) {
                                    Text(
                                        text = "4",
                                        color =  Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }
                            val listProduct = intArrayOf(
                                R.drawable.egg,
                                R.drawable.milk,
                                R.drawable.cheese
                            )
                            items(listProduct.size) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(14.dp))
                                        .border(
                                            width = 1.dp,
                                            color = AppGreenAccent,
                                            shape = RoundedCornerShape(14.dp)
                                        )
                                        .width(36.dp)
                                        .height(36.dp)
                                ) {
                                    Image(
                                        painter = painterResource(listProduct[it]),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                                Button(
                                    onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier.height(36.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = AppBlueDark,
                                        contentColor = MaterialTheme.colors.background
                                    )
                                ) {
                                    Text(text = "+")
                                }
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

            val listCategory = listOf<CategoryItem>(
                CategoryItem("Vegetables", R.drawable.vegetable_icon, AppGreenAccent),
                CategoryItem("Seafoods", R.drawable.crab_icon, AppRedAccent),
                CategoryItem("Ingredients", R.drawable.ingredient_icon, AppBlueAccent),
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 15.dp)
            ) {
                item {
                    Spacer(modifier = Modifier)
                }
                items(items = listCategory) { category ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .height(140.dp)
                            .width(165.dp)
                            .background(category.color)
                            .clickable { }
                    ) {
                        Image(
                            painter = painterResource(category.icons),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(90.dp)
                                .padding(top = 10.dp)
                        )
                        Text(
                            text = category.title,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 20.dp, bottom = 20.dp)
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier)
                }
            }
        }
    }
}

data class CategoryItem(
    val title: String,
    @DrawableRes val icons: Int,
    val color: Color
)