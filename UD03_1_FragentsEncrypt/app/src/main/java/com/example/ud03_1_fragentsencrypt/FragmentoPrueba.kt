package com.example.ud03_1_fragentsencrypt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class FragmentoPrueba: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflar el diseño desde el fragmento
        /*
        temos que gardar o inflate nunha variable, para poder acceder aos
        elementos e modificalos antes de devolvela
            -dado que antes de facer o inflate non temos acceso aos elementos do fragmento
         */
        val vista= inflater.inflate(R.layout.fragment_fragmento_prueba,container,false);

        val btnStart=vista.findViewById<Button>(R.id.boton_start)
        btnStart.setOnClickListener{
            vista.findNavController().navigate(R.id.action_fragmentoPrueba_to_fragmentMessage)
        }

        //devolvemos a vista
        return vista
    }
}