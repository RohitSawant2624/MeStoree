package com.android.mestore

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.adapter.CartAdapter
import com.android.mestore.adapter.CartAdapter.CartClickedListeners
import com.android.mestore.utlis.model.TableCart
import com.android.mestore.viewmodel.CartViewModel


class Mycart: AppCompatActivity(), CartClickedListeners {
    private var recyclerView: RecyclerView? = null
    private var cartViewModel: CartViewModel? = null
    private var totalCartPriceTv: TextView? = null
    private var textView: TextView? = null
    private var checkoutBtn: AppCompatButton? = null
    private var cardView: CardView? = null
    private var cartAdapter: CartAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.android.mestore.R.layout.activity_mycart)
        initializeVariables()
        cartViewModel!!.allCartItems.observe(this, object : Observer<List<TableCart>> {
            override fun onChanged(tableCarts: List<TableCart>) {
                var price = 0.0
                cartAdapter!!.setTableCartList(tableCarts)
                for (i in tableCarts.indices) {
                    price = price + tableCarts[i].TotalItemPrice
                }
                totalCartPriceTv!!.text = price.toString()
            }
        })
        checkoutBtn!!.setOnClickListener {
            cartViewModel!!.deleteAllCartItems()
            textView!!.visibility = View.INVISIBLE
            checkoutBtn!!.visibility = View.INVISIBLE
            totalCartPriceTv!!.visibility = View.INVISIBLE
            cardView!!.visibility = View.VISIBLE
        }
    }

    private fun initializeVariables() {
        cartAdapter = CartAdapter(this)
        textView = findViewById<TextView>(com.android.mestore.R.id.textView2)
        cardView = findViewById<CardView>(com.android.mestore.R.id.cartActivityCardView)
        totalCartPriceTv = findViewById<TextView>(com.android.mestore.R.id.cartActivityTotalPriceTv)
        checkoutBtn = findViewById<AppCompatButton>(com.android.mestore.R.id.cartActivityCheckoutBtn)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        recyclerView = findViewById<RecyclerView>(com.android.mestore.R.id.cartRecyclerView)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(this))
        recyclerView?.setAdapter(cartAdapter)
    }

    override fun onDeleteClicked(tableCart: TableCart) {
        cartViewModel!!.deleteCartItem(tableCart)
    }

    override fun onPlusClicked(tableCart: TableCart) {
        val quantity: Int = tableCart.TableQauntity + 1
        cartViewModel!!.updateQuantity(tableCart.id, quantity)
        cartViewModel!!.updatePrice(tableCart.id, quantity *tableCart.TablePrice)
        cartAdapter!!.notifyDataSetChanged()
    }

    override fun onMinusClicked(tableCart: TableCart) {
        val quantity: Int = tableCart.TableQauntity - 1
        if (quantity != 0) {
            cartViewModel!!.updateQuantity(tableCart.id, quantity)
            cartViewModel!!.updatePrice(tableCart.id, quantity *tableCart.TablePrice)
            cartAdapter!!.notifyDataSetChanged()
        } else {
            cartViewModel!!.deleteCartItem(tableCart)
        }
    }
}//(getApplicationContext(), getItem, Toast.LENGTH_LONG).show()