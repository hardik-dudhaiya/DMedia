package com.example.dmedia.utils

import android.content.Context
import com.example.dmedia.models.BaseResponse
import com.example.dmedia.models.Page
import com.google.gson.Gson
import java.io.IOException



fun getJsonDataFromAsset(context: Context, pageNo: Int): Page? {
        val page: Page
        try {
            val jsonString = context.assets.open("CONTENTLISTINGPAGE-PAGE$pageNo.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val baseResponse = gson.fromJson(jsonString, BaseResponse::class.java)
            page = baseResponse.page
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return page
    }