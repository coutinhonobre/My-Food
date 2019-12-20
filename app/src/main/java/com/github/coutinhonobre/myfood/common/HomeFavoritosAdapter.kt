package com.github.coutinhonobre.myfood.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Receita
import kotlinx.android.synthetic.main.item_home_favoritos.view.*

class HomeFavoritosAdapter(
    private val receitas: List<Receita>,
    val onItemClickListener: ((receita: Receita) -> Unit)
) : RecyclerView.Adapter<HomeFavoritosAdapter.HomeFavoritoViewHolder>() {

    class HomeFavoritoViewHolder(
        itemView: View,
        val onItemClickListener: ((receita: Receita) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(receita: Receita) {

            itemView.run {

                textViewItemHomeFavoritoNomeComida.text = receita.receita
                ratingBarItemHomeFavoritoPontuacao.rating = receita.rating
                imageViewItemHomeFavoritoComida.load(receita.linkImagem) {
                    crossfade(true)
                    crossfade(1000)
                }

            }



            itemView.setOnClickListener {
                onItemClickListener.invoke(receita)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFavoritoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_favoritos, parent, false)
        return HomeFavoritoViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = receitas.size

    override fun onBindViewHolder(holder: HomeFavoritoViewHolder, position: Int) {
        holder.bindView(receitas[position])
    }
}