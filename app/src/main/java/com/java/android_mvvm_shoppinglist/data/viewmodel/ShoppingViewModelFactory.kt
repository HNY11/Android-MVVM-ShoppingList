package com.java.android_mvvm_shoppinglist.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.java.android_mvvm_shoppinglist.data.repositories.ShoppingRepository

/**
 * Created By Himanshu on 20-04-2020
 */
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}