package com.github.coutinhonobre.myfood.presantation.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.common.HomeCategoriasAdapter
import com.github.coutinhonobre.myfood.common.HomeFavoritosAdapter
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private var idUsuario: Long = 0

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        idUsuario = arguments?.getLong("id", 0)!!

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        textViewHomeNome.text = ";)"

        getFavoritos()
        getCategorias()

        viewModel.getUsuario(idUsuario).observe(this, Observer {
            it.let {
                if (it.isNotEmpty()){
                    textViewHomeNome.text = "${it[0].nome} ;)"
                }
            }
        })

        imageViewHomeSettings.setOnClickListener {
            val bundle = Bundle().apply {
                putLong("id", idUsuario)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_usuarioEditFragment,
                bundle
            )
        }

    }

    private fun getFavoritos() {
        recyViewHomeFavoritos.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.getReceitasFavoritas().observe(this, Observer {
            recyViewHomeFavoritos.adapter = HomeFavoritosAdapter(it) { receita ->
                Log.i("RECEITA", receita.receita)
                val bundle = Bundle().apply {
                    putLong("id", receita.id)
                    putLong("idUsuario", idUsuario)
                }
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
            }
        })
    }

    private fun getCategorias() {
        recyViewHomeCategorias.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.getCategorias().observe(this, Observer {
            recyViewHomeCategorias.adapter = HomeCategoriasAdapter(it) { categoria ->
                val bundle = Bundle().apply {
                    putLong("id", categoria.id)
                    putLong("idUsuario", idUsuario)
                }
                findNavController().navigate(
                    R.id.action_homeFragment_to_listaReceitasFragment,
                    bundle
                )
            }
        })
    }

}
