package com.infinitysoftware.mvvm_getdata

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.infinitysoftware.mvvm_getdata.ui.theme.MVVMGetDataTheme
import com.infinitysoftware.mvvm_getdata.view.UserDataView
import com.infinitysoftware.mvvm_getdata.viewmodel.UserDataViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel = ViewModelProvider(this)[UserDataViewModel::class]

        setContent {
            MVVMGetDataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserDataView(viewModel)
                }
            }
        }
    }
}