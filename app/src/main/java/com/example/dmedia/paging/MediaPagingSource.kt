package com.example.dmedia.paging

import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dmedia.models.Content
import com.example.dmedia.utils.getJsonDataFromAsset
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MediaPagingSource @Inject constructor(@ApplicationContext val context: Context) : PagingSource<Int,Content>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Content> {
        return try {
            val position = params.key ?: 1
            val response = getJsonDataFromAsset(context,position)
            LoadResult.Page(
                data = response?.contentitems?.content ?: listOf<Content>(),
                prevKey = if(position == 1) null else position - 1,
                nextKey = if(position == 3) null else position + 1
            )
        }
        catch (e : Exception)
        {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Content>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1) ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}