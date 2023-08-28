package com.android.mestore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.Model.OrdersModel
import com.android.mestore.R
import com.bumptech.glide.Glide
import java.util.ArrayList

class OrdersAdapter(val context : Context, val arrOrders: ArrayList<OrdersModel>) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ordersImage = itemView.findViewById<ImageView>(R.id.iv_orderImage)
        val ordersStatus = itemView.findViewById<TextView>(R.id.txt_order_status)
        val ordersName= itemView.findViewById<TextView>(R.id.txt_order_Name)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_orders, parent, false))
    }

    override fun getItemCount(): Int {
      return arrOrders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ordersName.setText(arrOrders.get(position).Name)
        holder.ordersStatus.setText(arrOrders.get(position).status)
        Glide.with(context).load(arrOrders.get(position).Imagge).into(holder.ordersImage)
    }
}