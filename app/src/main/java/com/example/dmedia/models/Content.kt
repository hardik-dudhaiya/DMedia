package com.example.dmedia.models
import com.google.gson.annotations.SerializedName

data class Content (

	@SerializedName("name") val name : String,
	@SerializedName("poster-image") val posterImage : String
)