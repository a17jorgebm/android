package com.example.ud03_1_fragentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Encrypted_Message_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Encrypted_Message_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista= inflater.inflate(R.layout.fragment_encrypted__message_, container, false)
        val mensaje=Encrypted_Message_FragmentArgs.fromBundle(requireArguments()).message
        val mensajeCifrado=cifrarStringCesar(mensaje,3)

        val textoMostrarMensajeCifrado= vista.findViewById<TextView>(R.id.texto_encriptado)
        textoMostrarMensajeCifrado.text = mensajeCifrado

        return vista
    }

    fun cifrarStringCesar(text: String, desplazamiento: Int) : String{
        val cifrado= StringBuilder();

        for (caracter in text){
            val asciiCaracter=caracter.code
            val asciiConDesplazamiento=asciiCaracter+desplazamiento
            val hexadecimalAsciiConDesplazamiento=asciiConDesplazamiento.toString(16)
            cifrado.append(hexadecimalAsciiConDesplazamiento)
        }
        return cifrado.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Encrypted_Message_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Encrypted_Message_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}