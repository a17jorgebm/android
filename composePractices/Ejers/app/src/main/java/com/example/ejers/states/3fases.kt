package com.example.ejers.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// PRIMERA FASE
//en este composable gardase o state dentro, o cal é unha mala practica
// - xa que o fai dificil de reusar
// - dificil de testear
// - fai que estea ligado a como o state se garda
@Composable
fun HelloContent(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var nombre by remember { mutableStateOf("") }
        if (nombre.isNotBlank()) {
            Text(
                "Ola $nombre"
            )
        }
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre=it },
            label = { Text("Name") }
        )
    }
}

/*
SEGUNDA FASE
 usaremos STATE HOSTING: patron de programación onde se move o state dun
  composable ao seu caller (a funcion que chama ao composable)
*/

@Composable
fun HelloScreen(){
    var nombre by remember { mutableStateOf("") }
    var onNameChange = {novoNome:String -> nombre=novoNome}

    HelloContentStateless(nombre, onNameChange)
}

@Composable
fun HelloContentStateless(
    name: String,
    onNameChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (name.isNotBlank()) {
            Text(
                "Ola $name"
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

/*
TERCEIRA FASE
 para poder usar este estado en outros composables, usaremos un ViewModel
*/
class HelloViewModel: ViewModel(){
    private var _name= MutableLiveData<String>("")
    val name: LiveData<String>
        get() = _name

    fun onNameChange(newName: String){
        _name.value=newName
    }
}


//revisar que fai = viewModel()

//e como carallo chamo a esto ahora
@Composable
fun HelloScreenWithViewModel(helloViewModel: HelloViewModel = viewModel()){
    val nombre :String by helloViewModel.name.observeAsState("")

    HelloContentStatelessWithViewModel(
        nombre,
        onNameChange =  { helloViewModel.onNameChange(it) })
}

@Composable
fun HelloContentStatelessWithViewModel(
    name: String,
    onNameChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (name.isNotBlank()) {
            Text(
                "Ola $name"
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}