package com.example.dmedia.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.dmedia.models.BaseResponse
import com.example.dmedia.models.Content
import com.example.dmedia.models.Page
import com.example.dmedia.paging.MediaPagingSource
import com.example.dmedia.utils.getJsonDataFromAsset
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class HomeRepository @Inject constructor(@ApplicationContext val context: Context) {

    fun getMedia() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 60),
        pagingSourceFactory = {MediaPagingSource(context)}
    ).liveData
}