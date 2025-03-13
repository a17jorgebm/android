package com.example.binding2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.binding2.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    var _binding: FragmentOrderBinding? = null
    val binding: FragmentOrderBinding
        get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater,container,false)
        val view = binding.root
        val radioGroup: RadioGroup= binding.radioGroupComida
        val btnEnviar: Button=binding.btnSend

        btnEnviar.setOnClickListener{
            val idRadioSelected = radioGroup.checkedRadioButtonId
            if (idRadioSelected!=-1){
                val radioSelected: RadioButton = view.findViewById(idRadioSelected)
                Snackbar.make(
                    view,
                    "Seleccionado: ".plus(radioSelected.text),
                    Snackbar.LENGTH_LONG
                ).setAction("Undo"){
                    radioGroup.clearCheck()
                }.show()
            }else{
                Toast.makeText(activity,"Selecciona algo",Toast.LENGTH_LONG)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}