package com.example.dmedia.models
import com.google.gson.annotations.SerializedName

data class Page (

	@SerializedName("title") val title : String,
	@SerializedName("total-content-items") val totalContentItems : Int,
	@SerializedName("page-num") val pageNum : Int,
	@SerializedName("page-size") val pageSize : Int,
	@SerializedName("content-items") val contentitems : ContentItems
)