package com.java.android_mvvm_shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A basic class representing an entity that is a row in a four-column database table with one autoIncrement.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 *  @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * Created By Himanshu on 19-04-2020
 */
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int,
    @ColumnInfo(name = "item_unit")
    var unit: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}