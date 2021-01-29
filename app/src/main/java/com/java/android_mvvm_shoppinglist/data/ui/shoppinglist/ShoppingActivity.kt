package com.java.android_mvvm_shoppinglist.data.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.java.android_mvvm_shoppinglist.R
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModel
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), AddDialogListener, KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    private lateinit var viewModelProvider: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        viewModelProvider = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        fab.setOnClickListener {
            AddShoppingItemDialog(this, this).show()
        }

        val shoppingItemsAdapter = ShoppingItemAdapter(listOf(), viewModelProvider)

        rvShoppingItems.also {
            it.setHasFixedSize(true)
            it.adapter = shoppingItemsAdapter
        }

        viewModelProvider.getAllShopItems().observe(this, Observer { list ->
            shoppingItemsAdapter.items = list
            shoppingItemsAdapter.notifyDataSetChanged()
        })

    }

    override fun onAddButtonClicked(item: ShoppingItem) {
        viewModelProvider.upsert(item)
    }

}
