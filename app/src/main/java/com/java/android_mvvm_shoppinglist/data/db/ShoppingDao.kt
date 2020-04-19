package com.java.android_mvvm_shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem

/**
 * DAOs must either be interfaces or abstract classes.
 * @Dao - This annotation identifies it as a DAO class for Room.
 * suspend function is used because we will use Kotlin coroutine
 * Created By Himanshu on 19-04-2020
 */
@Dao
interface ShoppingDao {

    // same method will be used for insert and update
    // OnConflictStrategy REPLACE used because we want to update the item in table if similar
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(shoppingItem: ShoppingItem)

    @Delete
    suspend fun delete(shoppingItem: ShoppingItem)

    @Query("DELETE FROM shopping_items")
    suspend fun deleteAll()

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

}