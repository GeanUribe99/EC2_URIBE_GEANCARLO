package com.example.ec2_uribe_geancarlo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ec2_uribe_geancarlo.model.Tests

@Composable
fun ItemReciclerTesting(tests: Tests){
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White)) {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Column (
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = tests.titulo, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = tests.descripcion, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = tests.fecha, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReciclerView(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tests Psicologicos")}
            )
        }
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = innerPadding
        ) {
            items(ListTests()) {
                ItemReciclerTesting(tests = it)
            }
        }
    }
}


fun ListTests (): List<Tests> {
    return listOf(
        Tests("Test de Matrices Progresivas de Raven", "Evalúa la capacidad de razonamiento abstracto y la resolución de problemas.", "1938"),
        Tests("Escala de Inteligencia Wechsler para Adultos (WAIS-IV)", "Evalúa el funcionamiento intelectual en diferentes áreas cognitivas.", "2008"),
        Tests("Inventario Multifásico de Personalidad de Minnesota (MMPI-2)", "Evalúa diferentes aspectos de la personalidad.", "1942"),
        Tests("Test de Rorschach", "Evalúa la personalidad, el funcionamiento emocional y los procesos cognitivos.", "1921"),
        Tests("Test de Apercepción Temática (TAT)", "Evalúa la personalidad, la motivación y las necesidades.", "1939"),
        Tests("Cuestionario de Personalidad NEO-PI-R", "Evalúa los cinco grandes factores de la personalidad.", "1989"),
        Tests("Inventario de Depresión de Beck (BDI-II)", "Evalúa la severidad de la depresión.", "1961"),
        Tests("Escala de Ansiedad de Estado-Rasgo de Spielberger (STAI)", "Evalúa dos tipos de ansiedad: la ansiedad de estado y la ansiedad de rasgo.", "1970"),
        Tests("Escala de Autoestima de Rosenberg", "Evalúa la autoestima global y la autoestima en diferentes áreas de la vida.", "1965"),
        Tests("Cuestionario de Afrontamiento de Estrés de Ways (COPE)", "Evalúa las diferentes estrategias que las personas utilizan para afrontar el estrés.", "1988")
    )
}