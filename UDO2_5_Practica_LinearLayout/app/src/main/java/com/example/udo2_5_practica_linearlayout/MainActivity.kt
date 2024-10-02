package com.example.udo2_5_practica_linearlayout

import android.os.Bundle
import android.widget.Button
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonLlamar=findViewById<Button>(R.id.btnLlamar)
        val txtNombre=findViewById<TextView>(R.id.txtNombre)
        var txtAviso=findViewById<TextView>(R.id.txtAviso)
        botonLlamar.setOnClickListener({
            txtAviso.text=String.format(getString(R.string.llamando_a),txtNombre.text)
        })
    }
}