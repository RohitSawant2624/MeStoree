package com.android.mestore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.Model.OfferModel
import com.android.mestore.R
import com.bumptech.glide.Glide

import java.util.ArrayList

class OfferAdapter( val context: Context , val arrOffer: ArrayList<OfferModel> ) : RecyclerView.Adapter<OfferAdapter.ViewHolder>() {
    private var _binding : OfferAdapter?=null
    private val binding get() = _binding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage = itemView.findViewById<ImageView>(R.id.iv_offerImage)
        val offerPrice = itemView.findViewById<TextView>(R.id.txt_offerPrice)
        val offerConstraint= itemView.findViewById<TextView>(R.id.txt_offerConstraint)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offers , parent ,false))
    }

    override fun getItemCount(): Int {

        return arrOffer.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.offerPrice.setText(arrOffer.get(position).price)
       holder.offerConstraint.setText(arrOffer.get(position).constraint)
        Glide.with(context).load(arrOffer.get(position).img).into(holder.offerImage)
    }
}