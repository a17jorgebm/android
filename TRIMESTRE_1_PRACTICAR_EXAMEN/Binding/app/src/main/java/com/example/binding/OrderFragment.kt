package com.example.binding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.binding.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    var _binding : FragmentOrderBinding? = null
    val binding : FragmentOrderBinding
        get()= _binding!! //co !! indicamos que cando se acceda o _binding non vai ser null NUNCA, senon peta

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater,container,false)
        val view = binding.root
        val radioGroup: RadioGroup = binding.radioGroupSelectFood
        val btnSend : Button = binding.btnSend

        btnSend.setOnClickListener{
            val checkedRadioId=radioGroup.checkedRadioButtonId
            if(checkedRadioId == -1 ){
                Toast.makeText(activity, "Selecciona algo", Toast.LENGTH_LONG).show()
            }else{
                val radioText = view.findViewById<RadioButton>(checkedRadioId).text
                Snackbar.make(
                    view,
                    "Seleccionado: ".plus(radioText),
                    Snackbar.LENGTH_LONG
                ).setAction("Undo"){
                    radioGroup.clearCheck()
                }.show()
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}