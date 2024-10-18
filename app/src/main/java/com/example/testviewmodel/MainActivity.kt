package com.example.testviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testviewmodel.ui.theme.TestViewmodelTheme
import testViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestViewmodelTheme {
                ColorChangerApp()
            }
        }
    }
}

@Composable
fun ColorChangerApp(colorViewModel: testViewModel = viewModel()) {
    val color = colorViewModel.color.collectAsState().value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { colorViewModel.changeColor() }) {
            Text(text = "Change Color")
        }
    }
}