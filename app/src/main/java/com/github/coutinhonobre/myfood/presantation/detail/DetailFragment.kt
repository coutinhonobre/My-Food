package com.github.coutinhonobre.myfood.presantation.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load

import com.github.coutinhonobre.myfood.R
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.item_receitas.view.*

class DetailFragment : Fragment() {




    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        viewModel.receitaLiveData.observe(this, Observer {
            txtViewDetailReceita.text = it.receita
            ratingBarViewDetailReceita.rating = it.rating
            txtViewDetailIngredientes.text = it.ingredientes
            txtViewDetailModoDePreparo.text = it.modoPreparo

            imageViewDetailReceita.load(it.linkImagem) {
                crossfade(true)
                crossfade(1000)
            }
        })

        viewModel.getReceitaCategoria(2)


        imageViewDetailClose.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

}
