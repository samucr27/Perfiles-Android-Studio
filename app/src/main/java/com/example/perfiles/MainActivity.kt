package com.example.perfiles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.perfiles.iu.AppNavigation
import com.example.perfiles.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ProfileViewModel()

        setContent {
            MaterialTheme {
                Surface {

                    AppNavigation(viewModel)
                }
            }
        }
    }
}