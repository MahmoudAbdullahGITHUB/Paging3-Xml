package com.example.paging3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3.data.remote.model.response.charachter.CharacterDataWrapper
import com.example.paging3.pagination.ItemRepository
import com.example.paging3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ItemViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val adapter = ItemAdapter()
    private var dataResponse:CharacterDataWrapper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observe PagingData from ViewModel and submit to adapter
        lifecycleScope.launch {
            viewModel.items.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        lifecycleScope.launch {
            viewModel.getResponseFlow().collectLatest {data->
                dataResponse = data
            }
        }


    }


}