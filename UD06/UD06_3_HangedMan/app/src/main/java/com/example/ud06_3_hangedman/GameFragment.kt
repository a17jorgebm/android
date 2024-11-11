package com.example.ud06_3_hangedman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud06_3_hangedman.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    var _binding : FragmentGameBinding? = null
    val binding
        get() = _binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val vista=binding.root

        Toast.makeText(activity,model.targetWord,Toast.LENGTH_SHORT).show()
        binding.textSecretWord.text=model.showTargetWordHidden()
        binding.textLifes.text=String.format(getString(R.string.remaining_lives),model.lives)

        binding.btnNext.setOnClickListener{
            model.targetWord = "Prueba"
            vista.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}