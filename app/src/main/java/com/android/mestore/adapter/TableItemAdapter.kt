package com.android.mestore.adapter
import TableItem
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.Model.DealsModel
import com.android.mestore.Model.OfferModel
import com.android.mestore.R
import java.lang.String
import java.util.ArrayList
import kotlin.Int

class TableItemAdapter(val context: Context, val arrdeals: ArrayList<DealsModel>): RecyclerView.Adapter<TableItemAdapter.ViewHolder>() {
    private var _binding : TableItemAdapter?=null
    private val binding get() = _binding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dealsImage = itemView.findViewById<ImageView>(R.id.eachShoeIv)
        val offerPrice = itemView.findViewById<TextView>(R.id.txt_offerPrice)
        val offerConstraint= itemView.findViewById<TextView>(R.id.txt_offerConstraint)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}