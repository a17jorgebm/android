package com.example.proyectoresiduoscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoresiduoscompose.ui.theme.ProyectoResiduosComposeTheme


val PoppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Light)
    //habería que meter as outras que vou usar
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoResiduosComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController=navController, startDestination = "HomeScreen"){
                        composable("HomeScreen"){
                            HomeScreen(
                                navController=navController
                            )
                        }

                        composable("RouteDestinationsScreen"){
                            RouteDestinationsScreen(
                                navController=navController
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    navController: NavController
){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp) //margen
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF292928))
                    .padding(0.dp) //padding interior (0 para que a imagen ocupe todo)
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(16.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Trayecto de hoy",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Light))
                    )
                    Text(
                        text = "Ver en el mapa",
                        color = Color(0xFFD8FF7E),
                        fontSize = 12.sp
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ruta_app_residuos),
                    contentDescription = "Imagen sección trayecto de hoy",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(0.6f)
                )
            }
        }

    }
}

@Composable
fun RouteDestinationsScreen(
    navController: NavController
){

}