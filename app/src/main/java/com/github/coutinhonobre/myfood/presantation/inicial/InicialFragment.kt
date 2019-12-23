package com.github.coutinhonobre.myfood.presantation.inicial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.github.coutinhonobre.myfood.R
import kotlinx.android.synthetic.main.inicial_fragment.*

class InicialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.inicial_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonCadastroLogin.setOnClickListener {
            findNavController().navigate(R.id.action_inicialFragment_to_loginFragment)
        }

        buttonCadastroCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_inicialFragment_to_cadastroFragment)
        }

    }

}
