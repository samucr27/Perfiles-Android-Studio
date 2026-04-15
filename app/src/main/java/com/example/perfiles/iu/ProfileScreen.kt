package com.example.perfiles.iu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.perfiles.R
import com.example.perfiles.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, onNavigate: () -> Unit) {
    val isDark = isSystemInDarkTheme()

    val profile = viewModel.profile

    val backgroundColor = if (isDark) Color(0xFF121212) else Color(0xFFF5F5F5)
    val textColor = if (isDark) Color.White else Color(0xFF212121)
    val subTextColor = if (isDark) Color.LightGray else Color(0xFF757575)
    val accentColor = Color(0xFF00C853) // Verde UdeC

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SubcomposeAsyncImage(
            model = profile.imagenUrl,
            contentDescription = "Foto Estudiante",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(3.dp, accentColor, CircleShape)
                .clip(CircleShape)
                .background(Color.Gray),
            loading = {
                CircularProgressIndicator(
                    color = accentColor,
                    modifier = Modifier.padding(48.dp)
                )
            },
            error = {
                Image(
                    painter = painterResource(id = R.drawable.broken_link),
                    contentDescription = "Error de carga"
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = profile.nombre,
            style = MaterialTheme.typography.headlineMedium,
            color = textColor
        )

        Text(
            text = "${profile.programa} - Semestre ${profile.semestre}",
            color = subTextColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = profile.descripcion,
            color = subTextColor,
            modifier = Modifier.padding(horizontal = 24.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNavigate,
            colors = ButtonDefaults.buttonColors(
                containerColor = accentColor,
                contentColor = Color.Black
            )
        ) {
            Text("Ver Hobbies y Detalles")
        }
    }
}