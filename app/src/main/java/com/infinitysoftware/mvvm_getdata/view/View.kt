package com.infinitysoftware.mvvm_getdata.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.livedata.observeAsState
import com.infinitysoftware.mvvm_getdata.viewmodel.UserDataViewModel

@Composable
fun UserDataView(viewModel: UserDataViewModel) {
    val myData = viewModel.userRepository.observeAsState()

    Box(modifier = Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            if (myData.value?.userName != null || myData.value?.firstName != null || myData.value?.lastName != null || myData.value?.password != null) {
                Text(text = "Username: ${myData.value?.userName}", fontSize = 20.sp, color = Color.Green)
                Text(text = "Full Name: ${myData.value?.firstName} ${myData.value?.lastName}", fontSize = 20.sp, color = Color.Green)
                Text(text = "Password: ${myData.value?.password}", fontSize = 20.sp, color = Color.Green)
            }

            Button(onClick = {viewModel.getUserData() } ) {
                Text(text = "Get User Data")
            }
        }
    }
}