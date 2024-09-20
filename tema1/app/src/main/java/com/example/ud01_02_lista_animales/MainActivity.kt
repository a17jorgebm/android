package com.example.ud01_02_lista_animales

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSend=findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener({
            val lista=findViewById<Spinner>(R.id.lisAnimals)
            val textoAnimal=findViewById<TextView>(R.id.textSeleccionado)
            //textoAnimal.text="Has seleccionado el animal ${lista.selectedItemId}"
            textoAnimal.text=getAnimalKind(lista.selectedItemId).joinToString("\n")
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun getAnimalKind(id : Long) = when (id){
        0L -> listOf(getString(R.string.chiguagua),getString(R.string.pastor)) //a L é para que o convirta a Long, que é o tipo de dato do id
        1L -> listOf("Egipcio","Persa")
        2L -> listOf("Mallard","White Call")
        else -> listOf()
    }
}