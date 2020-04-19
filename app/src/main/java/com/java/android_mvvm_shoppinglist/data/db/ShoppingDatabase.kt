package com.java.android_mvvm_shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem

/**
 *
 * Created By Himanshu on 19-04-2020
 */
@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {

        @Volatile
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()

        // gets called everyTime we initialize the ShoppingDatabase
        // if our instance is null it will call synchronized block and create a database
        // synchronized make sure only one thread can access the method
        // also block is used to pass the result of createDatabase method into instance
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "shoppingItemsDB.db"
            ).build()

    }

}