package com.java.android_mvvm_shoppinglist.data.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.java.android_mvvm_shoppinglist.R
import com.java.android_mvvm_shoppinglist.data.db.ShoppingDatabase
import com.java.android_mvvm_shoppinglist.data.repositories.ShoppingRepository
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModel
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        // code smell :(
        // will be replaced by dependency injection later
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModelProvider = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

    }
}
