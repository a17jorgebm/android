package com.example.repasocompleto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.repasocompleto.databinding.FragmentGameBinding
import com.example.repasocompleto.databinding.FragmentResultBinding

class GameFragment : Fragment() {

    var _binding: FragmentGameBinding? = null
    val binding: FragmentGameBinding
        get()=_binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        val view = binding.root

        val botonComprobar=binding.btnCheckLetter

        botonComprobar.setOnClickListener{
            view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}