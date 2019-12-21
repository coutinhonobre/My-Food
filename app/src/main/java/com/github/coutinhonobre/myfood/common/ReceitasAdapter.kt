package com.github.coutinhonobre.myfood.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Receita
import kotlinx.android.synthetic.main.item_receitas.view.*

class ReceitasAdapter(
    private val receitas: List<Receita>,
    val onItemClickListener: ((receita: Receita) -> Unit)
) : RecyclerView.Adapter<ReceitasAdapter.ReceitasViewHolder>() {

    class ReceitasViewHolder(
        itemView: View,
        val onItemClickListener: ((receita: Receita) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(receita: Receita){

            itemView.run {

                textViewItemReceitasFavoritoNomeComida.text = receita.receita
                ratingBarItemReceitasFavoritoPontuacao.rating = receita.rating
                imageViewItemReceitasFavoritoComida.load(receita.linkImagem) {
                    crossfade(true)
                    crossfade(1000)
                }

            }

            itemView.setOnClickListener {
                onItemClickListener.invoke(receita)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitasViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receitas, parent, false)
        return ReceitasViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = receitas.size

    override fun onBindViewHolder(holder: ReceitasViewHolder, position: Int) {
        holder.bindView(receitas[position])
    }


}