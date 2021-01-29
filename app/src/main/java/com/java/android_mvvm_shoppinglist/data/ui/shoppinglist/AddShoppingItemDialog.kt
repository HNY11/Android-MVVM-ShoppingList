package com.java.android_mvvm_shoppinglist.data.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.java.android_mvvm_shoppinglist.R
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*


/**
 * Author Himanshu
 * Created on  29-January-2021
 */
class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener{

            val name = etName.text.toString()
            val amt = etAmount.text.toString()
            val unit = etUnit.text.toString()

            if (name.isEmpty() || amt.isEmpty() || unit.isEmpty()) {
                Toast.makeText(context, "Please enter value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val shoppingItem = ShoppingItem(name, amt.toInt(), unit)
            addDialogListener.onAddButtonClicked(shoppingItem)
            dismiss()
        }

        tvCancel.setOnClickListener { dismiss() }
    }

}