package com.android.mestore

import TableItem
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.mestore.utlis.model.TableCart
import com.android.mestore.viewmodel.CartViewModel
import java.lang.String
import kotlin.IntArray
import kotlin.intArrayOf


class DetailedActivity : AppCompatActivity() {
    private var tableImageView: ImageView? = null
    private var tableNameTV: TextView? = null
    private var tableBrandNameTV: TextView? = null
    private var tablePriceTV: TextView? = null
    private var addToCartBtn: AppCompatButton? = null
    private var table: TableItem? = null
    private var viewModel: CartViewModel? = null
    private var tableCartList: MutableList<TableCart>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.android.mestore.R.layout.activity_detailed)
        table = intent.getParcelableExtra("tableItem")
        initializeVariables()
        viewModel!!.allCartItems.observe(this, object : Observer<List<TableCart>> {

           override fun onChanged(tableCarts: List<TableCart>?) {
                tableCartList!!.addAll(tableCarts!!)
            }
        })
        if (table != null) {
            setDataToWidgets()
        }
        addToCartBtn!!.setOnClickListener { insertToRoom() }
    }

    private fun insertToRoom() {
        val tableCart = TableCart(0,
            table?.tableName.toString(), table?.tableBrandName.toString(),table?.tableImage!!.toInt(),table?.tablePrice!!.toDouble(),0,0.0)
        tableCart.TableName=table?.tableName.toString()
        tableCart.TableBrand=table?.tableBrandName.toString()
        tableCart.TablePrice=table!!.tablePrice.toDouble()
        tableCart.TableImage=table!!.tableImage.toInt()
//        tableCart.setTableName(table!!.getTableName())
//        tableCart.setTableBrandName(table!!.getTableBrandName())
//        tableCart.setTablePrice(table!!.getTablePrice())
//        tableCart.setTableImage(table!!.getTableImage())
        val quantity = intArrayOf(1)
        val id = IntArray(1)
//        if (!!tableCartList.isEmpty()) {
//            for (i in 0 until tableCartList.size()) {
//                if (tableCart.getTableName().equals(tableCartList.get(i).getTableName())) {
//                    quantity[0] = tableCartList.get(i).getQuantity()
//                    quantity[0]++
//                    id[0] = tableCartList.get(i).getId()
//                }
//            }
//        }
//        if (quantity[0] == 1) {
//            shoeCart.setQuantity(quantity[0])
//            shoeCart.setTotalItemPrice(quantity[0] * shoeCart.getShoePrice())
//            viewModel!!.insertCartItem(shoeCart)
//        } else {
//            viewModel!!.updateQuantity(id[0], quantity[0])
//            viewModel!!.updatePrice(id[0], quantity[0] * shoeCart.getShoePrice())
//        }
//        startActivity(Intent(this@DetailedActivity, CartActivity::class.java))
//    }

//    private fun insertToRoom() {
//
//        val tableCart = TableCart(0,
//            table?.tableName.toString(), table?.tableBrandName.toString(),table?.tableImage!!.toInt(),table?.tablePrice!!.toDouble(),0,0.0)
//        tableCart.TableName=tableNameTV?.text.toString()
//        tableCart.setTableName(table.tableName)
//        tableCart.setTableBrand(tableCart.TableBrand)
//        tableCart.setTablePrice(tableCart.TablePrice)
//        tableCart.setTableImage(tableCart.TableImage)
//        val quantity = intArrayOf(1)
//        val id = IntArray(1)
        if (!tableCartList!!.isEmpty()) {
            for (i in tableCartList!!.indices) {
                if (tableCart.TableName.equals(tableCartList!![i].TableName)) {
                    quantity[0] = tableCartList!![i].TableQauntity
                    quantity[0]++
                    id[0] = tableCartList!![i].id
                }
            }
        }
        if (quantity[0] == 1) {
            tableCart.TableQauntity = quantity[0]
            tableCart.TotalItemPrice = quantity[0] * tableCart.TablePrice
            viewModel!!.insertCartItem(tableCart)
        } else {
            viewModel!!.updateQuantity(id[0], quantity[0])
            viewModel!!.updatePrice(id[0], quantity[0] * tableCart.TablePrice)
        }
        startActivity(Intent(this@DetailedActivity, Mycart::class.java))
    }

    private fun setDataToWidgets() {
        tableNameTV!!.setText(table!!.tableName)
        tableBrandNameTV!!.setText(table!!.tableBrandName)
        tablePriceTV!!.setText(String.valueOf(table!!.tablePrice))
        tableImageView!!.setImageResource(table!!.tableImage)
    }


    private fun initializeVariables() {
        tableCartList = ArrayList<TableCart>()
        tableImageView = findViewById<ImageView>(com.android.mestore.R.id.detailActivityShoeIV)
        tableNameTV = findViewById<TextView>(com.android.mestore.R.id.detailActivityShoeNameTv)
        tableBrandNameTV = findViewById<TextView>(com.android.mestore.R.id.detailActivityShoeBrandNameTv)
        tablePriceTV = findViewById<TextView>(com.android.mestore.R.id.detailActivityShoePriceTv)
        addToCartBtn = findViewById<AppCompatButton>(com.android.mestore.R.id.detailActivityAddToCartBtn)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
    }
}