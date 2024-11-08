package com.example.ud06_3_hangedman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ud06_3_hangedman.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    var _binding :FragmentResultBinding? = null
    val binding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentResultBinding.inflate(inflater, container, false)
        val vista=binding.root
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}