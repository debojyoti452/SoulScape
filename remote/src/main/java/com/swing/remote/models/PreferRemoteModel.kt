package com.swing.remote.models

import com.google.gson.annotations.SerializedName

data class PreferRemoteModel(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
