package com.example.formulaone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class Item(val name: String, val header: String, val imageResId: Int)

@Composable
fun StickyHeaderList(navController: NavHostController) {

    val items = listOf(
        Item("Lewis Hamilton", "Petronas AMG", R.drawable.hamilton),
        Item("George Russel", "Petronas AMG", R.drawable.russel),
        Item("Charles Leclerc", "Scuderia Ferrari", R.drawable.leclerc),
        Item("Carlos Sainz", "Scuderia Ferrari", R.drawable.sainz),
        Item("Lando Norris", "Mc Laren", R.drawable.norris),
        Item("Oscar Piastri", "Mc Laren", R.drawable.piastri),
        Item("Max Verstappen", "Red Bull Racing", R.drawable.max),
        Item("Sergio Pérez", "Red Bull Racing", R.drawable.perez)
    )

    var currentHeader by remember { mutableStateOf(items[0].header) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(items) { index, item ->
            if (index == 0 || items[index - 1].header != item.header) {
                currentHeader = item.header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    Text(text = currentHeader, fontSize = 18.sp, color = Color.Black)
                }
            }

            // List item with circular photo and name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Circular Image
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(50.dp) // Image size
                        .clip(CircleShape) // Circular shape
                        .background(Color.Gray), // Optional background
                    contentScale = ContentScale.Crop
                )

                // Text next to the image
                Text(
                    text = item.name,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .background(Color.White)
                )
            }
        }
    }
}