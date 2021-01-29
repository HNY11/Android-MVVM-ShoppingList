package com.java.android_mvvm_shoppinglist.data.ui.shoppinglist

import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem


/**
 * Author Himanshu
 * Created on  29-January-2021
 */
interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}