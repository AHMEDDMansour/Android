/*package com.example.formulaone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items

data class GridItem(val imageRes: Int)

@Composable
fun StaggeredImageGrid(navController: NavHostController) {
    val itemS = listOf(
        GridItem(R.drawable.ic_event1),
        GridItem(R.drawable.ic_event2),
        GridItem(R.drawable.ic_event3),
        GridItem(R.drawable.ic_event4)
    )

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), // Padding around the grid
        columns = StaggeredGridCells.Fixed(2), // Number of columns
        verticalItemSpacing = 8.dp // Spacing between items vertically
    ) {
        items(itemS) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp) // Padding around each item
            ) {
                Image(
                    painter = painterResource(id = item.imageRes), // Load the image resource
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Fixed height for the images
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)), // Optional: rounded corners
                    contentScale = ContentScale.Crop // Scale the content to fill the image
                )
            }
        }
    }
}

@Composable
fun PreviewStaggeredImageGrid() {
    StaggeredImageGrid(navController = rememberNavController())
}*/