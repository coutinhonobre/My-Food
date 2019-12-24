package com.github.coutinhonobre.myfood.api.modelos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Receitas(
    var receitas: List<Receita>
)

@Parcelize
data class Receita(
    var receita: String,
    var ingredientes: String,
    var categorias: Long,
    @SerializedName("modoPreparo")
    var modoPreparo: String,
    @SerializedName("link_imagem")
    var linkImagem: String

): Parcelable