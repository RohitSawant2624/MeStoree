package com.android.mestore.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.android.mestore.dao.CartDAO
import com.android.mestore.database.CartDatabase
import com.android.mestore.utlis.model.TableCart
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class CartRepo (private var cartDAO: CartDAO){
    private var allCartItemsLiveData: LiveData<List<TableCart>>? = null
    private val executor: Executor = Executors.newSingleThreadExecutor()
    val allCartItems : LiveData<List<TableCart>> = cartDAO.getAllCartItems()
    fun getAllCartItemsLiveData(): LiveData<List<TableCart>>? {
        return allCartItemsLiveData
    }

    fun CartRepo(context: Context) {
        cartDAO = CartDatabase.getDatabase(context).cartDao()
        allCartItemsLiveData = cartDAO.getAllCartItems()
    }
    fun insertCartItem(tableCart: TableCart) {
        executor.execute(Runnable { cartDAO.insertCartItem(tableCart) })
    }
    fun deleteCartItem(tableCart: TableCart) {
        executor.execute { cartDAO.deleteCartItem(tableCart) }
    }

    fun updateQuantity(id: Int, quantity: Int) {
        executor.execute { cartDAO.updateQuantity(id, quantity) }
    }

    fun updatePrice(id: Int, price: Double) {
        executor.execute { cartDAO.updateTotalItemPrice(id, price) }
    }

    fun deleteAllCartItems() {
        executor.execute { cartDAO.deleteAllItems() }
    }


}