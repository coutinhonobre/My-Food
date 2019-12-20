package com.github.coutinhonobre.myfood.presantation.receitas

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.coutinhonobre.myfood.R

class ListaReceitasFragment : Fragment() {

    companion object {
        fun newInstance() =
            ListaReceitasFragment()
    }

    private lateinit var viewModel: ListaReceitasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_receitas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListaReceitasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
