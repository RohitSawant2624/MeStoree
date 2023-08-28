package com.android.mestore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.android.mestore.utlis.model.TableCart


class CartAdapter(private val cartClickedListeners: CartClickedListeners) :
    RecyclerView.Adapter<CartAdapter.CartViewHodler>() {
    private var tableCartList: List<TableCart>? = null
    fun setTableCartList(tableCartList: List<TableCart>?) {
        this.tableCartList = tableCartList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHodler {
        val view: View =
            LayoutInflater.from(parent.context).inflate(com.android.mestore.R.layout.item_cart, parent, false)
        return CartViewHodler(view)
    }

    override fun onBindViewHolder(holder: CartViewHodler, position: Int) {
        val tableCart: TableCart = tableCartList!![position]
        holder.tableImageView.setImageResource(tableCart.TableImage)
        holder.tableNameTv.setText(tableCart.TableName)
        holder.tableBrandNameTv.setText(tableCart.TableBrand)
        holder.tableQuantity.setText(tableCart.TableQauntity + "")
        holder.tablePriceTv.setText(tableCart.TotalItemPrice + "")
        holder.deleteTableBtn.setOnClickListener { cartClickedListeners.onDeleteClicked(tableCart) }
        holder.addQuantityBtn.setOnClickListener { cartClickedListeners.onPlusClicked(tableCart) }
        holder.minusQuantityBtn.setOnClickListener { cartClickedListeners.onMinusClicked(tableCart) }
    }

    override fun getItemCount(): Int {
        return if (tableCartList == null) {
            0
        } else {
            tableCartList!!.size
        }
    }

    inner class CartViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val tableNameTv: TextView
         val tableBrandNameTv: TextView
         val tablePriceTv: TextView
         val tableQuantity: TextView
         val deleteTableBtn: ImageView
         val tableImageView: ImageView
         val addQuantityBtn: ImageButton
         val minusQuantityBtn: ImageButton

        init {
            tableNameTv = itemView.findViewById<TextView>(com.android.mestore.R.id.eachCartItemName)
            tableBrandNameTv = itemView.findViewById<TextView>(com.android.mestore.R.id.eachCartItemBrandNameTv)
            tablePriceTv = itemView.findViewById<TextView>(com.android.mestore.R.id.eachCartItemPriceTv)
            deleteTableBtn = itemView.findViewById<ImageView>(com.android.mestore.R.id.eachCartItemDeleteBtn)
            tableImageView = itemView.findViewById<ImageView>(com.android.mestore.R.id.eachCartItemIV)
            tableQuantity = itemView.findViewById<TextView>(com.android.mestore.R.id.eachCartItemQuantityTV)
            addQuantityBtn = itemView.findViewById<ImageButton>(com.android.mestore.R.id.eachCartItemAddQuantityBtn)
            minusQuantityBtn = itemView.findViewById<ImageButton>(com.android.mestore.R.id.eachCartItemMinusQuantityBtn)
        }
    }

    interface CartClickedListeners {
        fun onDeleteClicked( tableCart: TableCart)
        fun onPlusClicked( tableCart: TableCart)
        fun onMinusClicked( tableCart: TableCart)
    }
}

private operator fun Double.plus(s: String): Int {
    return Int.SIZE_BYTES

}

private operator fun Int.plus(s: String): Int {
    return Int.SIZE_BYTES

}








