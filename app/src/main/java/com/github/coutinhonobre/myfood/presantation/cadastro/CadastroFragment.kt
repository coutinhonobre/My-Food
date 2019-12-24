package com.github.coutinhonobre.myfood.presantation.cadastro

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Usuario
import kotlinx.android.synthetic.main.cadastro_fragment.*

class CadastroFragment : Fragment() {


    private lateinit var viewModel: CadastroViewModel

    var usuario: String = ""
    var senha: String = ""
    var name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CadastroViewModel::class.java)

        textViewCadastroLogin.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
        }



        buttonCadastroCadastro.setOnClickListener {
            progressBarCadastro.visibility = View.VISIBLE
            buttonCadastroCadastro.isEnabled = false
            name = textInputEditCadastroNome.text.toString()
            usuario = textInputEditCadastroUsername.text.toString()
            senha = textInputEditCadastroSenha.text.toString()
            viewModel.setLogin(
                Usuario(
                nome = name,
                username = usuario,
                senha = senha
            ))

            checarLogin()

        }





    }

    private fun checarLogin() {
        viewModel.getLogin(usuario, senha).observe(this, Observer {
            it.let {

                if (it.isNotEmpty()) {
                    Toast.makeText(
                        this.context,
                        getString(R.string.cadastrado_realizado_com_sucesso),
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
                } else
                    Log.e("USUARIOC", it.toString())

            }
        })
    }

}
