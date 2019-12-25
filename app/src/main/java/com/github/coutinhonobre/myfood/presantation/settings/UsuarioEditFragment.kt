package com.github.coutinhonobre.myfood.presantation.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Usuario
import kotlinx.android.synthetic.main.usuario_edit_fragment.*

class UsuarioEditFragment : Fragment() {

    private var idUsuario: Long = 0


    private lateinit var viewModel: UsuarioEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        idUsuario = arguments?.getLong("id", 0)!!

        return inflater.inflate(R.layout.usuario_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UsuarioEditViewModel::class.java)

        viewModel.getLogin(idUsuario).observe(this, Observer { usuarios ->
            usuarios.let {
                if (usuarios.isNotEmpty()) {
                    textInputEditUsuarioEditNome.setText(it.first().nome)
                    textInputEditUsuarioEditUsername.setText(it.first().username)
                    textInputEditUsuarioEditSenha.setText(it.first().senha)
                }
            }
        })


        imageViewUsuarioEditClose.setOnClickListener {
            val bundle = Bundle().apply {
                putLong("id", idUsuario)
            }
            findNavController().navigate(R.id.action_usuarioEditFragment_to_homeFragment, bundle)
        }

        buttonCadastroCadastro.setOnClickListener {

            viewModel.updateUsuario(
                Usuario(
                    idUsuario,
                    textInputEditUsuarioEditNome.text.toString(),
                    textInputEditUsuarioEditUsername.text.toString(),
                    textInputEditUsuarioEditSenha.text.toString()
                )
            )

        }

    }

}
