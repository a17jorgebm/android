package com.example.ud05_1_justit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_order, container, false)
        val barraHerramientas = vista.findViewById<MaterialToolbar>(R.id.toolbar)

        //pillamos a actividad do contenedor pai para poñer a barra por defecto
        (activity as AppCompatActivity).setSupportActionBar(barraHerramientas)

        return vista
    }
}