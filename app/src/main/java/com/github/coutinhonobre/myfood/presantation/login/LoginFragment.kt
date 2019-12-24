package com.github.coutinhonobre.myfood.presantation.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.github.coutinhonobre.myfood.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        buttonLoginLogin.setOnClickListener {


            buttonLoginLogin.isEnabled = false
            progressBarLogin.visibility = View.VISIBLE
            viewModel.getLogin(
                textInputEditLoginUsername.text.toString(),
                textInputEditLoginSenha.text.toString()).observe(this, Observer {
                if(it.isNotEmpty()) {
                    val bundle = Bundle().apply {
                        putLong("id", it[0].id)
                    }
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                }else{
                    progressBarLogin.visibility = View.GONE
                    buttonLoginLogin.isEnabled = true
                    Toast.makeText(this.context, getString(R.string.usuario_ou_senha_incorretos), Toast.LENGTH_LONG).show()
                }

            })


        }

        textViewLoginLoginCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment2)
        }



    }

}
