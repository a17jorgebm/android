package com.example.ud07_1_composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun myApp(modifier: Modifier){
    Greeting(listaNombres = listOf("Jorge","Pepino"))
}

@Composable
fun Greeting(listaNombres: List<String>, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
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