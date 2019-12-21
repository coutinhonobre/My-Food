package com.github.coutinhonobre.myfood.presantation.receitas

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.common.ReceitasAdapter
import kotlinx.android.synthetic.main.lista_receitas_fragment.*

class ListaReceitasFragment : Fragment() {



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

        recyclerViewLayoutListaReceitasPesquisa.layoutManager = LinearLayoutManager(this.context)

        viewModel.receitaLiveData.observe(this, Observer {
            recyclerViewLayoutListaReceitasPesquisa.adapter = ReceitasAdapter(it){ receita ->
                findNavController().navigate(R.id.action_listaReceitasFragment_to_detailFragment)
            }
        })

        viewModel.getReceitasCategoria(1)


        imageViewListaReceitasReturn.setOnClickListener {
            findNavController().navigate(R.id.action_listaReceitasFragment_to_homeFragment)
        }

        textEditTextListaReceitasPesquisa.addTextChangedListener {
            viewModel.getReceitasNome(it.toString())
        }
    }

}
