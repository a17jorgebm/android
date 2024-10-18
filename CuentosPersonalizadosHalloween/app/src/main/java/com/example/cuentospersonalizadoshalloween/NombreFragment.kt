package com.example.cuentospersonalizadoshalloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController

class NombreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista = inflater.inflate(R.layout.fragment_nombre, container, false)
        var botonNext= vista.findViewById<Button>(R.id.btn_next_fragment_nombre);
        botonNext.setOnClickListener{
            vista.findNavController().navigate( //xa non hai que facer esto porque NombreFragmentDirections.actionNombreFragmentToSeleccionarTematica xa o fai
                NombreFragmentDirections
                    .actionNombreFragmentToSeleccionarTematica(
                        vista.findViewById<EditText>(R.id.edit_txt_introduce_nombre).text.toString()
                    )
            )
        }
        return vista
    }
}