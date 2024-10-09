package com.example.ud03_1_fragentsencrypt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ud03_1_fragentsencrypt.FragmentMessageDirections

class FragmentMessage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflar el diseño desde el fragmento
        /*
        temos que gardar o inflate nunha variable, para poder acceder aos
        elementos e modificalos antes de devolvela
            -dado que antes de facer o inflate non temos acceso aos elementos do fragmento
         */
        val vista= inflater.inflate(R.layout.fragment_message,container,false);

        val btnStart=vista.findViewById<Button>(R.id.btn_meter_texto)
        btnStart.setOnClickListener{
            vista.findNavController().navigate(FragmentMessageDirections
                .actionFragmentMessageToEncryptedMessageFragment(
                    (vista.findViewById<EditText>
                        (R.id.fragmentoMessage).text.toString())
                ))
        }

        //devolvemos a vista
        return vista
        // Inflate the layout for this fragment
    }
}