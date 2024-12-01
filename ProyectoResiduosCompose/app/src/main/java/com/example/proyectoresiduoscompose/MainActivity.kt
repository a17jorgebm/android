package com.example.proyectoresiduoscompose

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
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

data class BottomNavItem(
    val title : String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = "HomeScreen",
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Rounded.Home
    ),
    BottomNavItem(
        title = "Config",
        route = "RouteDestinationsScreen",
        selectedIcon = Icons.Rounded.Settings,
        unselectedIcon = Icons.Rounded.Settings
    )
)

@Composable
fun HomeScreen(
    navController: NavController
){
    var selectedBottomNavItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        containerColor = Color.Yellow, //para que o menu estea flotando
        topBar = {
            Row(
                Modifier
                    .background(Color(0xFF1D1D1D))
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "Foto de perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(1f)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "Juana",
                            color = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .background(Color(0xFF292928))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ){
                        IconButton(
                            onClick = {  }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.campana),
                                contentDescription = "Notifications",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF292928),
                modifier = Modifier
                    .background(Color(0xFF292928))
            ) {
                bottomNavItems.forEachIndexed{i, item ->
                    NavigationBarItem(
                        selected = i==selectedBottomNavItem,
                        onClick = {
                            selectedBottomNavItem=i
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(
                                imageVector = item.unselectedIcon,
                                contentDescription = item.title,
                                tint = Color.White
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF1D1D1D))
                .padding(16.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row(
                modifier = Modifier
                    //.padding(16.dp) //margen (ao final fixeno co contedor principal)
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF292928))
                    .clickable {
                        navController.navigate("RouteDestinationsScreen")
                    }
                    //.padding(0.dp) //padding interior (0 para que a imagen ocupe todo)
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
                    painter = painterResource(id = R.drawable.ruta),
                    contentDescription = "Imagen sección trayecto de hoy",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(0.6f)
                )
            }

            Row(
                modifier = Modifier
                    //.padding(16.dp) //margen (ao final fixeno co contedor principal)
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
                //.padding(0.dp) //padding interior (0 para que a imagen ocupe todo)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFD8FF7E))
                        .weight(0.5f)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Tu camión",
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Light))
                            )
                            Text(
                                text = "Ver",
                                color = Color(0xFF7F7F7F), //gris clarito
                                fontSize = 12.sp
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.camion),
                            contentDescription = "Trayectos",
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .height(60.dp)
                                .offset(x = 5.dp, y = 5.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF292928))
                        .weight(0.5f)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Trayectos",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Light))
                            )
                            Text(
                                text = "Ver",
                                color = Color(0xFF7F7F7F), //gris clarito
                                fontSize = 12.sp
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.carretera),
                            contentDescription = "Trayectos",
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .height(60.dp)
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun RouteDestinationsScreen(
    navController: NavController
){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(16.dp,5.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                        contentDescription = "Atrás",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Eiiii",
                color = Color.Black
            )
        }
    }
}