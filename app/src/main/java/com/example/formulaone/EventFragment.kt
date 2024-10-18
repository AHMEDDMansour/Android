package com.example.formulaone


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class ListItem(val imageResId: Int)

@Composable
fun ImageList(navController: NavHostController) {
    val items = listOf(
        ListItem( R.drawable.formula),
        ListItem( R.drawable.motogp),
        ListItem( R.drawable.nascar),
        ListItem( R.drawable.ic_event1),
        ListItem(R.drawable.ic_event2),
        ListItem(R.drawable.ic_event3),
        ListItem(R.drawable.ic_event4)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
           // .background(Color.Gray) // Set the background color to grey
    ) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)) { // Use fillMaxSize to occupy the full screen
        items(items) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Make each item fill the width
                    .padding(16.dp) // Padding around each item
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth() // Image fills the width of the box
                        .height(210.dp)
                        // Set a fixed height for the image
                        .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)), // Optional: rounded corners
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
    }
}