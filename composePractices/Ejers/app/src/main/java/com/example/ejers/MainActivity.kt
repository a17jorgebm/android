package com.example.ejers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejers.ui.theme.EjersTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HelloScreenViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HelloScreenViewModel() as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjersTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var p=innerPadding
                    HelloScreenWithViewModel(this.viewModel)
                }
            }
        }
    }
}

class HelloScreenViewModel: ViewModel(){
    private var _name=MutableLiveData<String>("")
    val name: LiveData<String>
        get()=_name

    fun changeNameValue(newNameValue: String){
        _name.value=newNameValue
    }
}

@Composable
fun HelloScreenWithViewModel(viewModel: HelloScreenViewModel = viewModel()){
    val name: String by viewModel.name.observeAsState("")

    HelloScreenComponent(
        name = name,
        onValueChange = viewModel::changeNameValue
    )
}

@Composable
fun HelloScreenComponent(
    name: String,
    onValueChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (name.isNotBlank()){
            Text(text = "Ola $name")
        }
        OutlinedTextField(
            value = name,
            onValueChange= onValueChange,
            label = {
                Text("Nombre")
            }
        )
    }
}

