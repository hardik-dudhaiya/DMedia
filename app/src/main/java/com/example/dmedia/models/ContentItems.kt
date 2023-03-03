package com.example.dmedia.models
import com.google.gson.annotations.SerializedName

data class ContentItems (

	@SerializedName("content") val content : List<Content>
)