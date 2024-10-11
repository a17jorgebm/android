package com.example.ud03_1_fragentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [EncryptedMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EncryptedMessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista= inflater.inflate(R.layout.fragment_encrypted_message, container, false)
        val mensaje=EncryptedMessageFragmentArgs.fromBundle(requireArguments()).message
        val mensajeCifrado=cifrarStringCesarKotlinGuay(mensaje,3)

        val textoMostrarMensajeCifrado= vista.findViewById<TextView>(R.id.texto_encriptado)
        textoMostrarMensajeCifrado.text = mensajeCifrado

        return vista
    }

    private fun cifrarStringCesarKotlinGuay(text: String, desplazamiento: Int) =
        text.map {
            if (it.isLetter())
                it.uppercaseChar().code //pillamos o codigo do char
                    .minus('A'.code).plus(desplazamiento) //restamoslle o codigo de A e sumamoslle o desplazamiento
                    .mod(26) //dividimolo entre 26 (que é o numero de letras) e pillamos o resto
                    .plus('A'.code) //volvemoslle a sumar o codigo de A
                    .toChar() //pasamolo a char
            else
                it//se non é letra non se cifra
        }.joinToString("") //cada valor devolto polo map gardao nun array de strings(separado por nada xa como llo indicamos no argumento)

    private fun cifrarStringCesarNormal(text: String, desplazamiento: Int) : String{
        val cifrado= StringBuilder();

        for (caracter in text){
            val asciiCaracter=caracter.code
            val asciiConDesplazamiento=asciiCaracter+desplazamiento
            val hexadecimalAsciiConDesplazamiento=asciiConDesplazamiento.toString(16)
            cifrado.append(hexadecimalAsciiConDesplazamiento)
        }
        return cifrado.toString()
    }

}