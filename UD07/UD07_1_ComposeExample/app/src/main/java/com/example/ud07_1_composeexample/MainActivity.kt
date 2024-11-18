package com.example.ud07_1_composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import com.example.ud07_1_composeexample.ui.theme.UD07_1_ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UD07_1_ComposeExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    myApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun welcomeScreen(modifier: Modifier, onContinueClicked: () -> Unit){

    Surface(color = Color.Cyan){
        Column (modifier = Modifier.fillMaxSize()){
            Text(text = "Bienvenidos a mi app")
            Button(
                modifier = Modifier.padding(20.dp),
                onClick = onContinueClicked)
            {
                Text(text = "Siguiente")
            }
        }
    }
}

@Composable
fun myApp(modifier: Modifier){
    var welcomeScreenHasBeenPainted = rememberSaveable {
        mutableStateOf(false)
    }
    if (!welcomeScreenHasBeenPainted.value){
        welcomeScreen(modifier, onContinueClicked = { welcomeScreenHasBeenPainted.value=true })
    }else{
        ListItems()
    }
}

@Composable
fun ListItems(names: List<String> = List(100) {"$it"}){
    LazyColumn {
        items(items = names){
            name -> Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //po ejer 3
    var expanded= remember {
        mutableStateOf(false)
    }
    val extraPadding=if (expanded.value) 50.dp else 0.dp
    Surface(color = MaterialTheme.colorScheme.primary,
        modifier=Modifier.padding(0.dp,60.dp)) {

        // PRIMEIRO EJERCICIO
        /*
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = modifier
                .padding(15.dp)
                .size(500.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            style = TextStyle(
                fontSize = 30.sp,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5.0f,10.0f)
                )
            )
        )*/

        //SEGUNDO EJERCICIO
        /*
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ){
            Text(
                text = stringResource(id = R.string.oli),
                modifier= modifier
                    .padding(15.dp)
                    .size(500.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    brush = Brush.linearGradient(listOf(Color.Cyan, Color.Red))
                ),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier=Modifier.size(40.dp)
            )
            for (p: String in listaNombres){
                Text(text = p)
            }
            ElevatedButton(onClick = { println("ola") }) {
                Text(text = "Show more")
            }
        }*/

        // TERCEIRO EJERCICIO
        Row(modifier=Modifier.padding(extraPadding)) {
            Column(modifier=Modifier.weight(1f)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(onClick = {
                expanded.value=!expanded.value
            }) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD07_1_ComposeExampleTheme {
        myApp(modifier = Modifier.fillMaxSize())
    }
}