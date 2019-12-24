package com.github.coutinhonobre.myfood.presantation.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load

import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Receita
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.item_receitas.view.*

class DetailFragment : Fragment() {


    private var receita: Long = 0

    private lateinit var receitaObj: Receita


    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        receita = arguments?.getLong("id")!!
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        viewModel.getReceitaCategoria(receita).observe(this, Observer {
            it.let {
                it
                txtViewDetailReceita.text = it[0].receita
                ratingBarViewDetailReceita.rating = it[0].rating
                txtViewDetailIngredientes.text = it[0].ingredientes
                txtViewDetailModoDePreparo.text = it[0].modoPreparo

                switchDetailModoDePreparo.isChecked = it[0].like

                receitaObj = it[0]

                imageViewDetailReceita.load(it[0].linkImagem) {
                    crossfade(true)
                    crossfade(1000)
                }
            }

        })

        ratingBarViewDetailReceita.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            receitaObj.rating = ratingBarViewDetailReceita.rating
            viewModel.updateReceita(receitaObj)
        }

        switchDetailModoDePreparo.setOnClickListener {
            receitaObj.like = switchDetailModoDePreparo.isChecked
            viewModel.updateReceita(receitaObj)
        }





        imageViewDetailClose.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

}
