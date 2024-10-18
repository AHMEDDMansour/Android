package com.example.formulaone


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(navController: NavHostController) {

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }

        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ) {

                Box(
                        modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                ) {
                        Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile Image",
                                modifier = Modifier
                                        .fillMaxSize(),
                                tint = Color.Gray // Placeholder icon color
                        )
                }

                Spacer(modifier = Modifier.height(16.dp))


                OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        placeholder = { Text("Enter your username") },
                        leadingIcon = {
                                Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
                        },
                        modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        placeholder = { Text("Enter your password") },
                        leadingIcon = {
                                Icon(imageVector = Icons.Default.Person, contentDescription = "Password")
                        },
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                                val image = if (isPasswordVisible)
                                        Icons.Default.Person // You can replace with an "eye" icon for visibility toggle
                                else Icons.Default.Person

                                IconButton(onClick = {
                                        isPasswordVisible = !isPasswordVisible
                                }) {
                                        Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                                }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = androidx.compose.ui.text.input.KeyboardType.Password)                )
        }

}