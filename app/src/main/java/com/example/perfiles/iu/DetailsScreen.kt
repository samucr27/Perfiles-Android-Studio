package com.example.perfiles.iu

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perfiles.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(viewModel: ProfileViewModel, onBack: () -> Unit) {
    val profile = viewModel.profile
    val isDark = isSystemInDarkTheme() // Detectar tema para adaptabilidad

    // Colores dinámicos según el tema
    val backgroundColor = if (isDark) Color(0xFF121212) else Color(0xFFF0F0F0)
    val cardColor = if (isDark) Color(0xFF1E1E1E) else Color.White
    val textColor = if (isDark) Color.White else Color.Black
    val subTextColor = if (isDark) Color.LightGray else Color(0xFF424242)
    val accentColor = Color(0xFF00C853) // Verde UdeC

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            TopAppBar(
                title = { Text("Detalles Académicos", color = textColor) },
                navigationIcon = {
                    // Botón de volver sólido (Mejorado) [cite: 75, 124]
                    Button(
                        onClick = onBack,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = accentColor,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.padding(start = 8.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Volver", fontWeight = FontWeight.Bold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isDark) Color(0xFF1E1E1E) else Color(0xFFE0E0E0)
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Slide 1: Información Personal (RF-05) [cite: 124]
            item {
                InfoSlideCard("Información Personal", cardColor, accentColor) {
                    Column {
                        Text("Edad: ${profile.edad} años", color = subTextColor)
                        Text("Ciudad: ${profile.ciudad}", color = subTextColor)
                        Text("Correo: ${profile.correo}", color = subTextColor)
                    }
                }
            }

            // Slide 2: Hobbies (RF-02 / UC-02)
            item {
                InfoSlideCard("Hobbies", cardColor, accentColor) {
                    profile.hobbies.forEach { Text("• $it", color = subTextColor) }
                }
            }

            // Slide 3: Pasatiempos (RF-07 / UC-03)
            item {
                InfoSlideCard("Pasatiempos", cardColor, accentColor) {
                    profile.pasatiempos.forEach { Text("• $it", color = subTextColor) }
                }
            }

            // Slide 4: Deportes (RF-08 / UC-04)
            item {
                InfoSlideCard("Deportes", cardColor, accentColor) {
                    profile.deportes.forEach { Text("• $it", color = subTextColor) }
                }
            }

            // Slide 5: Intereses (RF-09 / UC-05)
            item {
                InfoSlideCard("Intereses", cardColor, accentColor) {
                    profile.intereses.forEach { Text("• $it", color = subTextColor) }
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

/**
 * Componente para crear cada Tarjeta (Slide) de información
 */
@Composable
fun InfoSlideCard(
    title: String,
    cardColor: Color,
    titleColor: Color,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = title,
                color = titleColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            content()
        }
    }
}