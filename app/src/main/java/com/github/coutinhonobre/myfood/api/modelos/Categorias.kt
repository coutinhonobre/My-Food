package com.github.coutinhonobre.myfood.api.modelos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Categorias(
    var categorias: List<Categoria>
)

@Parcelize
data class Categoria(
    var id: Long,
    var descricao: String,
    @SerializedName("imagem_receita")
    var imagemReceita: String
): Parcelable