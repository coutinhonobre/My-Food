package com.github.coutinhonobre.myfood.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.github.coutinhonobre.myfood.R
import com.github.coutinhonobre.myfood.model.Categoria
import kotlinx.android.synthetic.main.item_home_categorias.view.*
import kotlinx.android.synthetic.main.item_home_favoritos.view.*

class HomeCategoriasAdapter(
    private val categorias: List<Categoria>,
    val onItemClickListener: ((categoria: Categoria) -> Unit)
) : RecyclerView.Adapter<HomeCategoriasAdapter.HomeCategoriaViewHolder>() {

    class HomeCategoriaViewHolder(
        itemView: View,
        val onItemClickListener: ((categoria: Categoria) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(categoria: Categoria) {

            itemView.run {

                txtViewHomeCategoriaDescricao.text = categoria.descricao
                imageViewHomeCategoria.load(categoria.imagemReceita) {
                    crossfade(true)
                    crossfade(1000)
                }

            }



            itemView.setOnClickListener {
                onItemClickListener.invoke(categoria)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_categorias, parent, false)
        return HomeCategoriaViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = categorias.size

    override fun onBindViewHolder(holder: HomeCategoriaViewHolder, position: Int) {
        holder.bindView(categorias[position])
    }
}