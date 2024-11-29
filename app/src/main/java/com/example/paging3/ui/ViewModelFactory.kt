package com.example.paging3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paging3.pagination.ItemRepository

//class ViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return ItemViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
