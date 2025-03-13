package com.example.repasocompleto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.repasocompleto.databinding.FragmentGameBinding
import com.example.repasocompleto.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    var _binding: FragmentResultBinding? = null
    val binding: FragmentResultBinding
        get()=_binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = { requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.btnRestart.setOnClickListener{
            view.findNavController().popBackStack()
        }


        val actionBarBottom = binding.containerResult //o id
        actionBarBottom.setupWithNavController(view.findNavController())
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, findNavController())
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menuInflater.inflate(R.idmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}