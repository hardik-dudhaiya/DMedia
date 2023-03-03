package com.example.dmedia.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dmedia.R
import com.example.dmedia.adapters.MediaAdapter
import com.example.dmedia.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.viewModels
import androidx.paging.filter

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var mediaAdapter: MediaAdapter

    val viewModel: HomeViewModel by viewModels()

    private var gridLayoutManager: GridLayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridLayoutManager = GridLayoutManager(this, resources.getInteger(R.integer.grid_column_count))

        binding.rvMedialist.run {
            layoutManager = gridLayoutManager
            adapter = mediaAdapter
        }

        getData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu,menu)
        val searchItem = menu?.findItem(R.id.actionSearch)
        val searchView = searchItem!!.actionView as SearchView?
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                if(newText.isNotEmpty() && newText.length >= 3)
                {
                    filter(newText)
                }
                else
                {
                    filter("")
                }


                return false
            }
        })
        return true
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        gridLayoutManager?.spanCount = resources.getInteger(R.integer.grid_column_count)
    }

    fun filter(query : String)
    {
        if(query.isNotEmpty()) {
            val filterData = viewModel.mediaList.value?.filter { content -> content.name.lowercase().contains(query.lowercase()) }
            mediaAdapter.submitData(lifecycle,filterData!!)
        }
        else
        {
            mediaAdapter.submitData(lifecycle,viewModel.mediaList.value!!)
        }
    }

    fun getData()
    {
        viewModel.mediaList.observe(this){
            mediaAdapter.submitData(lifecycle,it)
        }
    }
}