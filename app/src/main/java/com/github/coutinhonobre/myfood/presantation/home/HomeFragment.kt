package com.github.coutinhonobre.myfood.presantation.home

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
import androidx.recyclerview.widget.LinearLayoutManager

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.common.HomeCategoriasAdapter
import com.github.coutinhonobre.myfood.common.HomeFavoritosAdapter
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)


        getFavoritos()
        getCategorias()

    }

    private fun getFavoritos() {
        recyViewHomeFavoritos.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.receitasFavoritasLiveData.observe(this, Observer {
            recyViewHomeFavoritos.adapter = HomeFavoritosAdapter(it) { receita ->
                Log.i("RECEITA", receita.receita)
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            }
        })
        viewModel.getReceitasFavoritas()
    }

    private fun getCategorias() {
        recyViewHomeCategorias.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.categoriasLiveData.observe(this, Observer {
            recyViewHomeCategorias.adapter = HomeCategoriasAdapter(it) { categoria ->
                Log.i("RECEITA", categoria.descricao)
                findNavController().navigate(R.id.action_homeFragment_to_listaReceitasFragment)
            }
        })
        viewModel.getCategorias()
    }

}
