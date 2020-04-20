package com.java.android_mvvm_shoppinglist.data.viewmodel

import androidx.lifecycle.ViewModel
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem
import com.java.android_mvvm_shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By Himanshu on 20-04-2020
 */

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun deleteAll() = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteAll()
    }

    fun getAllShopItems() = repository.getAllShopItems()

}