package com.example.ud05_1_justit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.ud05_1_justit.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    var _binding: FragmentOrderBinding? = null
    val binding: FragmentOrderBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //tema6 binding
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val vista = binding.root
        //antes
        // val vista = inflater.inflate(R.layout.fragment_order, container, false)
        val barraHerramientas = vista.findViewById<MaterialToolbar>(R.id.toolbar)

        //pillamos a actividad do contenedor pai para poñer a barra por defecto
        (activity as AppCompatActivity).setSupportActionBar(barraHerramientas)

        //pillo o fab e añadolle un actionlistener
        val favButton = vista.findViewById<FloatingActionButton>(R.id.fabSend)
        val burguerGroup = vista.findViewById<RadioGroup>(R.id.radio_grupo)
        val chipGroup= vista.findViewById<ChipGroup>(R.id.chipgroup_extras)

        favButton.setOnClickListener {
            val tipoBorgesa=burguerGroup.checkedRadioButtonId
            val seleccionadosChips=chipGroup.checkedChipIds

            if (tipoBorgesa == -1){
                Toast.makeText(activity,R.string.select_tipo,Toast.LENGTH_SHORT).show()
            }else{
                var mensajeParaFormatear=getString(R.string.burguer_selected)
                mensajeParaFormatear=String.format(mensajeParaFormatear,when(tipoBorgesa){
                    R.id.radio_pollo -> getString(R.string.pollo)
                    R.id.radio_puerco -> getString(R.string.puerco)
                    R.id.radio_vaca -> getString(R.string.vaca)
                    else -> "error"
                })

                if (seleccionadosChips.size>0){
                    mensajeParaFormatear+="\n"+getString(R.string.with_extras)
                    seleccionadosChips.forEach { id ->
                       //mensajeParaFormatear+="\t"+ (chipGroup[id] as Chip).text
                        println("\t"+ (chipGroup[id] as Chip).text.toString())
                        println(id)
                    }
                }

                //enseñaria o mensaje mui bonico
                //Toast.makeText(activity,mensajeParaFormatear,Toast.LENGTH_SHORT).show()

                //doutra maneira con un boton no que se pode facer unha accion
                val snackbar= Snackbar.make(favButton,mensajeParaFormatear,Snackbar.LENGTH_SHORT)
                snackbar.setAction("Desfacer"){
                    burguerGroup.clearCheck()
                    chipGroup.clearCheck()
                }
                snackbar.show()
            }

        }

        return vista
    }
}