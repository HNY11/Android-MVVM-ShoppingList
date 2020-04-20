package com.java.android_mvvm_shoppinglist.data.repositories

import com.java.android_mvvm_shoppinglist.data.db.ShoppingDatabase
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem

/**
 * implement all the methods you declare in dao file through your database object
 * you may have multiple dao files in real project for single ui operation
 * Created By Himanshu on 20-04-2020
 */
class ShoppingRepository(
    private val database: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = database.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)

    suspend fun deleteAll() = database.getShoppingDao().deleteAll()

    // don't need suspend for read operation on database
    fun getAllShopItems() = database.getShoppingDao().getAllShoppingItems();

}