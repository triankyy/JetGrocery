package com.triankyy.jetgrocery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
                    painter = painterResource(R.drawable.rocket),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color(0xFF6976DF)
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
            val jetNavItem = listOf(
                JetNavItem.Home,
                JetNavItem.Recipe,
                JetNavItem.Cart,
                JetNavItem.Wishlist,
                JetNavItem.Account
            )
            val active by remember { mutableStateOf(JetNavItem.Home) }
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 0.dp,
                contentColor = Color.Black,
                modifier = Modifier.height(80.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    jetNavItem.forEach { navItem ->
                        JetBottomNav(
                            icon = navItem.icons,
                            active = active == navItem,
                            centerItem = (jetNavItem.size - 1) / 2 == jetNavItem.indexOf(navItem),
                            onClick = {  }
                        )
                    }
                }
            }
        }
    ) { scaffoldPadding ->
        LazyColumn(
            modifier = Modifier.padding(scaffoldPadding)
        ) {
            item {
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
                    CategoryItem("Vegetable", R.drawable.vegetables, Color(0xFFE0F8D5)),
                    CategoryItem("Fish", R.drawable.seafoods, Color(0xFFE1F1FF)),
                    CategoryItem("Meat", R.drawable.meat, Color(0xFFFFE4E2)),
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(top = 15.dp)
                ) {
                    item { Spacer(modifier = Modifier) }
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


                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = "Usually buy",
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
            }

            gridItems(
                data = (1..10).toList(),
                columnCount = 2,
//                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(1.dp, AppBorderGray, RoundedCornerShape(20.dp))
                        .padding(20.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.vegetables),
                            contentDescription = "product $it",
                            modifier = Modifier
                                .fillMaxWidth()
//                                .padding(20.dp)
                                .size(100.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Test Product",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "1kg/$it\$",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = AppGray
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "0,$it",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "/${it}00g",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AppGray
                                )
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "+")
                            }
                        }
                    }
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

sealed class JetNavItem(var title: String, @DrawableRes var icons: Int, var route: String) {
    object Home: JetNavItem(title = "Home", R.drawable.home, route = "home")
    object Recipe: JetNavItem(title = "Receipt", R.drawable.receipt, route = "receipt")
    object Cart: JetNavItem(title = "Cart", R.drawable.rocket, route = "cart")
    object Wishlist: JetNavItem(title = "Wishlist", R.drawable.love, route = "wishlist")
    object Account: JetNavItem(title = "Account", R.drawable.person, route = "account")
}
@Composable
fun RowScope.JetBottomNav(
    @DrawableRes icon: Int,
    active: Boolean,
    onClick: () -> Unit,
    centerItem: Boolean
) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(25.dp))
            .background(if (centerItem) AppPrimary else Color.Transparent)
            .clickable { onClick() }
            .padding(17.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = if (centerItem) Color.White
            else if (active) Color.Black
            else AppGray,
            modifier = Modifier
                .align(Alignment.Center)
                .size(22.dp)
        )
    }
}

fun <T> LazyListScope.gridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val size = data.count()
    val rows = if (size == 0) 0 else 1 + (size - 1) / columnCount
    items(rows) { rowIndex ->
        Row(
            horizontalArrangement = horizontalArrangement,
            modifier = modifier
        ) {
            for (columnIndex in 0 until columnCount) {
                val itemIndex = rowIndex * columnCount + columnIndex
                if (itemIndex < size) {
                    Box(
                        modifier = Modifier.weight(1F, fill = true),
                        propagateMinConstraints = true
                    ) {
                        itemContent(data[itemIndex])
                    }
                } else {
                    Spacer(Modifier.weight(1F, fill = true))
                }
            }
        }
    }
}
