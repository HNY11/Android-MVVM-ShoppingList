package com.java.android_mvvm_shoppinglist.data.ui.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.java.android_mvvm_shoppinglist.R
import com.java.android_mvvm_shoppinglist.data.db.entities.ShoppingItem
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*


/**
 * Author Himanshu
 * Created on  29-January-2021
 */
class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false))
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        val shoppingItem = items[position]

        holder.itemView.tvName.text = shoppingItem.name
        holder.itemView.tvAmount.text = "${shoppingItem.amount}"
        holder.itemView.tvUnit.text = shoppingItem.unit

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(shoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener{
            shoppingItem.amount++
            viewModel.upsert(shoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener{
            if (shoppingItem.amount > 0){
                shoppingItem.amount--
                viewModel.upsert(shoppingItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}