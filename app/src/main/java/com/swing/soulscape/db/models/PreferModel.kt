package com.swing.soulscape.db.models

import com.google.gson.annotations.SerializedName

data class PreferModel(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("image")
    val image: Int? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)
