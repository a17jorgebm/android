package com.example.ud03_1_fragentsencrypt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentoPrueba: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflar el diseño desde el fragmento
        return inflater.inflate(R.layout.fragment_fragmento_prueba,container,false);
    }
}