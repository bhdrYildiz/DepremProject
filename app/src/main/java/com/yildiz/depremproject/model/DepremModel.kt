package com.yildiz.depremproject.model

import com.google.gson.annotations.SerializedName

class DepremModel : ArrayList<DepremModel.DepremModelItem>() {
    data class DepremModelItem(
        @SerializedName("title")
        val title: String
    )
}